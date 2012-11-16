/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javautil.sorting;

import java.util.List;

/**
 *
 * @author es.carlsten
 */
public class RunnableQuickSort<T extends Comparable<? super T>> implements Runnable {
    
    private List<T> list;
    private int leftIndex;
    private int rightIndex;
    
    public RunnableQuickSort(List<T> list, int leftIndex, int rightIndex)
    {
        this.list = list;
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }

    @Override
    public void run() {
        Sorter.quickSort(list, leftIndex, rightIndex);
    }
    
}
