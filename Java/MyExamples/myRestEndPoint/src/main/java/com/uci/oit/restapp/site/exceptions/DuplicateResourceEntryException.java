package com.uci.oit.restapp.site.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class DuplicateResourceEntryException extends RuntimeException
{
    
    public DuplicateResourceEntryException(String message){
        super(message);
    }
    
}
