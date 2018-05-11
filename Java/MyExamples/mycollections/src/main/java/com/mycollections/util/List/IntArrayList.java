package com.mycollections.util.List;


public class IntArrayList implements IntList
{

    private int[] items;
    private int size;
    
    public IntArrayList(){
        //this.items = null;
        this.size = 0;
    }
    
    @Override
    public void add(int element)
    {
        if(this.size == 0){
            this.items = new int[1];
            this.items[0] = element;
            this.size++;
        }else{
            int[] cloneItems = new int[size+1];
            for(int i=0; i<= items.length-1;i++){
                cloneItems[i] = items[i];
            }
            cloneItems[size] = element;
            this.items = new int[size+1];
            this.items = cloneItems;
            this.size++;
        }
    }

    @Override
    public int get(int index)
    {
        if(this.size == 0){
           return 0;
        }else{
            return this.items[index];
        }
    }

    @Override
    public void remove(int element)
    {
        boolean found= false;
        for (int i=0; i<=items.length-1;i++){
            if(items[i] == element){
                items[i] = 0;
                found=true;
            }
        }
        if(found == true){
            int[] tempArray = new int[size-1];
            int pos = 0;
            for (int i=0; i<=items.length-1;i++){
                 if(items[i] != 0 && pos <= size-1){
                     tempArray[pos] = items[i];
                     pos++;
                 }
            }
            items = tempArray;
            size--;
        }
    }

    /**Deprecated
    /*@Override
    public int[] getAll()
    {
        return this.items;
    }*/

    @Override
    public int find(int element)
    {
        if(this.size == 0){
            return 0;
         }else{
             for (int i=0; i<=items.length-1;i++){
                 if(items[i] == element){
                     return items[i];
                 }
             }
             return 0;
         }
    }

    @Override
    public int size()
    {
        return this.size;
    }

}
