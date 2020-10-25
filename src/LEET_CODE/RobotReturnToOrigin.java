package LEET_CODE;

public class RobotReturnToOrigin {

    public static void main(String[] args) {

        System.out.println(returnsToOrigin("ULRD"));
        System.out.println(returnsToOrigin("ULRDD"));

    }

    static boolean returnsToOrigin(String moves){
        if(moves==null) return true;//at origin never left
        int x_axis = 0;// Ups and Downs
        int y_axis = 0;//Lefts and Rights

        for (char single_move : moves.toCharArray()){
            if (single_move == 'U'){
                y_axis+=1;
            }else if ( single_move == 'D'){
                y_axis-=1;
            } else if (single_move == 'L') {
                x_axis -=1;
            } else if (single_move == 'R') {
                x_axis +=1;
            }
        }

        return (x_axis ==0 && y_axis ==0);//if all zeros in the end - returned to origin
    }
}
