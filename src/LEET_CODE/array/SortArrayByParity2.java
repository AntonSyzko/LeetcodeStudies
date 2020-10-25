package LEET_CODE.array;


import java.util.Arrays;

/*
given array of nums - sort
put even at even indexes (0,2,4) , odd - to odd indexes (1,3,5)

IN PLACE
 */
public class SortArrayByParity2 {

    public static void main(String[] args) {
        int[] array = new int[]{1,0,3,2,5,4};
        int[] paritySorted = sortArrayByParity(array);

        System.out.println(Arrays.toString(paritySorted));

    }


    static int[] sortArrayByParity(int[] array){
        int array_length = array.length;

        int even_pointer = 0;//trverse even indexes

        int odd_pointer = 1; // traverse odd indexes

      outer:  while (even_pointer < array_length && odd_pointer < array_length){//while smth to traverse in bounds of array

            //if in bounds AND even (MOD 2 = 0 )
           inner_even: while (even_pointer < array_length && array[even_pointer] %2 == 0){
                even_pointer +=2;//just JUMP ahead
            }
//if in bounds AND ODD ( MOD 2 = 1 )
           inner_odd: while (odd_pointer < array_length && array[odd_pointer] % 2 == 1){
                odd_pointer +=2;//just continue - JUMP ahead
            }
//but if after above while loops , EVEN or ODD did not reach end of arry - means smth was not in place
            //swap it , at each iteration on outer whaile loop
            if(even_pointer < array_length && odd_pointer < array_length){
                int temp = array[even_pointer];
                array[even_pointer] = array[odd_pointer];
                array[odd_pointer]=temp;
            }
        }

        return array;//returne sorted in PLACE array
    }


}
