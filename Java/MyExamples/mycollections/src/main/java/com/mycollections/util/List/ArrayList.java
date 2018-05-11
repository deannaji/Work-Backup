package com.mycollections.util.List;

import java.lang.reflect.Array;

import com.mycollections.util.Iterator;
import com.mycollections.util.ListIterator;

@SuppressWarnings("unchecked")
public class ArrayList<T> implements List<T>
{
    private T[] items;
    private int size;
    
    
    public ArrayList(){
        //this.items = null;
        this.size = 0;
    }
    
    
    @Override
    public void add(T element)
    {
        if(this.size == 0){
            this.items = (T[]) Array.newInstance(element.getClass(),1);
            this.items[0] = element;
            this.size++;
        }else{
            T[] cloneItems = (T[]) Array.newInstance(element.getClass(), size+1);
            for(int i=0; i<= items.length-1;i++){
                cloneItems[i] = items[i];
            }
            cloneItems[size] = element;
            this.items = (T[]) Array.newInstance(element.getClass(), size+1);
            this.items = cloneItems;
            this.size++;
        }
        
    }

    
    @Override
    public T get(int index)
    {
        if(this.size == 0){
            return null;
         }else{
             return this.items[index];
         }
    }

    
    @Override
    public void remove(T element)
    {
        boolean found= false;
        for (int i=0; i<=items.length-1;i++){
            if(items[i] == element){
                items[i] = null;
                found=true;
            }
        }
        if(found == true){
            T[] tempArray = (T[]) Array.newInstance(element.getClass(), size-1);
            int pos = 0;
            for (int i=0; i<=items.length-1;i++){
                 if(items[i] != null && pos <= size-1){
                     tempArray[pos] = items[i];
                     pos++;
                 }
            }
            items = tempArray;
            size--;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    
    @Override
    public int find(T element)
    {
        if(this.size == 0){
            return -1;
         }else{
             for (int i=0; i<=items.length-1;i++){
                 if(items[i] == element){
                     return i;
                 }
             }
             return -1;
         }
    }

    
    @Override
    public int size()
    {
        return this.size;
    }


    @Override
    public Iterator<T> getIterator()
    {
        Iterator<T> listIterator = new ListIterator<>(this.items); 
        return listIterator;
    }

}
