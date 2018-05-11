package com.patterns.myPatternsProj;

import com.patterns.myPatternsProj.decorator.Beverage;
import com.patterns.myPatternsProj.decorator.HouseBlend;
import com.patterns.myPatternsProj.decorator.Milk;

public class DecoratorPatternApp
{

    public static void main(String[] args)
    {
        Beverage houseBlend = new HouseBlend();
        Beverage houseBlendWithMilk = new Milk(houseBlend);

        System.out.println("Order: "+ houseBlendWithMilk.getDescription());
        System.out.println("Cost: "+ houseBlendWithMilk.cost());
    }
}
