package com.mycollections.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mycollections.util.Iterator;
import com.mycollections.util.ListIterator;


public class ListIteratorTest
{
    String[] array= {"Hello","World","Junit"};
    Iterator<String> sut = new ListIterator<>(array);

    @Test
    public void testHasNext()
    {
        assertTrue(sut.hasNext());
        for(int i=0; i<=3-1;i++){
           sut.next();
        }
        assertFalse(sut.hasNext());
    }

    
    @Test
    public void testNext()
    {
        assertEquals("Hello",sut.next());
        assertEquals("World",sut.next());
        assertEquals("Junit",sut.next());
    }
    
    
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testNextException()
    {
        assertEquals("Hello",sut.next());
        assertEquals("World",sut.next());
        assertEquals("Junit",sut.next());
        sut.next();
    }

}
