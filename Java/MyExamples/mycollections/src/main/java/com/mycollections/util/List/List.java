package com.mycollections.util.List;

import com.mycollections.util.Iterator;

public interface List<T>
{
    public void add(T element);
    public T get(int index);
    public void remove(T element);
    /*Deprecated*///public int[] getAll();
    public int find(T element);
    public int size();
    public Iterator<T> getIterator();
}
