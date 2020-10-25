package KEVIN_NAUGHTON_JR.array;

/*
give key 2-5g-3-J
format according to number of chars in grouls, divided by - , first grop can be less, upper case all
group = 2
2-5G-3J
 */
public class LicenseKeyFormatting {
    public static void main(String[] args) {
     String key = "2-5g-3-J";
     String formatted = formatted(key, 2);
        System.out.println(formatted);
    }

    static String formatted(String key, int group) {
        StringBuilder res = new StringBuilder();//ress
        int end = key.length() - 1;//we will be  going backwards - so end position
        int groupCount = 0;//to accumulate chars and compare if mathces the group

        while (end >= 0) {//till start reached
            char current = Character.toUpperCase(key.charAt(end));//exctract , capitalize
            if (current == '-') {//ignore -
                end--;//just shift end -1

            } else if (groupCount != 0 //if current group is not 0 AND
                    && groupCount % group == 0) {//it is number of group ( 2 MOD 2 = 0 - so mathces, 1 MOD 2 !=0 - so mo mach continue accumulating chars
                res.insert(0,'-');//matched group count - insert to start \-\
                groupCount = 0;//sbros count
            }else{//just a char
                res.insert(0,current);//insert to start , here actually append may be  used and reverse at he end
                groupCount++;//accumulate group count
                end--;//shift end -1
            }
        }

        return res.toString();
    }
}
