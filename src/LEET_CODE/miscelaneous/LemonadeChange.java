package LEET_CODE.miscelaneous;

/*
given customer can pay only with 5, 10, 20 dollar bills
and lemonade costs 5
no change at the  beginning
return if you can provide change
 */
public class LemonadeChange {

    public static void main(String[] args) {
        int[] bills = new int[]{5, 5, 5, 10, 20};
        boolean canPayChange = canProvideChange(bills);
        System.out.println(canPayChange);
    }

    static boolean canProvideChange(int[] bills) {
        int fiveDollarBills = 0;
        int tenDollarBills = 0;

        for (Integer bill : bills) {
            if (bill == 5) {
                fiveDollarBills++;
            } else if (bill == 10) {
                tenDollarBills++;
                fiveDollarBills--;// 5 dollars change paid here
            } else if (tenDollarBills > 0) {//provided not 5 nor 10 - so 20, if we hhave 10 dollar bill at he moment
                tenDollarBills--;//pay one 10 dollar bill change
                fiveDollarBills--;//and one 5 dollar bill change
            } else {//given 20 also - but no 10 dollar bills available
                fiveDollarBills -= 3;//pay three times 5 dollar

            }

            if (fiveDollarBills < 0) return false;//if five dollar bills went NEGATIVE - you cannot provide change
        }

        return true;//got here - enough 5 dollar bills to pay change
    }
}
