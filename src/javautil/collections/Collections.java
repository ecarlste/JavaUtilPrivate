/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javautil.collections;

import java.util.List;

/**
 *
 * @author es.carlsten
 */
public abstract class Collections
{
    public static void swap(List<?> list, int i, int j)
    {
        swapHelper(list, i, j);
    }
    
    private static <T> void swapHelper(List<T> list, int i, int j)
    {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
