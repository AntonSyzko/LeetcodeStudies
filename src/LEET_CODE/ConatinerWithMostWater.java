package LEET_CODE;


// time o(n)
//space o(1)
public class ConatinerWithMostWater {
    public static void main(String[] args) {
        int[] heights = new int[]{1, 2, 3, 4, 2};
        int max_area = maxAreaOfContainer(heights);
        System.out.println("max water container area is " + max_area);
    }

    static int maxAreaOfContainer(int[] heights) {
        int max_area = 0;//res
        int start_pointer = 0;//starting pinter
        int end_pointer = heights.length - 1;//end of array pointer

        while (start_pointer < end_pointer) {//moving from both sides -> <-
            if (heights[start_pointer] < heights[end_pointer]) {//area of container depends on lower height of container
                //height ( lower as we now) * ( times ) width ( width is diff between end pointer and start pointer )
                max_area = Math.max(max_area, heights[start_pointer] * (end_pointer - start_pointer));//S = height (y diagonal lowest) * width(x diagonal diff )
                start_pointer++;//move start
            } else {//one at the end was lower
                max_area = Math.max(max_area, heights[end_pointer] * (end_pointer - start_pointer));
                end_pointer--;
            }
        }

        return max_area;
    }
}
