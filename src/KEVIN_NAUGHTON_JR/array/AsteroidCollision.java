package KEVIN_NAUGHTON_JR.array;

import java.util.Arrays;
import java.util.Stack;

/*
 10 2 -5
  + sign - asteroid moving right  ,  - sign - asteroids moving left
  equal number - asteroids both destroy
  bigger asteroid destroys smaller - in case of collision
 */
public class AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = new int[]{5, 10, -5};
        int []remainedAteroids = collideAsteroids(asteroids);
        System.out.println(Arrays.toString(remainedAteroids));

    }

    static int[] collideAsteroids(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int counter = 0;//just for traversion

        while (counter < asteroids.length) {//traverse
            if (asteroids[counter] > 0) {//if current asteroid is moving right
                stack.push(asteroids[counter]);
            } else {//if moving left
                while (!stack.isEmpty() && //if smth in stack
                        stack.peek() > 0 && // if current in stack is moving right
                        stack.peek() < asteroids[counter]) {//and smaller then current moving left
                    stack.pop();// this smaller moving right gets destroyed
                }
                if (stack.isEmpty() || //if nothing in stack
                        stack.peek() < 0) { // if in stack is moving left
                    stack.add(asteroids[counter]);//add moving left to stack
                } else if (stack.peek() == Math.abs(asteroids[counter])) {//if smth in stack is same in value ( abs )
                    stack.pop();//destroy
                }
            }
            counter++;

        }

        int[] remainedAsteroids = new int[stack.size()];
        for (int i = stack.size()-1; i >= 0; i--) {//poplate result in reverse  order
            remainedAsteroids[i] = stack.pop();
        }

        return remainedAsteroids;
    }
}
