package LEET_CODE.array;

/*
given array of jumps find out if you can reach end
2 3 1 1 4 - true
3 2 1 0 4 - false
 */
public class FrogJump {
    public static void main(String[] args) {


        boolean res = canJump(new int []{2,3,1,1,4});
        System.out.println(res);

        boolean res2 = canJump2(new int []{3,2,1,0,4});
        System.out.println(res2);
    }

    static boolean canJump(int [] jumps){
        //going backwards and checking if prev step leads to it precessor
        int lastGoodIndexPosition = jumps.length-1;//last index of array , and further - last where we can get from prev

        for (int jump = jumps.length-1; jump >= 0 ; jump--) {
            //if current jump + value of where one can get from here >= lastGoodIndex
            if(jump + jumps[jump] >= lastGoodIndexPosition){
                lastGoodIndexPosition = jump;//update last good index - so we know we can get here from prev
            }
        }

        return lastGoodIndexPosition == 0;//bool - if 0 - true we can get, not zero - never reached start
    }


    //forward
    static boolean canJump2(int [] jumps){
        int max = 0;

        for (int i = 0; i < jumps.length; i++) {
            if(i > max){
                return false;
            }
            max = Math.max(max, i+jumps[i]);
        }

        return true;
        }
    }
