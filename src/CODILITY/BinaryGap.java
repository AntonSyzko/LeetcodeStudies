package CODILITY;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryGap {

    @Test
    public void testSolution() {
        assertEquals(4, new BinaryGap().solution(33));

    }

    public int solution(int number) {
        //look for the first occurence of 1 in bit representation
        int firstIndex = 0;
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            if (getNthBit(number, bitPosition) == 1) {
                firstIndex = bitPosition;
                break;
            }
        }

        //from now on every 1 is a beginning of the end of a Binary Gap
        int currentGap = 0;

        //we check the next bit
        int biggestGap = 0;
        for (int bitPosition = firstIndex; bitPosition < 32; bitPosition++) {
            //IF CURRENT BIT IS ZERO
            if (getNthBit(number, bitPosition) == 0) {
                //we increment the current gap by 1
                currentGap++;
            } else {
                //if it is otherwise 1 we are at the end of current binary gAP
                if (currentGap > biggestGap) {//if current gap is bigger then biggest so far
                    //we update biggest
                    biggestGap = currentGap;
                }
                //this is the end of the current bin gap
                currentGap = 0;
            }
        }
        //we do this untilo the end of 32 bit integer
        return biggestGap;
    }


    private int getNthBit(int number, int bitPosition) {
        int mask = 1;
        final int theNumberShifted = number >> bitPosition;
        return theNumberShifted & mask;
    }
}
