package KEVIN_NAUGHTON_JR.misc;

public class IsPerfectSquare {
    public static void main(String[] args) {
        int test = 16;
        boolean sqrt = isPerfectSquareOptimized(test);
        System.out.println(sqrt);

        int test2 = 14;
        boolean sqrt2 = isPerfectSquareOptimized(test2);
        System.out.println(sqrt2);
    }

    static boolean isPerfectSquare(int num) {

        int left = 0;
        int right = num;

        //<= cuase at some point righ will move lover than left and this means no solution in BST, stop while
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mid * mid == num) {//match
                return true;
            }
            if (mid * mid < num) {//too low
                left = mid + 1;
            } else {//too high
                right = mid - 1;
            }
        }

        return false;
    }

    static boolean isPerfectSquareOptimized(int num) {

        if(num <2){
            return true;
        }
        int left = 2;
        int right = num/2;//since /2 always less than sqrt

        //<= cuase at some point righ will move lover than left and this means no solution in BST, stop while
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mid * mid == num) {//match
                return true;
            }
            if (mid * mid < num) {//too low
                left = mid + 1;
            } else {//too high
                right = mid - 1;
            }
        }

        return false;
    }
}
