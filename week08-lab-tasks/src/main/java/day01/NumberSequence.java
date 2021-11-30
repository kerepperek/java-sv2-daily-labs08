package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {

    List<Integer> list = new ArrayList<>();

    public NumberSequence(List<Integer> list) {
        this.list = list;
    }

    public NumberSequence(int pcs, int minValue, int maxValue) {
        Random rand = new Random();
        for (int counter = 1; counter <= pcs; counter ++){
            list.add(rand.nextInt(minValue,maxValue+1));
        }
    }

    public List<Integer> closeToAverage(int value) {
        List<Integer> result = new ArrayList<>();
        double average = getAverage();
        for (Integer number : list) {
            if (Math.abs(number-average)<=value) {
                result.add(number);
            }
        }
        return result;
    }

    public double getAverage() {
        int sum = 0;
        int pcs = 0;
        for (Integer number : list) {
            sum += number;
            pcs++;
        }
        return (double)sum / pcs;
    }

    @Override
    public String toString() {
        return "NumberSequence{" +
                "list=" + list +
                '}';
    }

    public List<Integer> getList() {
        return list;
    }
}
