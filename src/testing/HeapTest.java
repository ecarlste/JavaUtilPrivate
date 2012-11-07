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
        System.out.print(heap);
        heap.add(new Integer(5));
        System.out.print(heap);
        heap.add(new Integer(3));
        System.out.print(heap);
        heap.add(new Integer(2));
        System.out.print(heap);
        heap.add(new Integer(1));
        System.out.print(heap);
    }
}
