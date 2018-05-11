package com.uci.oit.restapp.site;

import java.util.Hashtable;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uci.oit.restapp.annotations.RestEndpoint;

@RestEndpoint
public class IndexRestEndpoint
{
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value={"","/"}, method=RequestMethod.GET)
    public Map<String, Object> discoverJson(){
        
        Map<String, JsonLink> links = new Hashtable<>();
        links.put("self", new JsonLink(getUriBuilder().path("").build().toString()));
        links.put("account", new JsonLink(getUriBuilder().path("/account/?").build().toString()));
        links.put("add", new JsonLink(getUriBuilder().path("/add").build().toString()));
        links.put("all", new JsonLink(getUriBuilder().path("/all").build().toString()));
        links.put("options", new JsonLink(getUriBuilder().path("/options").build().toString()));
        
        Map<String, Object> response = new Hashtable<>(1);
        response.put("_links", links);
        return response;
    }
    
    private ServletUriComponentsBuilder getUriBuilder(){
        return ServletUriComponentsBuilder.fromCurrentServletMapping();
    }
    
    
    public static class JsonLink
    {
        private String href;

        public JsonLink(String href)
        {
            this.href = href;
        }

        @XmlAttribute
        public String getHref()
        {
            return href;
        }

        public void setHref(String href)
        {
            this.href = href;
        }
    }

    
   /* public static class Link extends JsonLink
    {
        private String rel;

        public Link(String rel, String href)
        {
            super(href);
            this.rel = rel;
        }

        @XmlAttribute
        public String getRel()
        {
            return rel;
        }

        public void setRel(String rel)
        {
            this.rel = rel;
        }
    }*/
}
