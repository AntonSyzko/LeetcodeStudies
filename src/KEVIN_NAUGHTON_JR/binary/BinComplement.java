package KEVIN_NAUGHTON_JR.binary;

/*
given num - find int compliment
compliment is when all non zero bits flipped to opposite
5      is     1 0 1
2      is     0 1 0
 */
public class BinComplement {

    public static void main(String[] args) {
      int compliment = complement(5);
        System.out.println(compliment);
    }

    static int complement(int num) {
        int res = 0;
        int power = 1;

        while (num > 0) {//while num still

            res += (num % 2 ^ 1) * power;//mod 2 will give last and we flip it with 1 - invert
            power <<= 1;// mult by 2  - since we deal with powers of 2 and each time we have new its power of 2
            num   >>= 1;//divide by    - since each time we extracted one power of 2

        }
        return res;
    }
}
