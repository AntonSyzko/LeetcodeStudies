package LEET_CODE.array;

import java.util.Arrays;

/*
given array of nums representing colors
0 - red
1 - blue
2 -whire
sort iN PLACE
[0 1 2 0 1 2 ]
[0 0 1 1 2 2 ]
 */
public class SortColorsInPlace {
    public static void main(String[] args) {
        int[] colors = new int[]{0, 1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(colors));
        sortColors(colors);
        System.out.println(Arrays.toString(colors));


    }

    static void sortColors(int[] colors) {
        if (colors.length == 0 || colors.length == 1) return;

        int start = 0;
        int end = colors.length - 1;
        int index = 0;

        while (index <= end && start < end) {
            if (colors[index] == 0) {
                colors[index] = colors[start];//start is where 0 should go , so swap
                colors[start] = 0;//we know it shoud be zero after swap anyways -so just assign
                start++;
                index++;
            } else if (colors[index] == 2) {
                colors[index] = colors[end];//end is where 2 should go
                colors[end] = 2;
                end--;
            } else {//case color ==1
                index++;//just continue increasing index on
            }
        }
    }
}
