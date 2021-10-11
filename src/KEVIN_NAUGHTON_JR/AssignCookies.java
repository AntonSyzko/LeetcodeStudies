package KEVIN_NAUGHTON_JR;

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {

        int[] greed_of_children = new int[]{1, 2, 3};
        int[] cookies_sizes = new int[]{1, 2};

        System.out.println(" content children " + findContentChildren2(greed_of_children, cookies_sizes));
    }

    static int findContentChildren(int[] children_greed_factors, int[] cookies_sizes) {
        // greedy approach - by sorting - greediest child and biggest cookies will be taken first
        Arrays.sort(children_greed_factors);
        Arrays.sort(cookies_sizes);

        int contentChildrenResult = 0;

        int greediest_child_pointer = children_greed_factors.length - 1;
        int largest_cookie_size = cookies_sizes.length - 1;

        while (greediest_child_pointer >= 0 && largest_cookie_size >= 0) {
            if (cookies_sizes[largest_cookie_size] >= children_greed_factors[greediest_child_pointer]) {
                contentChildrenResult++;
                greediest_child_pointer--;
                largest_cookie_size--;
            } else {
                greediest_child_pointer--;
            }
        }

        return contentChildrenResult;
    }

    static int findContentChildren2(int[] children_greed_factors, int[] cookies_sizes) {
        //sort ahead
        Arrays.sort(children_greed_factors);
        Arrays.sort(cookies_sizes);

        //two pointer approach
        int children_pointer = 0;//pointer of greed factors AND  content children ( result)
        int cookie_size_pointer = 0;//pointer of cookie size

        while (children_pointer < children_greed_factors.length && cookie_size_pointer < cookies_sizes.length) {//bounds array
            //if greed factor of curr child <= cookie size
            if (children_greed_factors[children_pointer] <= cookies_sizes[cookie_size_pointer]) {
                children_pointer++;//we have  one content child
                cookie_size_pointer++;//and we used on cookie of size
            } else {
                cookie_size_pointer++;//increase cookie size - since child greed factor was higher
            }
        }

        return children_pointer;//number of satisfied child greed factors which is num of kids
    }

}
