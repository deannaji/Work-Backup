package com.patterns.myPatternsProj.decorator;


public class HouseBlend extends Beverage
{
    private String description="House Blend coffee";
    
    public String getDescription(){
        return this.description;
    }
    
    @Override
    public double cost(){
        return 1.00;
    }
}
