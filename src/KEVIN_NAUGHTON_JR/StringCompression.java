package KEVIN_NAUGHTON_JR;

public class StringCompression {
    public static void main(String[] args) {

        String uncompressed = "aaaaaaaaaaaa";
        int compressed = compressStringNumberOfCompressedChars(uncompressed.toCharArray());
        System.out.println(compressed);

        String uncompressed2 = "aaaaaaaaaaaabbccccc";
        String compressed2 = compressString(uncompressed2.toCharArray());
        System.out.println(compressed2);

    }

    static int compressStringNumberOfCompressedChars(char[] chars) {
        int index_of_new_compressed_string = 0;//index of new chars
        int move_in_original_string_index = 0;//traverse original index

        while (move_in_original_string_index < chars.length) {//traverse condition
            int index_of_repeated_chars = move_in_original_string_index;//repeated index

            //traverse cond + equality check
            while (index_of_repeated_chars < chars.length && chars[index_of_repeated_chars] == chars[move_in_original_string_index]) {
                // if(chars[index_of_repeated_chars] == chars [move_in_original_string_index]){ instead of & possible
                index_of_repeated_chars++;//while equal move repeated index on
            }
            chars[index_of_new_compressed_string++] = chars[move_in_original_string_index];//paste original to new (++ is for further increment)

            if (index_of_repeated_chars - move_in_original_string_index > 1) {//if one occurence - do not compress
                String count = index_of_repeated_chars - move_in_original_string_index + "";//to make 12 = '1' '2'
                for (char digit : count.toCharArray()) {
                    chars[index_of_new_compressed_string++] = digit;//with increment to move to next in array
                }
            }
            move_in_original_string_index = index_of_repeated_chars;//move index to after all current repeated finished
        }
        return index_of_new_compressed_string;//index is actually size of compressed array

    }

    static String compressString(char[] chars) {
        int index_of_new_compressed_string = 0;
        int move_in_original_string_index = 0;

        while (move_in_original_string_index < chars.length) {
            int index_of_repeated_chars = move_in_original_string_index;

            while (index_of_repeated_chars < chars.length && chars[index_of_repeated_chars] == chars[move_in_original_string_index]) {
                // if(chars[index_of_repeated_chars] == chars [move_in_original_string_index]){ instead of & possible
                index_of_repeated_chars++;
            }
            chars[index_of_new_compressed_string++] = chars[move_in_original_string_index];

            if (index_of_repeated_chars - move_in_original_string_index > 1) {
                String count = index_of_repeated_chars - move_in_original_string_index + "";
                for (char digit : count.toCharArray()) {
                    chars[index_of_new_compressed_string++] = digit;
                }
            }
            move_in_original_string_index = index_of_repeated_chars;
        }
        return new String(chars);

    }

}

