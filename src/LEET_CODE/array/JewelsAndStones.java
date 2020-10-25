package LEET_CODE.array;

public class JewelsAndStones {

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAABBBB";
        int jewels_count = countJewelsInStones(jewels, stones);
        System.out.println(jewels_count);
    }

    static int countJewelsInStones(String jewels, String stones){
        int jewels_counter = 0;

        for(int stone = 0; stone < stones.length(); stone++){
            if(jewels.indexOf(stones.charAt(stone))>-1){
                jewels_counter++;
            }
        }
        return jewels_counter;
    }
}
