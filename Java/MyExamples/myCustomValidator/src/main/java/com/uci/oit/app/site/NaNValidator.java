package com.uci.oit.app.site;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NaNValidator implements ConstraintValidator<NaN, CharSequence>
{

    @Override
    public void initialize(NaN annotation)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context)
    {
        try{
            double d = Double.parseDouble((String) value);
            return false;
        }
        catch(Exception e){
            return true;
        }
    }

}
