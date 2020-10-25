package LEET_CODE.Graphs;

public class Que {
    private int[] array;
    private int size = 10;
    private int head;
    private int tail;

    private int counter ;

    public Que() {
        array = new int[size];
        head = 0;
        tail = -1;//at start
        counter = 0;
    }

    public void insert(int val){
        if(tail== size-1){
            tail = -1;//cyclic renovatin of que
        }

        array[++tail]=val;
        counter++;
    }

    public int remove(){

        if( head == size){
            head = 0;//cyclic renovation of que
        }
        counter--;
        return array[head++];
    }

    public boolean isEmpty(){
        return counter==0;
    }
}
