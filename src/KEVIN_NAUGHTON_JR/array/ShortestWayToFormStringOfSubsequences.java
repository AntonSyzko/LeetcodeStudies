package KEVIN_NAUGHTON_JR.array;

/*
source 'xyz'  target 'xzyxz'
answer - 3 subsequences to form target
xz - y -zx
abc - 'abcbc'
2 - abc and bc

 */
public class ShortestWayToFormStringOfSubsequences {
    public static void main(String[] args) {
        String source = "abc";
        String target = "abcbc";
        System.out.println(" num of subsequneces " + shortestWayToFormStringOfSubsequences(source, target));

    }

    static int shortestWayToFormStringOfSubsequences(String source, String target){
        int numSubsequences = 0;//res

        String remainingCharsInTergetAfterFound = target;//placeholder for current subsequence occurences

        while (remainingCharsInTergetAfterFound.length() >0){//while remaining chars in tartget exist
            StringBuilder current_subsequence = new StringBuilder();
            int sourceChar = 0;//chars in source traverse
            int targetChar = 0;//chars in target traveser
            while (sourceChar < source.length() && targetChar < remainingCharsInTergetAfterFound.length()){//while smth to traverse in bounds
                if(source.charAt(sourceChar) == remainingCharsInTergetAfterFound.charAt(targetChar)){//if same chars in source  and  target
                    current_subsequence.append(remainingCharsInTergetAfterFound.charAt(targetChar));//keep on appending to subsequences by target

                    targetChar++;//match found - increase target , can do it in append ++, it's in if, so increase will happen only if true

                }
 //increase to move on ( ++ can  be  used in if and append ), it's here cause we increase anyways , found or  not , source traverse has to move  on
                sourceChar++;
            }
            if(current_subsequence.length()==0){//no subsequences formed - wrong result -1
                return -1;
            }
            numSubsequences++;//some sunsequence occured , increase result
            //shorten target ( remaining, remove already found mathces, substring it by subsequnce length
            remainingCharsInTergetAfterFound = remainingCharsInTergetAfterFound.substring(current_subsequence.length());
        }

        return numSubsequences;
    }
}
