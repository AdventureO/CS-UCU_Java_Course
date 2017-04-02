package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    ImmutableLinkedList myStack = new ImmutableLinkedList();

    Object peek(){
        return myStack.getLast();
    }
    Object pop(){
        Object lastElement = myStack.getLast();
        myStack = myStack.remove(-1);
        return  lastElement;
    }
    void pop(Object e){
        myStack = myStack.add(e);
    }

    public String toString(){
        String dataStack = "";
        int i = 0;
        while(i < myStack.size()){
            dataStack += myStack.get(i).toString();
            i++;
        }
        return dataStack;
    }
}
