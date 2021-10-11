package LEET_CODE.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
given aray of char width and a String , count how many lines will be there to show string
ig ONLY 100 chars per line allowed
S= "abc"  width [10,10,5] - will be 26 like alphabet
so    a - 10 width
      b - 10 width
      c - 5 width
abc = means 10 times a, 10 times b, 5 times c , so 55 chars in line
 */
public class NumberOfLines {

    @Test
    public void test(){
        int [] widths = new int [] {10,10,10,10,10,10,10,10,10,10,5};
        int [] res = numberOfLines(widths,"abcdefghijk");
        assertEquals(res[0],2);
        assertEquals(res[1],5);
    }

    static int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];
        int num_lines = 1;//anyways 1 line will be there for shure
        int current_width = 0;

        for (char each : s.toCharArray()) {

            int curr_char_width = widths[each - 'a'];//count of curr char from width array

            //if curr width AND curr char width EXCEED 100
            if (current_width + curr_char_width > 100) {
                num_lines++;//new line
                current_width = 0;//reset curr - since cannot carry over
            }

            current_width += curr_char_width;//add curr char width to curr char
        }
        res[0] = num_lines;
        res[1] = current_width;
        return res;
    }
}
