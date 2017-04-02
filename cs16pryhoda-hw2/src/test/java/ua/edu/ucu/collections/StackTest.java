package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPeek() {
        String expectedResult = "6";
        Stack stack = new Stack();
        int[] Data = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 6; i++) {
            stack.pop(Data[i]);
        }
        Object result = stack.peek();
        assertEquals(expectedResult, result.toString());
    }

    @Test
    public void testPopWithElement() {
        String expectedResult = "1234567";
        Stack stack = new Stack();
        int[] Data = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 6; i++) {
            stack.pop(Data[i]);
        }
        stack.pop("7");
        assertEquals(expectedResult, stack.toString());
    }

    @Test
    public void testPop() {
        String expectedResult = "12345";
        Stack stack = new Stack();
        int[] Data = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 6; i++) {
            stack.pop(Data[i]);
        }
        stack.pop();
        assertEquals(expectedResult, stack.toString());
    }

    @Test
    public void testToString() {
        String expectedResult = "123456";
        Stack stack = new Stack();
        int[] Data = new int[]{1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 6; i++) {
            stack.pop(Data[i]);
        }
        assertEquals(expectedResult, stack.toString());
    }
    
}
