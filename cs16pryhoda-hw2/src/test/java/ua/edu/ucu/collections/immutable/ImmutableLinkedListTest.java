package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ImmutableLinkedListTest {
    
    @Test
    public void testAdd() {
        String expectedResult = "1 -> 245 -> 3765 -> 4 -> 4 -> 5 -> 643 -> 1019";
        String expectedResult1 = "456";
        ImmutableLinkedList immutableLinkedList = new ImmutableLinkedList();
        ImmutableLinkedList immutableLinkedList1 = new ImmutableLinkedList();
        int[] Data = new int[]{1, 245, 3765, 4, 4, 5, 643, 1019};
        for (int i = 0; i < 8; i++) {
            immutableLinkedList = immutableLinkedList.add(Data[i]);
        }
        immutableLinkedList1 = immutableLinkedList1.add(456);
        assertEquals(expectedResult, immutableLinkedList.toString());
        assertEquals(expectedResult1, immutableLinkedList1.toString());
    }

    @Test
    public void testAddElementWithIndex() {
        String expectedResult = "890 -> 2 -> 458 -> 132 -> 98 -> 564 -> 465 -> 1000 -> 90";
        String expectedResult1 = "120 -> 9 -> 34 -> 67";
        ImmutableLinkedList immutableLinkedList = new ImmutableLinkedList();
        ImmutableLinkedList immutableLinkedList1 = new ImmutableLinkedList();
        int[] Data = new int[]{890, 2, 458, 132, 564, 465, 1000, 90};
        int[] Data1 = new int[]{9, 34, 67};
        for (int i = 0; i < 8; i++) {
            immutableLinkedList = immutableLinkedList.add(Data[i]);
        }
        for (int i = 0; i < 3; i++){
            immutableLinkedList1 = immutableLinkedList1.add(Data1[i]);
        }
        immutableLinkedList = immutableLinkedList.add(4, 98);
        immutableLinkedList1 = immutableLinkedList1.add(0, 120);
        assertEquals(expectedResult, immutableLinkedList.toString());
        assertEquals(expectedResult1, immutableLinkedList1.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddElementWithIndexException() {
        String expectedResult = "";
        ImmutableLinkedList immutableLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{34, 65, 18};
        for (int i = 0; i < 3; i++) {
            immutableLinkedList = immutableLinkedList.add(Data[i]);
        }
        immutableLinkedList = immutableLinkedList.add(1093, 4678);
        assertEquals(expectedResult, immutableLinkedList.toString());
    }


    @Test
    public void testReturnNewLInkedList() {
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{890, 2, 458, 132, 564, 465, 1000, 90};
        for (int i = 0; i < 8; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        LinkedNode result = newLinkedList.cloneLinkedList();
        assertEquals(result.getData().toString(), newLinkedList.head.getData().toString());
    }

    @Test
    public void testCloneLinkedList() {
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{890, 2, 458, 132, 564, 465, 1000, 90};
        for (int i = 0; i < 8; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        assertEquals(newLinkedList.head.getData().toString(), newLinkedList.cloneLinkedList().getData().toString());
    }

    @Test
    public void testAddAll() {
        String expectedResult = "25 -> 33 -> 890 -> 111 -> 4 -> 6 -> 12";
        String expectedResult1 = "25 -> 33 -> 4 -> 6 -> 12 -> 890 -> 111";
        String expectedResult3 = "4 -> 6 -> 12 -> 25 -> 33 -> 890 -> 111";

        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        ImmutableLinkedList newLinkedList1 = new ImmutableLinkedList();
        ImmutableLinkedList newLinkedList2 = new ImmutableLinkedList();
        ImmutableLinkedList newLinkedList3 = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
            newLinkedList1 = newLinkedList1.add(Data[i]);
            newLinkedList2 = newLinkedList2.add(Data[i]);
            newLinkedList3 = newLinkedList3.add(Data[i]);
        }
        newLinkedList = newLinkedList.addAll(new Object[]{4, 6, 12});
        newLinkedList1 = newLinkedList1.addAll(2, new Object[]{4, 6, 12});
        newLinkedList2 = newLinkedList2.addAll(-1, new Object[]{4, 6, 12});
        newLinkedList3 = newLinkedList3.addAll(0, new Object[]{4, 6, 12});

        assertEquals(expectedResult, newLinkedList.toString());
        assertEquals(expectedResult1, newLinkedList1.toString());
        assertEquals(expectedResult, newLinkedList2.toString());
        assertEquals(expectedResult3, newLinkedList3.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllException() {
        ImmutableLinkedList NewLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            NewLinkedList = NewLinkedList.add(Data[i]);
        }
        NewLinkedList = NewLinkedList.addAll(145636, new Object[]{5, 6, 7});
        assertEquals(new IndexOutOfBoundsException(), NewLinkedList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        Object result = newLinkedList.get(567);
        assertEquals(new IndexOutOfBoundsException(), result);
    }

    @Test
    public void testGet() {
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        Object result = newLinkedList.get(1);
        assertEquals(new LinkedNode(33).getData().toString(), result.toString());
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        String expectedResult = "25 -> 33 -> 111";
        String expectedResult1 = "33 -> 111";

        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        newLinkedList = newLinkedList.remove(2);
        assertEquals(expectedResult, newLinkedList.toString());

        newLinkedList = newLinkedList.remove(0);
        assertEquals(expectedResult1, newLinkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveException() {
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        newLinkedList = newLinkedList.remove(456);
        assertEquals(new IndexOutOfBoundsException(), newLinkedList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setException() {
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        newLinkedList = newLinkedList.set(567, 1234);
        assertEquals(new IndexOutOfBoundsException(), newLinkedList);
    }

    @Test
    public void testSet() {
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        String expectedResult = "25 -> 111 -> 890 -> 111";
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        newLinkedList = newLinkedList.set(1, 111);
        assertEquals(expectedResult, newLinkedList.toString());
    }

    @Test
    public void testIndexOf() {
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        int expectedResult = 1;
        int expectedResultWithException = -1;

        int result = newLinkedList.indexOf(33);
        int resultWithException = newLinkedList.indexOf(100000);

        assertEquals(expectedResult, result);
        assertEquals(expectedResultWithException, resultWithException);
    }

    @Test
    public void testSize() {
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        int expectedResult = 4;
        int result = newLinkedList.size();
        assertEquals(expectedResult, result);
    }

    @Test
    public void testClear() {
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        ImmutableLinkedList expectedResult = new ImmutableLinkedList();
        newLinkedList = newLinkedList.clear();
        assertEquals(expectedResult.toString(), newLinkedList.toString());
    }


    @Test
    public void testAddFirst() {
        String expectedResult = "1234 -> 25 -> 33 -> 890 -> 111";
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        newLinkedList= newLinkedList.addFirst(1234);
        assertEquals(expectedResult, newLinkedList.toString());
    }

    @Test
    public void testAddLast() {
        String expectedResult = "25 -> 33 -> 890 -> 111 -> 1234";
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        newLinkedList = newLinkedList.addLast(1234);
        assertEquals(expectedResult, newLinkedList.toString());
    }

    @Test
    public void testRemoveFirst() {
        String expectedResult = "33 -> 890 -> 111";
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        newLinkedList= newLinkedList.removeFirst();
        assertEquals(expectedResult, newLinkedList.toString());
    }

    @Test
    public void testRemoveLast() {
        String expectedResult = "25 -> 33 -> 890";
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        newLinkedList = newLinkedList.removeLast();
        assertEquals(expectedResult, newLinkedList.toString());
    }

    @Test
    public void testGetFirst() {
        int expectedResult = 25;
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        Object result = newLinkedList.getFirst();
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetLast() {
        int expectedResult = 111;
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        Object result = newLinkedList.getLast();
        assertEquals(expectedResult, result);
    }

    @Test
    public void testIsEmpty() {
        boolean expectedResult = false;
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        boolean result = newLinkedList.isEmpty();
        assertEquals(expectedResult, result);

        ImmutableLinkedList newLinkedList1 = new ImmutableLinkedList();
        expectedResult = true;
        result = newLinkedList1.isEmpty();
        assertEquals(expectedResult, result);

    }

    @Test
    public void testToArray() {
        Object[] expectedResult = new Object[]{"25", "33", "890", "111"};
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        Object[] result = newLinkedList.toArray();
        for (int i = 0; i < result.length; i++) {
            assertEquals(expectedResult[i], result[i].toString());
        }
    }

    @Test
    public void testGetHead() {
        String expectedResult = "25";
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        assertEquals(expectedResult, newLinkedList.head.getData().toString());
    }

    @Test
    public void testGetSize() {
        int expectedResult = 4;
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        assertEquals(expectedResult, newLinkedList.size);
    }

    @Test
    public void testToString() {
        String expectedResult = "25 -> 33 -> 890 -> 111";
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        int[] Data = new int[]{25, 33, 890, 111};
        for (int i = 0; i < 4; i++) {
            newLinkedList = newLinkedList.add(Data[i]);
        }
        assertEquals(expectedResult, newLinkedList.toString());
    }


}
