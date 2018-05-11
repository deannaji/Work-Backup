package com.uci.oit.restapp.site.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotBlankValidator implements ConstraintValidator<NotEmpty, CharSequence>
{

    @Override
    public void initialize(NotEmpty annotation)
    {        
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context)
    {
        if(value instanceof String)
            return ((String) value).trim().length() > 0;
        return value.toString().trim().length() > 0;
    }

}
