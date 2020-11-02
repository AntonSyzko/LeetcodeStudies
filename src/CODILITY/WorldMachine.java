package CODILITY;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class WorldMachine {

    public static void main(String[] args) {
        String ops = "13 DUP 4 POP 5 DUP + DUP + -";
        System.out.println(solution(ops));

        ops = "5 6 + -";
        System.out.println(solution(ops));

        ops = "3 DUP 5 - -";
        System.out.println(solution(ops));
    }

    static int solution(String S) {
        final int overflow = (int) Math.pow(2, 20) - 1;

        final List<String> validOperation = Arrays.asList("POP", "DUP", "+", "-");

        final String[] validOperations = S.split(" ");

        Stack<Integer> stack = new Stack<>();

        for (String operation : validOperations) {
            if (!validOperation.contains(operation)) {
                stack.push(Integer.parseInt(operation));
            }
            if (stack.isEmpty()) {
                return -1;
            }
            if (operation.equalsIgnoreCase("POP")) {
                stack.pop();
            } else if (operation.equalsIgnoreCase("DUP")) {
                int duplicate = stack.peek();
                stack.push(duplicate);
            } else if (operation.equalsIgnoreCase("+")) {
                if (stack.size() < 2) {
                    return -1;
                }
                int firstTopMost = stack.pop();
                int secondTopMost = stack.pop();
                int sum = firstTopMost + secondTopMost;
                if (sum > overflow) {
                    return -1;
                }
                stack.push(sum);
            } else if (operation.equalsIgnoreCase("-")) {
                if (stack.size() < 2) {
                    return -1;
                }
                int firstTopMost = stack.pop();
                int secondTopMost = stack.pop();
                int diff = firstTopMost - secondTopMost;
                if (diff < 0 || diff > overflow || diff < -overflow) {
                    return -1;
                }
                stack.push(diff);
            }
        }
        return stack.isEmpty() ? -1 : stack.pop();
    }
}
