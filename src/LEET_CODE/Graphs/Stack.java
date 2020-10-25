package LEET_CODE.Graphs;

public class Stack {

    private int size = 10;
    private int top ;
    private int[] array;//holds values

    public Stack() {
        array = new int [size];
        top = -1;
    }

    public void push (int index){
        array[++top]= index;
    }

    public int pop(){
        return array[top--];
    }

    public int peek(){
        return array[top];//just show
    }

    public boolean isEmpty(){
        return top == -1 ? true: false;
    }
}
