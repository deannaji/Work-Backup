package com.patterns.myPatternsProj.irerator;

import java.util.List;

public class PanCakeHouseMenuIterator implements Iterator
{

    private List<MenuItem> menu;
    private int position;
    
    
    public PanCakeHouseMenuIterator(List<MenuItem> menu)
    {
       this.menu = menu;
    }
    
    @Override
    public Object next()
    {
        MenuItem item = menu.get(position);
        position ++;
        return item;
    }

    @Override
    public boolean hasNext()
    {
        if(position >= menu.size()){
            return false;
        }
        return true;
    }
    

}
