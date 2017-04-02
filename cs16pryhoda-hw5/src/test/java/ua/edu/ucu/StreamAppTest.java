package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.stream.AsIntStream;
import ua.edu.ucu.stream.IntStream;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author andrii
 */
public class StreamAppTest {
    
    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }
    
    @Test
    public void testStreamOperations() {
        System.out.println("streamOperations");
        int expResult = 42;
        int result = StreamApp.streamOperations(intStream);
        assertEquals(expResult, result);        
    }

    @Test
    public void testStreamToArray() {
        System.out.println("streamToArray");
        int[] expResult = {-1, 0, 1, 2, 3};
        int[] result = StreamApp.streamToArray(intStream);
        assertArrayEquals(expResult, result);        
    }

    @Test
    public void testStreamForEach() {
        System.out.println("streamForEach");
        String expResult = "-10123";
        String result = StreamApp.streamForEach(intStream);
        assertEquals(expResult, result);        
    }

    @Test
    public void testStreamAverage() {
        int[] intArray = {0, 1, 2, 3, 4, 5, 6};
        assertEquals((Double) 3.0d, AsIntStream.of(intArray).average());
    }
    @Test
    public void testStreamMax() {
        int[] intArray = {0, 1, 2, 3, 4, 5, 6};
        assertEquals( 6, (int) AsIntStream.of(intArray).max());
    }
    @Test
    public void testStreamMin() {
        int[] intArray = {0, 1, 2, 3, 4, 5, 6};
        assertEquals( 0, (int) AsIntStream.of(intArray).min());
    }
    @Test
    public void testStreamCount() {
        int[] intArray = {0, 1, 2, 3, 4, 5, 6};
        assertEquals( 7, (int) AsIntStream.of(intArray).count());
    }

    @Test
    public void testStreamFilter() {
        int[] intArray = {0, 1, 2, 3, 4, 5, 6};
        assertEquals("[3, 4, 5, 6]", Arrays.toString(AsIntStream.of(intArray).filter(value ->(value > 2)).toArray()));
    }
    
}
