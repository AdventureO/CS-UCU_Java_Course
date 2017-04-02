package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{


    private final MyComparator cmp;

    public SortDecorator(SmartArray arr, MyComparator cmp) {
        super(arr);
        this.cmp = cmp;
    }

    public Object[] toArray() {
        Object[] objects = smartArray.toArray();
        Arrays.sort(objects, cmp);
        return objects;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + ", with sort decorator";
    }

    @Override
    public int size() {
        return smartArray.toArray().length;
    }

}
