package LEET_CODE.String;

/*
given licens key 5gy7-1h5-h-2 and K number
reformat the key so that new key contain only groups with K number of chars and
first group cna have at least 1 and less than K chars

make all uppercase

 */
public class LicenseKeyReformat {
    public static void main(String[] args) {
        String oldKey = "5f3z-2e-9-w";
        String newKey = reformatLicenseKey(oldKey,4);
        System.out.println(newKey);
    }

    static String reformatLicenseKey(String key, int k){
        key = key.toUpperCase();
        key = key.replace("-","");//straih=ght away delete all -, will add necessary after

        StringBuilder sb = new StringBuilder(key);
//traverse string and insert necessary new - where jump needed 
        for (int jump = key.length()-k; jump > 0; jump=jump-k ){
            sb.insert(jump,"-");
        }

        return sb.toString();
    }
}
