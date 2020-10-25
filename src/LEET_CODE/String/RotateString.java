package LEET_CODE.String;

/*
check if string contains the target afetr shifts
abcde contains cdeab ?
yes , afetr shifting a and then b - bcdea -> cdeab = true

solution - concatenate first string to itself - it now contains ALL possible shifting solutions
check if concatenated just contains atrget string
 */
public class RotateString {

    public static void main(String[] args) {
     boolean contains = rotateString("abcde","cdeab");
        System.out.println(contains);
    }

    static boolean rotateString(String source, String target){
        return source.length() == target.length()//have to be same length
                && (source+source).contains(target);//concat source + source has all shifting permutations
    }
}
