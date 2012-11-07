/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import trees.Heap;

/**
 *
 * @author es.carlsten
 */
public class HeapTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Heap heap = new Heap();
        
        heap.add(new Integer(9));
        heap.add(new Integer(5));
        heap.add(new Integer(3));
        heap.add(new Integer(2));
        heap.add(new Integer(1));
        heap.add(new Integer(11));
        heap.add(new Integer(6));
        heap.add(new Integer(4));
        heap.add(new Integer(8));
        System.out.println(heap);
        System.out.println("removing" + heap.remove() + " : " + heap);
        System.out.println("removing" + heap.remove() + " : " + heap);
    }
}
