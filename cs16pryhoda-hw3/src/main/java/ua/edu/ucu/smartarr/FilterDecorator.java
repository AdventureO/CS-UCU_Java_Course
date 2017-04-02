package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{

    private MyPredicate prd;

    public FilterDecorator(SmartArray arr, MyPredicate prd) {
        super(arr);
        this.prd = prd;
    }

    public Object[] toArray(){
        Object[] objects = smartArray.toArray();
        int count = 0;
        for(int i = 0; i < objects.length; i++){
            if(!prd.test(objects[i])){
                objects[i] = -1000000;
                count++;
            }
        }

        Object[] objects_result = new Object[objects.length - count];
        count = 0;
        for(int i = 0; i < objects.length; i++){
            if(!objects[i].equals(-1000000)){
                objects_result[count] = objects[i];
                count++;
            }
        }
        return objects_result;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + ", with filter decorator";
    }

    @Override
    public int size() {
        return smartArray.toArray().length;
    }


}
