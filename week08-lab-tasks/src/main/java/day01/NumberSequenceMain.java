package day01;

public class NumberSequenceMain {

    public static void main(String[] args) {

        NumberSequence numberSequence = new NumberSequence(10, 23, 89);

        System.out.println(numberSequence.getList());
        System.out.println(numberSequence.getAverage());
        System.out.println(numberSequence.closeToAverage(10));

    }
}
