/**
 * @author Lewis and Chase
 *
 * Represents a linked implementation of a stack.
 */
package datastructures;
import datastructures.exceptions.EmptyCollectionException;
public class LinkedStack<T> implements StackADT<T>
{
    /** indicates number of elements stored */
    private int count;
    /** pointer to top of stack */
    private LinearNode<T> top;/**
                               * Creates an empty stack.
                               */
    public LinkedStack()
    {
        count = 0;
        top = null;
    }
    /**
     * Adds the specified element to the top of this stack.
     * @param element element to be pushed on stack
     */
    @Override
    public void push (T element)
    {
        LinearNode<T> temp = new LinearNode<> (element);
        temp.setNext(top);
        top = temp;
        count++;
    }
    /**
     * Removes the element at the top of this stack and returns a
     * reference to it. Throws an EmptyCollectionException if the stack
     * is empty.
     * @return T element from top of stack
     */
    @Override
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("Stack");
        T result = top.getElement();
        top = top.getNext();
        count--;
        return result;
    }

    @Override
    public T peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        
        return top == null;
        
    }

    @Override
    public int size() {
        
        return count;
        
    }
    
    @Override
    public String toString(){
        
        String str = "";
        LinearNode<T> ptr = top;
        while (ptr.getNext() != null) {
            ptr = ptr.getNext();
            str += ptr.getElement() + ", ";
        }
        return str;
        
    }

}