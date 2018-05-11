package com.MyGenericCollections.collectionsApp;

import com.MyGenericCollections.collectionsApp.generics.ArrayList;
import com.MyGenericCollections.collectionsApp.generics.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Integer> a1 = new ArrayList<Integer>();
        a1.add(3);
        a1.add(4);
        a1.add(5);
        
        //System.out.println(a1.get(0));
        //System.out.println(a1.get(1));
        //System.out.println(a1.get(3));
        
        //System.out.println("Size = "+a1.size());
        int[] result = a1.toArray();
          
        for(int item : result){
           System.out.print(item+", ");
        }
       
      }
}

