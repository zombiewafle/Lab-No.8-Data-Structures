package  Classes;

import Interfaces.PriorityQueue;

import java.util.Vector;

/*
This whole class was extracted from the Java structure book.

Author:	Duane A Bailey
Year published: 2006
Book title: 	Java structures
City: 	[Williamstown, MA]
Publisher: 	[Williams College]
 */

/**
 * Uses the interface Priority Queue, the interface was extracted from:
 * https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
 * @param <E>
 */

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    /*
     * The data, kept in heap order.
     */

    protected Vector<E> data;  // the data, kept in heap order

    /**
     * Construct of the new instance of the VectorHeap
     */

    public VectorHeap()
    {
        data = new Vector<E>();
    }

    /**
     * Construct a new priority queue from an unordered vector
     * @param v
     */

    public VectorHeap(Vector<E> v)
    {
        int i;
        data = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++)
        {   // add elements to heap
            add(v.get(i));
        }
    }

    /**
     * Returns parent node at i
     * @param i
     * @return
     */

    protected static int parent(int i)
    {
        return (i-1)/2;
    }

    /**
     * Returns parent node at i
     * @param i
     * @return
     */

    protected static int left(int i)
    {
        return 2*i+1;
    }

    /**
     * Returns parent node at i
     * @param i
     * @return
     */

    protected static int right(int i)
    {
        return 2*(i+1);
    }

    /**
     * Returns first element
     * @return
     */

    public E getFirst()
    {
        return data.get(0);
    }

    /**
     * Returns and removes minimum value from queue
     * @return
     */

    public E remove()
    {
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    /**
     * Element is added to VectorHeap
     * @param value
     */

    public void add(E value)
    {
        data.add(value);
        percolateUp(data.size()-1);
    }

    /**
     * Returns 0 if the VectorHeap is empty
     * @return
     */

    public boolean isEmpty()
    {
        return data.size() == 0;
    }

    /**
     * Moves node to appropiate position upwards
     * @param leaf
     */

    protected void percolateUp(int leaf)
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    /**
     * Moves node to appropiate position downwards
     * @param root
     */

    protected void pushDownRoot(int root)
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos+1)).compareTo
                                (data.get(childpos)) < 0))
                {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo
                        (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root,value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root,value);
                return;
            }
        }
    }

    /**
     * Size of the VectorHeap
     * @return
     */
    public int size()
    {
        return data.size();
    }

    /**
     * Remove all the elements from the queue.
     */
    public void clear()
    {
        data.clear();
    }

    /*
     * Construct a string representation of the heap.
     */
    public String toString()
    {
        return "<VectorHeap: "+data+">";
    }

    @Override
    public int compareTo(E o) {
        return 0;
    }
}
