package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;

import java.util.ArrayList;

public class AsIntStream implements IntStream {
    
    public ArrayList<Integer> dataStream;

    private AsIntStream() {
        this.dataStream = new ArrayList<>();
    }

    public static IntStream of(int... values) {
        
        AsIntStream asIntStream = new AsIntStream();
        for(int element: values){
            asIntStream.dataStream.add(element);
        }
        return asIntStream;
    }

    @Override
    public Double average() {
        return Double.valueOf((sum() / count()));
    }

    @Override
    public Integer max() {
        int max = 0;
        IntBinaryOperator operator = (left, right) -> {
            if (left > right) {
                return left;
            }
            return right;
        };
        return reduce(max, operator);
    }

    @Override
    public Integer min() {
        int min = 0;
        IntBinaryOperator operator = (left, right) -> {
            if (left < right) {
                return left;
            }
            return right;
        };
        return reduce(min, operator);
    }

    @Override
    public long count() {
        return dataStream.size();
    }


    @Override
    public Integer sum() {
        int sum= 0;
        IntBinaryOperator operator = (left, right) -> {
            left += right;
            return left;
        };
        return reduce(sum, operator);
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        AsIntStream filteredArray = new AsIntStream();
        for (int element: dataStream) {
            if (predicate.test(element)) {
                filteredArray.dataStream.add(element);
            }
        }
        return filteredArray;
    }

    @Override
    public void forEach(IntConsumer action) {
        for(Object element: dataStream){
            action.accept((Integer) element);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        AsIntStream mappedArray = new AsIntStream();
        dataStream.forEach(
                x -> {
                    mappedArray.dataStream.add(mapper.apply(x));
                });
        return mappedArray;
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        ArrayList<Integer> data = new ArrayList<>();
        dataStream.forEach(
            x -> {
                AsIntStream asIntStream = (AsIntStream)func.applyAsIntStream(x);
                IntConsumer action = value -> data.add(value);
                asIntStream.forEach(action);
            });
        int[] intArray = new int[data.size()];
        int element = 0;
        while(element < data.size()){
            intArray[element] = data.get(element);
            element++;
        }
        return AsIntStream.of(intArray);
    }

    @Override
    public int reduce(int identity, IntBinaryOperator operator) {
        int result = identity;
        for (int element:dataStream){
            result = operator.apply(result, element);
        }
        return result;

    }

    @Override
    public int[] toArray() {
        int[] intArray = new int[(int)count()];
        for (int i=0; i<(int)count(); i++) {
            intArray[i] = dataStream.get(i);
        }
        return intArray;
    }
}
