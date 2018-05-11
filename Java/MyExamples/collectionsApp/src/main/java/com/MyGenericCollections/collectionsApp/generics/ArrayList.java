package com.MyGenericCollections.collectionsApp.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList<T> implements List<T>
{
    int[] array;

    @Override
    public void add(int item)
    {
        //int size=this.array.length;
        if(this.array.length <=0 ){
            this.array[0]=(int) item;
        }else{    
       int[] tempArray = new int[ this.array.length+1];
        for(int i=0; i<=this.array.length-1; i++){
           tempArray[i] = (int) array[i];
        }
        tempArray[tempArray.length-1]=(int) item;
        this.array= tempArray;
        }
        
    }

    @Override
    public Object get(int index)
    {
        if(this.array.length-1 >= index)
            return this.array[index];
         return null;
    }

    @Override
    public int size()
    {
        return this.array.length;
    }
    
    @Override
    public int[] toArray(){
        return this.array;
     }

}
