package CODILITY;

public class NameSurnameAge {

    public static void main(String[] args) {
        String res = solution("John", "Firelord", 8);
        System.out.println(res);
    }


    public static String solution(String name, String surname, int age) {

        StringBuilder sb = new StringBuilder();

        sb.append(name, 0, 2).append(surname, 0, 2).append(age);

        return sb.toString();

    }

}
