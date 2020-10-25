package KEVIN_NAUGHTON_JR.strings;

public class ReverseString {

    public static void main(String[] args) {
        String reversed = reverse("hello");
        System.out.println(reversed);
    }


    static String reverse(String input){
        int start = 0;
        int end = input.length()-1;

        char[] chArray = input.toCharArray();
        while (start < end){
            char temp =chArray[start];
            chArray[start] = chArray[end];
            chArray[end] = temp;
            start++;
            end--;

        }
        return new String(chArray);

    }
}
