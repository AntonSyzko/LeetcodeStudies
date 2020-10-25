package KEVIN_NAUGHTON_JR;

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {

        int[] greed_of_children =new  int [] {1,2,3};
        int[] cookies_sizes = new int [] {1,2};

        System.out.println(" content children " + findContentChildren(greed_of_children, cookies_sizes));
    }

    static int findContentChildren(int []children_greed_factors, int [] cookies_sizes){
        // greedy approach - by sorting - greediest child and biggest cookies will be taken first
        Arrays.sort(children_greed_factors);
        Arrays.sort(cookies_sizes);

        int contentChildrenResult = 0;
         int greediest_child_pointer = children_greed_factors.length-1;
         int largest_cookie_size = cookies_sizes.length-1;

         while (greediest_child_pointer >= 0 && largest_cookie_size>=0){
             if(cookies_sizes[largest_cookie_size]>= children_greed_factors[greediest_child_pointer]){
                 contentChildrenResult++;
                 greediest_child_pointer--;
                 largest_cookie_size--;
             }else {
                 greediest_child_pointer--;
             }
         }

         return contentChildrenResult;
    }
}
