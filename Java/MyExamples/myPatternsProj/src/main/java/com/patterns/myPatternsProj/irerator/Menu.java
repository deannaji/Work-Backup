package com.patterns.myPatternsProj.irerator;


public interface Menu
{
    public Iterator createIterator();
    public void addItem(MenuItem item);
    public void removeItem(MenuItem item);
}
