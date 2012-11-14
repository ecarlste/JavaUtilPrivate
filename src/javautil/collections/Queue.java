
package javautil.collections;

import java.util.NoSuchElementException;

public class Queue<T> {
    
    QueueNode<T> head;
    QueueNode<T> tail;
    
    public boolean insert(T object)
    {
        QueueNode<T> newNode = new QueueNode<>(object);
        
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            tail.setNext(newNode);
        }
        
        tail = newNode;
        
        return true;
    }
    
    public T peek()
    {
        return head.getValue();
    }
    
    public T remove()
    {
        if (head != null)
        {
            T value = head.getValue();
            head = head.getNext();
            
            if (head == null)
            {
                
            }
            
            return value;
        }
        else
        {
            throw new NoSuchElementException();
        }
    }
    
    public boolean isEmpty()
    {
        return (head == null && tail == null);
    }
}
