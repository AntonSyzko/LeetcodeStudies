package LEET_CODE;


public class DefangingIPAddress {

    public static void main(String[] args) {
        String ip_address = "127.0.0.1";
        String defanged = defangIpAddress(ip_address);
        System.out.println(defanged);
    }

    static String defangIpAddress(String ipAddress){
        StringBuilder sb = new StringBuilder(ipAddress.length());//optimization
        for(int i = 0; i < ipAddress.length(); i++){// O(n)
            if(ipAddress.charAt(i) == '.'){
                sb.append("[.]");
            }else{
                sb.append(ipAddress.charAt(i));
            }
        }
        return sb.toString();
    }
}
