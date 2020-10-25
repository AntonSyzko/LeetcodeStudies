package KEVIN_NAUGHTON_JR.array;

import java.util.HashSet;

public class UniqueEmails {

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
        HashSet<String> set = new HashSet<>();

        for(String email : emails){
            StringBuilder address = new StringBuilder();
            for(int i = 0 ; i < email.length(); i++){//traverse all chars
                char ch = email.charAt(i);
                if(ch == '.'){
                    continue;//ignore - go in if dot
                }else if(ch == '+'){
                    while(email.charAt(i) != '@'){//everything  after + is ignored - so jump up to @
                        i++;//shift the traverse i index to @
                    }
                    address.append(email.substring(i));//add all after @
                    break;//exit
                }else if(ch == '@') {//if @ - ignore very @
                    address.append(email.substring(i));
                    break;//exit
                }else{
                    address.append(ch);
                }
            }
            set.add(address.toString());
        }
        System.out.println(set);

        return set.size();
    }

}


