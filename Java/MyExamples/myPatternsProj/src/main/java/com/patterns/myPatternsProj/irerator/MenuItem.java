package com.patterns.myPatternsProj.irerator;

public class MenuItem
{
    private String itemName;
    private double cost;
    
    public MenuItem(String name, double cost){
        this.itemName= name;
        this.cost = cost;
    }
    
    public MenuItem(){    
    }
    
    public String getItemName()
    {
        return itemName;
    }
    
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }
    
    public double getCost()
    {
        return cost;
    }
    
    public void setCost(double cost)
    {
        this.cost = cost;
    }
}
