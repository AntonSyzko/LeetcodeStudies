package KEVIN_NAUGHTON_JR.array;

/*
given sorted array of nums
remove duplicates in place O(1)
retrun length of array wihout duplicates

1. - sorted ! so duplicates are next to each other
2. - in place-  no new array , use given one
3. - 1st element will be unique anyways ( optimization )
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int [] array = new int [] {0,0,1,1,1,2,2,3,3,4};
        int lengthWithoutDupl = arrayWithoutDuplicates(array);
        System.out.println(lengthWithoutDupl);

    }

    static int arrayWithoutDuplicates(int[] nums) {
        int index = 1;//first aalways unique
        for (int i = 1; i < nums.length - 1; i++) {//start from 1 , since first always unique
            if (nums[i] != nums[i + 1]) {//if NEXT to given   NOT same
                nums[index++] = nums[i + 1];//store it in index ++ position, so next to prev unique
            }
        }

        return index;//index is just length of UNIQUES, array same O(1)
    }
}
