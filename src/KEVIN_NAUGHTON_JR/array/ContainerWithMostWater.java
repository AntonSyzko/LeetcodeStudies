package KEVIN_NAUGHTON_JR.array;

/*
given vertical lines- find most area one
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] heiths = new int[]{1, 3, 5, 2};
        int maxArea = maxAreaSlidingWindow(heiths);
        System.out.println(maxArea);
    }


    //O(n^2)
    static int maxArea(int[] heigths) {
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < heigths.length; i++) {
            for (int j = i + 1; j < heigths.length; j++) {
                int min = Math.min(heigths[i], heigths[j]);//find bas minimum in entire heights

                //area = height ( lower as we now) * ( times ) width ( width is diff between end pointer and start pointer )
                maxArea = Math.max(maxArea, min * (j - i));//mult of min times ( i - j ) or maxArea  is MAX
            }
        }
        return maxArea;
    }

    //O(n) - sliding window
    static int maxAreaSlidingWindow(int[] heigths) {
        int maxArea = Integer.MIN_VALUE;

        int left_pointer = 0;
        int right_pointer = heigths.length - 1;

        while (left_pointer < right_pointer) {

            int min = Math.min(heigths[left_pointer], heigths[right_pointer]);

            //AREA = height ( lower as we now) * ( times ) width ( width is diff between end pointer and start pointer )
            maxArea = Math.max(maxArea, min * (right_pointer - left_pointer));

            if (heigths[left_pointer] < heigths[right_pointer]) {
                left_pointer++;
            } else {
                right_pointer--;
            }
        }

        return maxArea;
    }
}
