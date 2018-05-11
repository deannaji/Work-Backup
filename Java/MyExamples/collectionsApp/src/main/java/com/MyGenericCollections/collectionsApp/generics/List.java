package com.MyGenericCollections.collectionsApp.generics;


public interface List<T>
{
    void add(int item);
    
    Object get(int index);
    
    int size();
    
    int[] toArray();
}
