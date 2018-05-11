package com.mycollections.util.List;


public interface IntList
{
    public void add(int element);
    public int get(int index);
    public void remove(int element);
    /*Deprecated*///public int[] getAll();
    public int find(int element);
    public int size();
}
