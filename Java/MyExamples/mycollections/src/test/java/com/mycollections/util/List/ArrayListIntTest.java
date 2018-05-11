package com.mycollections.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.mycollections.util.Iterator;


public class ArrayListIntTest
{
    List<String> sut;

    @Before
    public void setup(){
        sut = new ArrayList<>();
    }
    
    @Test
    public void testGetIterator()
    {
        String[] tempArray={"","",""};
        
        sut.add("test1");
        sut.add("test2");
        sut.add("test3");
        
        Iterator<String> iterator = sut.getIterator();
        int count=0;
        while(iterator.hasNext()){
            tempArray[count]=(String) iterator.next();
            count++;
        }
        assertEquals("test1",tempArray[0]);
        assertEquals("test2",tempArray[1]);
        assertEquals("test3",tempArray[2]);
    }

}
