package SULEIMANOV;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {

        boolean res = contsinsDuplicates(new int[]{1, 2, 3, 1});
        System.out.println(res);
        boolean res2 = contsinsDuplicatesSet(new int[]{1, 2, 3, 1});
        System.out.println(res2);
    }

    static boolean contsinsDuplicates(int[] array) {
        Arrays.sort(array);

        for (int i = 0; i < array.length - 1; i++) {//mind -1 to cover i+1 case at the very end
            if (array[i] == array[i + 1]) {//next to each other same
                return true;//is duplicates
            }
        }
        return false;
    }

    static boolean contsinsDuplicatesSet(int[] array) {
        Set<Integer> set = new HashSet<>();//uniques
        for (int i = 0; i < array.length; i++) {//all, no length -1 NO!!!
            if (!set.add(array[i])) {//adding to set giving FALSE
                return true;//is dupliacte
            }
        }
        return false;
    }
}
