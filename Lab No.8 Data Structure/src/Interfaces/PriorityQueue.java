package Interfaces;

//This interface determinates

public interface PriorityQueue<E> extends  Comparable<E>{

    public E getFirst();

    public E remove();

    public void add(E value);

    public int size();

    public boolean isEmpty();


}
