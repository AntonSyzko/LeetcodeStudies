package LEET_CODE.miscelaneous;

public class FibonacciSeries {
    public static void main(String[] args) {
            int fib = fibNumber(3);
        System.out.println(fib);
    }

    static int fibNumber(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;

        int a = 0;
        int b = 1;
        int sum = a + b;

        while (number > 1) {
            sum = a + b;
            a = b;
            b = sum;
            number--;
        }
        return sum;
    }
}
