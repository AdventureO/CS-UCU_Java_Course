package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] smArray;

    public BaseArray(Object[] smartArray){
        this.smArray = smartArray;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(smArray, size());
    }

    @Override
    public String operationDescription() {
        return "Base array";
    }

    @Override
    public int size() {
        return smArray.length;
    }
}
