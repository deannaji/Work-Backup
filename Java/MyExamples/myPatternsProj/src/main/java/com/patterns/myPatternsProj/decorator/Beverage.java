package com.patterns.myPatternsProj.decorator;


public abstract class Beverage
{
    private String description="Un identified beverage";
    
    public String getDescription(){
        return description;
    }
    
    public abstract double cost();
}
