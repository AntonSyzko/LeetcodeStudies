package KEVIN_NAUGHTON_JR.array;

/*
given array - remove certail val, return same array length without removed val,
 do in place O(1)
 */
public class RemoveElement {
    public static void main(String[] args) {
        int [] arra = new int [] {3,2,2,3};
        int remoedLength = removedLength(arra, 3);
        System.out.println(remoedLength);
    }

    static int removedLength(int [] nums, int valToRemove){
        int index = 0;
        for (int num : nums){
            if(nums[num] != valToRemove){
                nums[index++] = num;
            }
        }
        return index;
    }
}
