package com.patterns.myPatternsProj;

import com.patterns.myPatternsProj.irerator.Iterator;
import com.patterns.myPatternsProj.irerator.Menu;
import com.patterns.myPatternsProj.irerator.MenuItem;
import com.patterns.myPatternsProj.irerator.PanCakeHouseMenu;
import com.patterns.myPatternsProj.irerator.PanCakeHouseMenuIterator;

public class IteratorPatternApp
{
    public static void main(String[] args){
       Menu panCakeHouse = new PanCakeHouseMenu();
       panCakeHouse.addItem(new MenuItem("Black Tea",1.0));
       panCakeHouse.addItem(new MenuItem("Coffee",2.0));
       panCakeHouse.addItem(new MenuItem("Pan cake with honey",6.99));
       panCakeHouse.addItem(new MenuItem("Pan cake with jam",5.99));
       
       Iterator iterator = panCakeHouse.createIterator();
       System.out.println("PanCake House Menu: ");
       System.out.println("------------------");
       while(iterator.hasNext()){
           MenuItem item = (MenuItem) iterator.next();
           System.out.println(item.getItemName()+" --- $"+item.getCost());
       }
       
    }
}
