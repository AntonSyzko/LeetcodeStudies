package LEET_CODE.array;

/*
given array []1,2,3,2,4] remove given elemnbt like 2 and return new length
mind elementh of array of new length should be all valid ( so without removed one )
do in place - no new array
 */
public class RemoveElement {

    public static void main(String[] args) {
      int size = removeElement(new int [] {1,2,3,2}, 2);
        System.out.println(size);
    }

    //solution is to move all valid elementh to the front of new array
    static int removeElement(int[] nums, int element) {
        if (nums.length == 0) return 0;

        int valid_size = 0;//future res size without removed elementh

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != element) {//NOT the one we wanna delete
                nums[valid_size] = nums[i];//so move it to front
                valid_size++;//was valid - so stays in new array - increment new size
            }

        }

        return valid_size;//res 
    }
}
