package LEET_CODE.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayDuplicates {

    public static void main(String[] args) {
        int[] array = new int [] {1,2,3,1};
        boolean res = containsDuplicatesHashSet(array);
        boolean res2 = containsDuplicatesSortingSolution(array);

        System.out.printf(" contains %s, %s", res, res2);
    }

    //takse space- but faster
    static boolean containsDuplicatesHashSet(int[] array){
        Set<Integer> hashSet = new HashSet<>();

        for(int i = 0; i < array.length; i++){
            if( hashSet.contains(array[i])) return true;
            hashSet.add(array[i]);

        }
        return false;
    }

    // takses more time but no space - so if you are short on space, but ok with time
    static boolean containsDuplicatesSortingSolution( int[] array){
        Arrays.sort(array);

        for( int i =0 ; i < array.length-1; i++){
            if(array[i] == array[i+1]) return true;
        }

        return false;
    }
}
