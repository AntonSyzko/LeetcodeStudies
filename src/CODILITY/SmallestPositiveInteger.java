package CODILITY;

import java.util.*;
import java.util.stream.Collectors;

public class SmallestPositiveInteger {

    public static void main(String[] args) {
//        int[] A = new int[]{-1, -3};
//        int smallest = sorted(A);
//        System.out.println(smallest);
//
//        int[] AA = new int[]{1, 3, 6, 4, 1, 2};
//        int smallest2 = sorted(AA);
//        System.out.println(smallest2);
//
//        int[] AAA = new int[]{1, 2, 3};
//        int smallest22 = sorted(AAA);
//        System.out.println(smallest22);


    }

    static int smallestJava8(int[] A) {

        if(A.length==0) return 1;

        Set<Integer> set = Arrays.stream(A).boxed().filter(a -> a > 0).collect(Collectors.toSet());

        for (int i = 1; i <= A.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }



    static  int sorted(int[] A){

      //  if(A.length==0) return 1;

        int minEl = 1;
        Arrays.sort(A);

        int len = A.length;

        if(A.length==0 || A[0] >1 || A[len-1] <= 0){
            return minEl;
        }

        for (int i = 0; i < len ; i++) {
            if(A[i] == minEl){
                minEl++;
            }
        }

        return minEl;
    }

    static int smallest(int[] A) {
        //length of array as local var
        int N = A.length;

        //set for storing unique integers
        Set<Integer> set = new HashSet<>();

        for (int num : A) {
            if (num > 0) {//storing only positive ints
                set.add(num);
            }
        }

        for (int i = 1; i <= N + 1; i++) {//> 0 and <= N +1
            if (!set.contains(i)) {//not in SET  ???
                return i;
            }

        }


        return 0;
    }
}
