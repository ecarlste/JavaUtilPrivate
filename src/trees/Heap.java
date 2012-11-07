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
public class Heap <T extends Comparable>
{
    
    private ArrayList<T> items;
    
    public Heap()
    {
        items = new ArrayList<>();
    }
    
    public void add(T o)
    {
        // add the new item at the end of the list
        items.add(o);
        
        // bubble up the item added until the heap properties have been restored
        heapifyUp(items.size()-1);
    }
    
    public T remove()
    {
        // save a copy of the item at the head of the array list, since this is
        // the item with top priority
        T temp = items.get(0);
        
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
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }   
    }
    
    private void heapifyDown(int index)
    {
        int lowestIndex;
        int leftChildIndex;
        int rightChildIndex;
        
        boolean doneSwapping = false;
        
        while (!doneSwapping)
        {
            lowestIndex = index;
            leftChildIndex = getLeftChildIndex(lowestIndex);
            rightChildIndex = getRightChildIndex(lowestIndex);
            
            if (leftChildIndex < items.size() &&
                items.get(lowestIndex).compareTo(items.get(leftChildIndex)) == 1)
            {
                lowestIndex = leftChildIndex;
            }
            
            if (rightChildIndex < items.size() &&
                items.get(lowestIndex).compareTo(items.get(rightChildIndex)) == 1)
            {
                lowestIndex = rightChildIndex;
            }
            
            if (lowestIndex != index)
            {
                swap(lowestIndex, index);
                index = lowestIndex;
            }
            else
            {
                doneSwapping = true;
            }
        }
    }
    
    private void swap(int index1, int index2)
    {
        T temp = items.get(index1);
        
        items.set(index1, items.get(index2));
        
        items.set(index2, temp);
    }
    
    @Override
    public String toString()
    {
        String heapString = "[";
        
        boolean firstItemPrinted = false;
        
        for (T item : items)
        {
            if (firstItemPrinted)
            {
                heapString += ",";
            }
            else
            {
                firstItemPrinted = true;
            }
            
            heapString += item;
        }
        
        heapString += "]";
        
        return heapString;
    }
    
}
