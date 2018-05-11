package com.patterns.myPatternsProj.decorator;


public class Milk extends CondimentDecorator
{
    Beverage beverage;
    
    public Milk(Beverage b){
        this.beverage = b;
    }
    
    @Override
    public String getDescription(){
        return this.beverage.getDescription()+ ", with milk!";
    }
    
    public double cost(){
        return this.beverage.cost()+ .05;
    }
}
