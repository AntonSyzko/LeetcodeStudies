package LEET_CODE.array;

public class FindDuplicatesInArray {
    public static void main(String[] args) {
        int [] nums = new int [] {1,2,3,4,5,6,2,8,9};
        System.out.println(" duplictae is " + findDuplicates(nums));
    }



    static int findDuplicates(int [] nums){
        int slow_pointer = nums[0];
        int fast_pointer = nums[0];

        slow_pointer = nums[slow_pointer];
        fast_pointer = nums[nums[fast_pointer]];

        while (slow_pointer != fast_pointer){//detect cycle
            slow_pointer = nums[slow_pointer];
            fast_pointer = nums[nums[fast_pointer]];
        }

        int a_pointer = nums[0];
        int b_pointer = slow_pointer;//it is in the begignning of cycle by this momemnt

        while (a_pointer != b_pointer){
            a_pointer = nums[a_pointer];
            b_pointer = nums[b_pointer];
        }

        return a_pointer;
    }
}
