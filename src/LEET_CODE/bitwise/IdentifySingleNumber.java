package LEET_CODE.bitwise;

/*
given an array of ints , where all are same , but only ONE  is different - find it
2 2 2 2 5

res = 5

use NO extra space
 */
public class IdentifySingleNumber {
    public static void main(String[] args) {
            int [] nums = new int[] {2,2,2,2,5};

            int uniqueSingle = identifySingle(nums);
        System.out.println(uniqueSingle);
    }

    static int identifySingle(int [] nums){
        int res = 0;
//XOR with num and zero  first time   gives the very num, but every next time gives ( num XOR same num) gives 0
//so 0 XOR num = num, num XOR same num = 0
//so when XOR will occur on not SAME num - our unique - XOR will give it's result back
        for(int i = 0; i < nums.length; i++){
            res ^= nums[i];
        }

        return res;
    }
}
