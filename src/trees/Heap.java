/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.ArrayList;

/**
 *
 * @author es.carlsten
 */
public class Heap
{
    
    private ArrayList<Integer> items;
    
    public Heap()
    {
        items = new ArrayList<>();
    }
    
    public void add(Integer integer)
    {
        // add the new item at the end of the list
        items.add(integer);
        
        // bubble up the item added until the heap properties have been restored
        heapifyUp(items.size()-1);
    }
    
    public Integer remove()
    {
        // save a copy of the item at the head of the array list, since this is
        // the item with top priority
        Integer temp = items.get(0);
        
        // remove the item from the end of the array list and put it in the
        // beginning of the array list
        items.set(0, items.remove(items.size()-1));
        
        // tunnel down the item moved from the end of the array list in order to
        // maintain the heap properties
        heapifyDown(0);
        
        return temp;
    }
    
    private int getParentIndex(int childIndex)
    {
        return (childIndex - 1) / 2;
    }
    
    private int getLeftChildIndex(int parentIndex)
    {
        return parentIndex * 2 + 1;
    }
    
    private int getRightChildIndex(int parentIndex)
    {
        return getLeftChildIndex(parentIndex) + 1;
    }
    
    private void heapifyUp(int index)
    {
        int parentIndex = getParentIndex(index);
        
        // continue to bubble up the inserted object until we are at the top
        // of the heap or until the item
        while (index != 0 && items.get(index).compareTo(items.get(parentIndex)) == -1)
        {
            parentIndex = getParentIndex(index);
            swap(index, parentIndex);
            index = parentIndex;
        }   
    }
    
    private void heapifyDown(int index)
    {
        
    }
    
    private void swap(int index1, int index2)
    {
        Integer temp = items.get(index1);
        
        items.set(index1, items.get(index2));
        
        items.set(index2, temp);
    }
    
}
