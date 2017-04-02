package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testEnqueue() {
        String expectedResult = "123456";
        Queue queue = new Queue();
        int[] Data = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 6; i++) {
            queue.enqueue(Data[i]);
        }
        assertEquals(expectedResult, queue.toString());
    }
    @Test
    public void testDequeue() {
        String expectedResult = "23456";
        Queue queue = new Queue();
        int[] Data = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 6; i++) {
            queue.enqueue(Data[i]);
        }
        queue.dequeue();
        assertEquals(expectedResult, queue.toString());
    }

    @Test
    public void testPeek() {
        String expectedResult = "1";
        Queue queue = new Queue();
        int[] Data = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 6; i++) {
            queue.enqueue(Data[i]);
        }
        Object result = queue.peek();
        assertEquals(expectedResult, result.toString());
    }

    @Test
    public void testToString() {
        String expectedResult = "123456";
        Queue queue = new Queue();
        int[] Data = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 6; i++) {
            queue.enqueue(Data[i]);
        }
        Object result = queue.toString();
        assertEquals(expectedResult, result);
    }
    
}
