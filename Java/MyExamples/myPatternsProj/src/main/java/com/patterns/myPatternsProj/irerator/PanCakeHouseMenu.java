package com.patterns.myPatternsProj.irerator;

import java.util.ArrayList;
import java.util.List;

public class PanCakeHouseMenu implements Menu
{
    private List<MenuItem> menu;
    
    public PanCakeHouseMenu(){
       menu = new ArrayList<>();
       MenuItem item = new MenuItem();
    }
    
    @Override
    public void addItem(MenuItem item){
        menu.add(item);
    }
    
    @Override
    public void removeItem(MenuItem item){
        menu.remove(item);
    }

    
    @Override
    public Iterator createIterator()
    {
        return new PanCakeHouseMenuIterator(this.menu);
    }

    
    
}
