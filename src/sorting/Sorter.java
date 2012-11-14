
package sorting;

import collections.Arrays;
import java.util.ArrayList;

public abstract class Sorter {
    
    public static int[] insertionSort(int[] array)
    {
        // starting at index 1 of the array, we will compare an item with
        // everything to the left of it. Each time we insert a sorted item into
        // the right place in the left hand sorted section of the array, we'll
        // increment i.
        for (int i = 1; i < array.length; i++)
        {
            // during each iteration as we travel to the right of the array, we
            // first need to set our iterator that will move back to the left
            // as we find the correct place to put the item we are inserting
            // into the left side of the array. Since we know that at this point
            // everything to the left of index i is already sorted, we want our
            // new item to be inserted to be the first element to the right of 
            // the sorted section, which is at array[i].
            int j = i;
            
            // now we start moving our backwards iterator, j, to the left one
            // array slot at a time. During each iteration we'll check to see
            // if the item at array[j] is less than array[j-1], or the item to
            // the left. If it is then we swap them and compare again with the
            // next item to the left. We repeat this process until we either
            // find that array[j] is greater than or equal to the item to the
            // left, or that we reach the far left side of the array.
            while (j > 0 && array[j] < array[j-1])
            {
                // create a temp variable to allow us to swap array[j] with
                // array[j-1] and then swap the two.
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                
                j--;
            }
        }
        
        return array;
    }
    
    public static <T extends Comparable> void insertionSort2(ArrayList<T> array)
    {    
        for (int i = 1; i < array.size(); i++)
        {
            int j = i;
            
            //while (j > 0 && array[j] < array[j-1])
            while (j > 0 && array.get(j).compareTo(array.get(j-1)) == -1)
            {
                //int temp = array[j];
                T temp = array.get(j);
                //array[j] = array[j-1];
                array.set(j, array.get(j-1));
                //array[j-1] = temp;
                array.set(j-1, temp);
                
                j--;
            }
        }
    }
    
    public static int[] selectionSort(int[] array)
    {
        // for selection sort we are going to have a sorted side of the array
        // and also a non sorted side. The sorted side will be to the left of
        // array[i] and the non sorted side will start at array[i]. Since we
        // will be moving the smallest item in the unsorted portion to the end
        // of the sorted portion after each iteration of the outer for loop, we
        // do not need to do anything when we get to the last element of the
        // array. This is why we stop at array.length-1 rather than
        // array.length.
        for (int i = 0; i < array.length-1; i++)
        {
            // This variable will keep track of the index of the smallest
            // element found during this pass of the unsorted portion of the
            // array. Since we start at i, that will be the smallest as we
            // start each iteration of the outer loop.
            int minIndex = i;
            
            // this inner for loop starts at i+1 and searches through the entire
            // remaining unsorted array to see if it can find an item that is
            // less than what is currently at array[minIndex]
            for (int j = i+1; j < array.length; j++)
            {
                // during each iteration of this inner loop, check to see if the
                // item we are currently looking at is less than the item at
                // array[minIndex]. If it is less, we need to change our
                // minIndex to be set to the current index we are looking at, in
                // this case j.
                if (array[j] < array[minIndex])
                {
                    minIndex = j;
                }
            }
            
            // once we have found the smallest element in the unsorted portion
            // of the array, we need to swap it with the item at index i. But we
            // don't want to do this if they are the same index, so if minIndex
            // equals i, then do nothing, otherwise we need to perform the swap.
            if (minIndex != i)
            {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        
        return array;
    }
    
    public static int[] mergeSort(int[] array)
    {
        if (array.length > 1)
        {
            int splitIndex = (array.length-1)/2;
            
            int[] slice1 = Arrays.slice(array, 0, splitIndex);
            int[] slice2 = Arrays.slice(array, splitIndex+1, array.length-1);
            
            slice1 = mergeSort(slice1);
            slice2 = mergeSort(slice2);
            
            array = sortedMerge(slice1, slice2);
        }
        
        return array;
    }
    
    public static int[] sortedMerge(int[] array1, int[] array2)
    {
        int totalMerges = array1.length + array2.length;
        int[] merged = new int[totalMerges];
        
        int i1 = 0;
        int i2 = 0;
        
        for (int mergeCount = 0; mergeCount < totalMerges; mergeCount++)
        {
            if (i1 == array1.length)
            {
                merged[mergeCount] = array2[i2];
                i2++;
            }
            else if (i2 == array2.length)
            {
                merged[mergeCount] = array1[i1];
                i1++;
            }
            else if (array1[i1] <= array2[i2])
            {
                merged[mergeCount] = array1[i1];
                i1++;
            }
            else
            {
                merged[mergeCount] = array2[i2];
                i2++;
            }
        }
        
        return merged;
    }
    
}
