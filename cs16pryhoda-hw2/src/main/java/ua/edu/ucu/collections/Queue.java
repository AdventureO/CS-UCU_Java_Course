package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList myQueue = new ImmutableLinkedList();

    Object peek(){
        return myQueue.getFirst();
    }

    Object dequeue(){
        Object firstElement = myQueue.getFirst();
        myQueue = myQueue.remove(0);
        return firstElement;
    }

    void  enqueue(Object e){
        myQueue = myQueue.add(e);
    }

    public String toString(){
        String dataQueue = "";
        int i = 0;
        while(i < myQueue.size()){
            dataQueue += myQueue.get(i).toString();
            i++;
        }
        return dataQueue;
    }
}

