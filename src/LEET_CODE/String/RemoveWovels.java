package LEET_CODE.String;

public class RemoveWovels {

    public static void main(String[] args) {
        String withoutWovels = removeAllVowels("ello");
        System.out.println(withoutWovels);
    }

    static String removeAllVowels(String input){
        return input.replaceAll("[aeiou]","");
    }
}
