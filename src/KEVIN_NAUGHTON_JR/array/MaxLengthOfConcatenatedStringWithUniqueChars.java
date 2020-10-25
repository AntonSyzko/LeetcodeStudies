package KEVIN_NAUGHTON_JR.array;

import java.util.List;

public class MaxLengthOfConcatenatedStringWithUniqueChars {


    static int maxLengthOfConcatStringWIthUniqChars(List<String> array){
        int [] result = new  int [1];
        maxUniqueChars(array, 0, "", result);

        return result[0];
    }

    private static void maxUniqueChars(List<String> array, int index_in_array, String current_string, int[] result) {
        if(index_in_array == array.size() && //reached end of array
                uniqueCharCount(current_string)>result[0]){//unique in current string is more then in current result
            result[0]=current_string.length();//reassign current result
            return;//case case stop
        }

        if(index_in_array == array.size()){
            return;//base case stop - end o f array
        }
//going index+ 1 makes it DFS
        maxUniqueChars(array, index_in_array+1, current_string, result);//not counting in current
        maxUniqueChars(array, index_in_array+1, current_string+array.get(index_in_array), result);//withc urrent
    }

    private static int  uniqueCharCount(String current_string) {
        int[] alphabet_occurences_count = new int [26];
        for(char each : current_string.toCharArray()){
            if(alphabet_occurences_count[each -'a']++>0){//++ is to grow value of occurences of chars
                return -1;
            }
        }

        return current_string.length();
    }


}
