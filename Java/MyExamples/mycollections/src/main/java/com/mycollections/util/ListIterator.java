package com.mycollections.util;


public class ListIterator<T> implements Iterator<T>
{

    private T[] items;
    private int position;
    
    
    public ListIterator(T[] list){
        this.items = list;
        this.position=0;
    }
    
    
    @Override
    public boolean hasNext()
    {
        if(items.length > position){
           return true;
        }else{
            return false;
        }
    }

    
    @Override
    public Object next()
    {
        Object result = items[position];
        position++;
        return result;
    }

}
