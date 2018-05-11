package com.uci.oit.pts.site.services;

import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

/**
 * @author najih
 *
 */
@Service
public class StringSanitizor implements StringSanitizationServiceInterface{

	@Override
	public String sanitizeWithHtmlEscape(String text) {
		//Input sanitization using HtmlUtils.  
		String sanitizedText = HtmlUtils.htmlEscape(text);
		return sanitizedText;
	}

}
