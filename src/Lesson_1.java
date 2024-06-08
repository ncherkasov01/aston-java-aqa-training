import java.util.Arrays;
import java.util.stream.IntStream;

public class Lesson_1 {
    public static void main(String[] args) {
        //task 1
        printThreeWords();

        //task 2
        checkSumSign();

        //task3
        printColor();

        //task 4
        compareNumbers();

        //task 5
        sumNumbers(10,5);

        //task 6
        positiveOrNegative(-3);

        //task 7
        trueOrFalse(5);

        //task 8
        repeatString(4, "bob");

        //task 9
        visokosniyYear(2024);

        //task 10
        viseVersaArray();

        //task11
        oneHundred();

        //task 12
        lessThanSix();

        //task 13
        diagonal();

        //task 14
        odnomerniyMassiv(5,2);
    }

    //task 1 solution
    public static void printThreeWords() {
        System.out.println("Orange" + "\n" + "Banana" + "\n" + "Apple");
    }

    //task 2 solution
    public static void checkSumSign() {
        int a = 1;
        int b = 2;
        int c = a + b;
        if (c >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

    //task 3 solution
    public static void printColor() {
        int value = 1;
        if (value <= 0)
            System.out.println("Красный");
        else if (value > 0 & value <= 100) {
            System.out.println("Жёлтый");
        } else if (value > 100) {
            System.out.println("Зелёный");
        }
    }

    //task 4 solution
    public static void compareNumbers() {
        int a = 1;
        int b = 2;
        if (a >= b)
            System.out.println("a >= b");
        else
            System.out.println("a < b");
    }

    //task 5 solution
    public static boolean sumNumbers(int a, int b) {

        int c = a + b;
        if (c >= 10 & c <= 20) {
            System.out.println(true);
            return true;
        }
        else
            System.out.println(false);
        return false;
    }

    //task 6 solution
    public static void positiveOrNegative(int a) {
        if (a >= 0)
            System.out.println(a + " это положительное число");
        else
            System.out.println(a + " это отрицательное число");
    }

    //task 7 solution
    public static boolean trueOrFalse(int a) {
        if (a >= 0) {
            System.out.println(true);
            return true;
        }
        else
            System.out.println(false);
        return false;
    }

    //task 8 solution
    public static void repeatString(int a, String b) {
        System.out.println(b.repeat(a));
    }

    //task 9 solution
    public static boolean visokosniyYear(int year) {
        if (year % 400 == 0) {
            System.out.println(true);
            return true;
        } else if (year % 100 == 0) {
            System.out.println(false);
            return false;
        } else if (year % 4 == 0) {
            System.out.println(true);
            return true;
        } else
            System.out.println(false);
        return false;
    }

    //task 10 solution
    public static void viseVersaArray() {
        int[] intArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 1};
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == 1)
                intArray[i] = 0;
            else {
                intArray[i] = 1;
            }
        }
        System.out.println(Arrays.toString(intArray));
    }

    //task 11 solution
    public static void oneHundred() {
        int[] intArray = new int[100];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i + 1;
            System.out.println(intArray[i]);
        }
    }

    //task 12 solution
    public static void lessThanSix() {
        int[] intArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < 6)
                intArray[i] = intArray[i] * 2;
            System.out.println(intArray[i]);
        }
    }

    //task 13 solution
    public static void diagonal() {
        int dimension = 5;
        int[][] intArray = new int[dimension][dimension];
        IntStream.range(0, dimension).forEach(i -> {
            intArray[i][i] = 1;
            intArray[i][intArray.length - 1 - i] = 1;
        });
        Arrays.stream(intArray).map(Arrays::toString).forEach(System.out::println);
    }

    //task 14 solution
    public static int[] odnomerniyMassiv(int len, int initialValue) {
        int intArray[] = new int[len];
        for (int i = 0; i < intArray.length; i++){
            intArray[i] = initialValue;
        }
        System.out.println(Arrays.toString(intArray));
        return intArray;
    }
}
