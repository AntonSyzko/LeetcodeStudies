package LEET_CODE.array;

import java.util.HashSet;

/*
anna@anna.com
anna.anna@anna.com  - ignore first .
anna+fdgfganna.com - all after + isgnored
anna.com - . in domain ignored
 */
public class UniqueEmailNames {

    public static void main(String[] args) {
        String[] emails = new String[]{
                "anna@anna.com",
                "anna+anna@anna.com",//after + ingnored
                "anna.anna@anna.com",//dot ignored so annaanna
                "bella@bella.com"
        };

        int uniques = countUniqueEmails(emails);
        System.out.println(uniques);
    }

    static int countUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) return 0;

        HashSet<String> uniqueEmails = new HashSet<>();//store unique, set is uniques

        for (String email : emails) {

            int domain_split_position = email.indexOf("@");//divide

            String local_name = email.substring(0, domain_split_position);
            String domain_name = email.substring(domain_split_position);

            if (local_name.contains("+")) {
                int plus_position = email.indexOf("+");
                local_name = local_name.substring(0, plus_position);//ignore after +
            }

            local_name = local_name.replaceAll("\\.", "");//delete dots
            String new_name = local_name + domain_name;//glue

            uniqueEmails.add(new_name);

        }

        return uniqueEmails.size();
    }
}
