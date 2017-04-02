package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{

    private final MyFunction func;


    public MapDecorator(SmartArray arr, MyFunction func) {
        super(arr);
        this.func = func;
    }

    public Object[] toArray() {
        Object[] objects = smartArray.toArray();
        for (int i = 0; i < objects.length; i++) {
            objects[i] = func.apply(objects[i]);
        }
        return objects;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + ", with map decorator";
    }

    @Override
    public int size() {
        return smartArray.toArray().length;
    }
}
