package ua.edu.ucu.tries;

import java.util.Arrays;

/**
 * Created by pryho on 08-Jan-17.
 */
public class Node {
    public static int R = 256;
    public Integer value;
    public Node[] next = new Node[R];


    @Override
    public String toString() {
        return "Node{" + "value = " + value + ", next = " + Arrays.toString(next) + '}';
    }
}
