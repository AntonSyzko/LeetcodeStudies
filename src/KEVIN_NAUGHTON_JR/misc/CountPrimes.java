package KEVIN_NAUGHTON_JR.misc;

public class CountPrimes {

    public static void main(String[] args) {
        int primes = countPrimes(10);
        System.out.println(primes);
    }

    static int countPrimes(int num){
        boolean[] primes = new boolean[num];

        for (int i = 2; i*i < primes.length ; i++) {
            if(!primes[i]){
                for (int j = i; j*i <primes.length ; j++) {
                    primes[i*j]=true;
                }
            }
        }
        
        int countPrimes = 0;
        for (int k = 2; k < primes.length ; k++) {
            if(!primes[k]){
                countPrimes++;
            }
        }

        return countPrimes;
    }
}
