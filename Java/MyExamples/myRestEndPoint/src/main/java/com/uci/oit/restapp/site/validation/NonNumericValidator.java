package com.uci.oit.restapp.site.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NonNumericValidator implements ConstraintValidator<NonNumeric, CharSequence>
{

    @Override
    public void initialize(NonNumeric annotation)
    {        
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context)
    {
       if(value.length() > 0)
         if(Character.isLetter(value.charAt(0)))
            return true;
        return false;
    }

}
