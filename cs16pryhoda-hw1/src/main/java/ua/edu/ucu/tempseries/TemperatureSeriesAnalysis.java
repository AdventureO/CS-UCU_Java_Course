package ua.edu.ucu.tempseries;



import java.lang.Math;


public class TemperatureSeriesAnalysis {

    private double[] numbersArray;

    public TemperatureSeriesAnalysis() {
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        numbersArray = temperatureSeries;
    }

    public double average() {
        double sum = 0;
        if (numbersArray.length >= 1) {
            for (int i = 0; i < numbersArray.length; i++) {
                sum += numbersArray[i];
            }
            return sum / numbersArray.length;
        }
        else {
            throw  new IllegalArgumentException();
        }
    }

    public double deviation() {
        if (numbersArray.length >= 1) {
            double average = average();
            double sum = 0;
            for (int i = 0; i < numbersArray.length; i++) {
                sum += (numbersArray[i] - average) * (numbersArray[i] - average);
            }
            return Math.sqrt(sum / numbersArray.length);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double min() {
        if (numbersArray.length >= 1) {
            double min = numbersArray[0];
            for (double element: numbersArray) {
                if (min > element) {
                    min = element;
                }
            }
            return min;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public double max() {
        if(numbersArray.length >= 1) {
            double max = numbersArray[0];
            for (double element: numbersArray) {
                if (max < element) {
                    max = element;
                }
            }
            return max;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public double findTempClosestToZero() {
        if (numbersArray.length >= 1) {
            double minNearZero = numbersArray[0];
            for (int i = 1; i < numbersArray.length; i++) {
                if (Math.abs(minNearZero) > Math.abs(numbersArray[i])) {
                    minNearZero = numbersArray[i];
                }
                else if( Math.abs(minNearZero) == Math.abs(numbersArray[i])) {
                    minNearZero = Math.abs(numbersArray[i]);
                }
            }
            return minNearZero;
        } else{
            throw new IllegalArgumentException();
        }
    }

    public double findTempClosestToValue(double tempValue) {
        if (numbersArray.length >= 1) {
            double minNearTempValue = numbersArray[0];
            for (int i = 1; i < numbersArray.length; i++) {
                if (Math.abs(tempValue - minNearTempValue) > Math.abs(tempValue - numbersArray[i])) {
                    minNearTempValue = numbersArray[i];
                }
            }
            return minNearTempValue;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double[] findTempsLessThen(double tempValue) {
        if (numbersArray.length >= 1) {
            double[] tempArray = new double[numbersArray.length];
            int count = 0;
            for (int i = 0; i < numbersArray.length; i++) {
                if (numbersArray[i] < tempValue) {
                    tempArray[count] = numbersArray[i];
                    count++;
                }
            }
            double[] resultArray = new double[count];
            for (int i = 0; i < count; i++) {
                resultArray[i] = tempArray[i];
            }
            return resultArray;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (numbersArray.length >= 1) {
            double[] tempArray = new double[numbersArray.length];
            int count = 0;
            for (int i = 0; i < numbersArray.length; i++) {
                if (numbersArray[i] > tempValue) {
                    tempArray[count] = numbersArray[i];
                    count++;
                }
            }
            double[] resultArray = new double[count];
            for (int i = 0; i < count; i++) {
                resultArray[i] = tempArray[i];
            }
            return resultArray;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public TempSummaryStatistics summaryStatistics() {
        if (numbersArray.length >= 1) {
            TempSummaryStatistics statistic = new TempSummaryStatistics(average(), deviation(), min(), max());
            return statistic;
        } else {
            throw  new IllegalArgumentException();
        }
    }

    public int addTemps(double... temps) {
        double[] tempArray = numbersArray;
        while(numbersArray.length < (tempArray.length + temps.length)){
            numbersArray = new double[tempArray.length * 2];
        }
        int count = 0;
        int sum = 0;
        for (int i = 0; i < tempArray.length; i++){
            numbersArray[i] = tempArray[i];
            count++;
            sum += tempArray[i];
        }
        for (int i = 0; i < temps.length; i++){
            numbersArray[count] = temps[i];
            count++;
            sum += temps[i];
        }
        return sum;
    }
}
