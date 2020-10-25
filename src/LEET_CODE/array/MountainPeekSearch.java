package LEET_CODE.array;

/*
given array of ountains find peek where
A[i-1] < A[i] > A[i+1]
 */
public class MountainPeekSearch {

    public static void main(String[] args) {
        int[] hills = new int[]{0, 2, 1, 0};

        int peek = peekMountain(hills);
        System.out.println(peek);
    }

    //classic BS
    static int peekMountain(int[] hills) {
        int left = 0;
        int right = hills.length - 1;

        while (left < right) {
            int midpoint = left + (right - left) / 2;

            if (hills[midpoint] < hills[midpoint + 1]) {
                left = midpoint + 1;
            } else {
                right = midpoint;
            }
        }

        return left;
    }
}
