package LEET_CODE.array;

/*
Remove Duplicates from Sorted Array
Given a sorted array, remove the duplicates from the array in-place such that each element appears only once, and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example

Given array [1, 1, 1, 3, 5, 5, 7]

The output should be 4, with the first four elements of the array being [1, 3, 5, 7]

****************************

Given that the array is sorted, all the duplicate elements will appear together.

We can solve the problem in O(n) time complexity by using two pointer sliding window pattern. We’ll keep two pointers (indexes) -

One index i, to iterate over the array, and
Another index j, to keep track of the number of unique elements found so far. This index will move only when we modify the array in-place to include a new non-duplicate element.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 3, 5, 5, 7};
        int newLength = removeDuplicates(nums);

        System.out.println("Length of array after removing duplicates = " + newLength);
    }

    static int removeDuplicates(int[] array) {
        int length_of_array = array.length;
        /*
         * This index will move only when we modify the array in-place to include a new
         * non-duplicate element.
         */
        int result_array_length = 0;

        for (int i = 0; i < length_of_array; i++) {
            /*
             * If the current element is equal to the next element, then skip the current
             * element because it's a duplicate.
             */
            if (i < length_of_array - 1 // mind -1 - since have to check last TWO elements - not to get OutOfBounds Ex
                    && array[i] == array[i + 1]) {//comparing values of next to each other array elements
                continue;// if same - continue
            }
            array[result_array_length] = array[i];//assign current unique element from original to res position ( 0 in beginning)
            result_array_length++;//increase new res, can be done above with ++ ( array[result_array_length++] )
        }
        return result_array_length;

    }

    //duplicates may occur TWICE    1 1 1 = 1 1
    static int removeDuplicatesOccuredTwice(int[] array) {
        int length_of_array = array.length;
        /*
         * This index will move only when we modify the array in-place to include a new
         * non-duplicate element.
         */
        int result_array_length = 0;

        for (int element = 0; element < length_of_array; element++) {
            /*
             * If the current element is equal to the next element, then skip the current
             * element because it's a duplicate.
             */
            if (element < length_of_array - 2 // mind -2  - since have to check last TWO elements ( and only two may be same )  - not to get OutOfBounds Ex
                    && array[element] == array[element + 2]) {//comparing values of  element and element in jump of 2
                continue;// if same - continue
            }
            ////increase new res, can be done above with ++ ( array[result_array_length++] )
            array[result_array_length++] = array[element];//assign current unique element from original to res position ( 0 in beginning)

        }
        return result_array_length;

    }
}
