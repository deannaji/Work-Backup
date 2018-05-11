package com.mycollections.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class ArrayListTest
{

    List<String> sut= new ArrayList<>(); 
    
    @Before
    public void setup(){
    }
    

    @Test
    public void testAdd()
    {
        sut.add("Hello");
        sut.add("World");
        assertEquals(2, sut.size());
    }

    
    /**
     * Happy path:
     */
    @Test
    public void testGet()
    {
        sut.add("Hi There!");
        assertEquals("Hi There!", sut.get(0));
        assertNotEquals("hi there!", sut.get(0));
    }

    
    /**
     * With exception:
     */
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testGetException()
    {
        sut.add("Hi There!");
        sut.get(1);
    }
    
    
    /**
     * Happy path
     */
    @Test
    public void testRemove()
    {
        sut.add("Hi");
        sut.add("Test");
        sut.remove("Hi");
        //sut.remove("A");
        assertNotEquals("Hi", sut.get(0));
        assertEquals("Test", sut.get(0));
    }
    
    
    /**
     * Exception path
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testRemoveException()
    {
        sut.add("Hi");
        sut.add("Test");
        sut.remove("Hi");
        sut.remove("A");
    }
    

  
    @Test
    public void testFind()
    {
        sut.add("Hello");
        sut.add("World");
        sut.add("Junit");
        assertEquals(0 ,sut.find("Hello"));
        assertEquals(2 ,sut.find("Junit"));
        assertEquals(-1 ,sut.find("!"));
    }
    

    @Test
    public void testSize()
    {
        sut.add("Hello");
        sut.add("World");
        sut.add("Junit");
        assertEquals(3 ,sut.size());
    }
    
     
    /**
     * Ignored, testing the iterator in an other test case
     */
    @Ignore
    @Test
    public void testGetIterator()
    {
        fail("Not yet implemented");
    }

}
