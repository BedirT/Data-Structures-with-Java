/**
 * LinkedQueue represents a linked implementation of a queue.
 *
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 08/12/08
 */
package datastructures;

import datastructures.exceptions.*;

public class LinkedQueue<T> implements QueueADT<T> {

    private int count;
    private LinearNode<T> front, rear;

    /**
     * Creates an empty queue.
     */
    public LinkedQueue() {
        count = 0;
        front = rear = null;
    }

    /**
     * Adds the specified element to the rear of this queue.
     *
     * @param element the element to be added to the rear of this queue
     */
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<T>(element);
        if (isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }
        rear = node;
        count++;
    }

    /**
     * Removes the element at the front of this queue and returns a reference to
     * it. Throws an EmptyCollectionException if the queue is empty.
     *
     * @return the element at the front of this queue
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        T result = front.getElement();
        front = front.getNext();
        count--;
        if (isEmpty()) {
            rear = null;
        }
        return result;
    }

    public boolean isEmpty() {
        return count == 0;   
    }

    @Override
    public T first() {
        if(isEmpty())
            return null;
        else
            return (T) front;
    }

    @Override
    public int size() {
        return count;
    }
}
