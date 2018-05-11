package com.mycollections.app;

import com.mycollections.util.Iterator;
import com.mycollections.util.List.ArrayList;
import com.mycollections.util.List.IntArrayList;
import com.mycollections.util.List.IntList;
import com.mycollections.util.List.List;

public class Main
{
    public static void main(String[] args){
        /*IntList array = new IntArrayList();
        array.add(9);
        array.add(2);
        array.add(7);
        array.add(3);
        
        array.remove(7);
        
        for(int i=0; i<= array.size()-1; i++){
          System.out.println(array.get(i));
        }*/
        
        
        /*List<String> letters = new ArrayList<>();
        letters.add("Hello");
        letters.add("World");
        letters.add("!");
        letters.remove("!");
        
        for(int i=0; i<= letters.size()-1; i++){
            System.out.print(letters.get(i)+" ");
        }
        System.out.println();
        
        
        
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(10);
        nums.add(9);
        nums.add(15);
        nums.remove(9);
        
        for(int i=0; i<= nums.size()-1; i++){
            System.out.println(nums.get(i));
        }
        
        
        System.out.println("Using List Iterator:");
        Iterator<Integer> iterator = nums.getIterator();      
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        
        java.util.List<String> a1 = new java.util.ArrayList<>();
        a1.add("Hello");
        System.out.println(a1.get(0));
        //a1.remove(1);
        
        
    }
}
