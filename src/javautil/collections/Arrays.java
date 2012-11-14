
package javautil.collections;

import java.util.ArrayList;
import java.util.Random;

// The ArrayUtil class provides several utility methods which operate on arrays
// of int. These should most certainly be made to be generic, but for the case
// of this demo that is not needed.

// NOTE: I use a static method call here to System.arraycopy() in several
// places. This simply copies the contents of one array into another. Another
// common way to do this is by writing your own for loop and calling
// a1[i] = a2[i] , but since there is a built in Java utility that does this
// very efficiently we might as well use it.

public abstract class Arrays
{
    
    // This method takes two arrays in as input parameters and concatenates
    // them. After the arrays have been concatenated in order of
    // [array1 + array2], the combined array which contains all items from both
    // arrays is returned.
    public static int[] concat(int[] array1, int[] array2)
    {
        // create an array which will hold array1.length+array2.length elements
        // this array will store the result of our concatenation before we
        // return
        int[] concatenatedArray = new int[array1.length+array2.length];
        
        // Since there is no built in operator for arrays in general, like we
        // are given for strings that allows for concatenation using the +, we
        // need to copy the contents of the first array into the beginning of
        // our contatenated array, and then copy the contents of the second
        // array into the latter portion of our concatenated array.
        System.arraycopy(array1, 0, concatenatedArray, 0, array1.length);
        System.arraycopy(array2, 0, concatenatedArray, array1.length+1,
                         array2.length);
        
        return concatenatedArray;
    }
    
    // This method takes an array, a starting index and an ending index as
    // input parameters. The slice method takes only a specific portion of the
    // array, which starts at array[startIndex] and ends at array[endIndex], and
    // copies only those elements into a smaller array. This smaller array is
    // the slice we are going to return.
    public static int[] slice(int[] array, int startIndex, int endIndex)
    {
        // first, we need to make an array that is the appropriate size to hold
        // our slice. The size of this array is found by subtracting startIndex
        // from endIndex and then adding 1. If we were creating a slice from
        // indices 3 and 7, we would want [3,4,5,6,7], which would mean we need
        // an array of length 5, which is 7-3+1.
        int[] arraySlice = new int[endIndex-startIndex+1];
        
        // copy the contents of the designated portion of the array into our
        // newly created slice.
        System.arraycopy(array, startIndex, arraySlice, 0, arraySlice.length);
        
        return arraySlice;
    }

    // This method simply prints an array in a readable fasion. If a prefix
    // string is provided the output looks as follows:
    //
    // My Custom Prefix String: [7, 9, 2, 9, 1, 10]
    //
    // If no prefix is used, then the array simply prints as follows:
    //
    // [7, 9, 2, 9, 1, 10]
    public static void printArray(int[] array, String prefix)
    {
        if (prefix != null) {
            System.out.println(prefix + ": ");
        }
        System.out.print("[");
        if (array.length > 0) {
            System.out.print(array[0]);
            for (int i = 1; i < array.length; i++) {
                System.out.print("," + array[i]);
            }
        }
        System.out.println("]");
    }

    public static <T> void printArrayList(ArrayList<T> alist, String prefix)
    {
        if (prefix != null) {
            System.out.println(prefix + ": ");
        }
        System.out.print("[");
        if (alist.size() > 0) {
            System.out.print(alist.get(0));
            for (int i = 1; i < alist.size(); i++) {
                System.out.print("," + alist.get(i));
            }
        }
        System.out.println("]");
    }

    // This method takes in a single int as an input parameter. This parameter,
    // length, determines the size of the random array of int to make. Once the
    // random array of int is created, it is returned.
    public static int[] makeRandomArray(int length)
    {
        Random rand = new Random();
        int[] randomArray = new int[length];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rand.nextInt(length);
        }
        return randomArray;
    }
    
}
