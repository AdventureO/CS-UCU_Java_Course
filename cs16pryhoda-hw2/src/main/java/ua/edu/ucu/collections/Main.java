package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

/**
 * Created by pryho on 08-Jan-17.
 */
public class Main {
    public static void main(String[] args) {
        ImmutableLinkedList immutableLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{1, 245, 3765, 4, 4, 5, 643, 1019};
        for (int i = 0; i < 8; i++) {
            immutableLinkedList = immutableLinkedList.add(Data[i]);
        }
        System.out.println(immutableLinkedList.add(432));
        System.out.println(immutableLinkedList);

        System.out.println(immutableLinkedList.add(4, 111));
        System.out.println(immutableLinkedList);
    }
}
