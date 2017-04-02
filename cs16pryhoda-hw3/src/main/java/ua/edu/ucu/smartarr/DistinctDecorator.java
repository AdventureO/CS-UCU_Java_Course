package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{

    public DistinctDecorator(SmartArray arr) {
        super(arr);
    }

    public Object[] toArray(){
        Object[] objects = smartArray.toArray();
        ArrayList<Object> tempList= new ArrayList<>();
        for(int i = 0; i < objects.length; i++){
            tempList.add(objects[i]);
        }

        for(int i = 0; i < tempList.size(); i++){
            for(int j = i + 1; j < tempList.size(); j++){
                if (tempList.get(j).toString().equals(tempList.get(i).toString())) {
                    tempList.remove(i);
                }
            }
        }

        Object[] objects_result = new Object[tempList.size()];
        for(int i = 0; i < objects_result.length; i++){
            objects_result[i] = tempList.get(i);
            }

        return objects_result;
    }

    @Override
    public String operationDescription() {
        return smartArray.operationDescription() + ", with distinct decorator";
    }

    @Override
    public int size() {
        return smartArray.toArray().length;
    }
}
