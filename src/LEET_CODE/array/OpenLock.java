package LEET_CODE.array;

import java.util.*;

public class OpenLock {

    public static void main(String[] args) {
       String[] deadends = {"0201","0101"};
       String target = "0202";
       int combinationToOpen = openLock(deadends, target);
        System.out.println(combinationToOpen);
    }

    static int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        int modificationsMade = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                String lock_position = queue.poll();
                if (deadendsSet.contains(lock_position)) {
                    size--;
                    continue;
                }

                if (lock_position.equals(target)) {
                    return modificationsMade;
                }


                StringBuilder sb = new StringBuilder(lock_position);

                for (int i = 0; i < 4; i++) {
                    char current_char_at_position = sb.charAt(i);

                    String modLockOnwardRotation = sb.substring(0, i) + (current_char_at_position == '9' ? 0 : current_char_at_position - '0' + 1)
                            + sb.substring(i + 1);

                    String modLockBackwatdRotation = sb.substring(0, i) + (current_char_at_position == '0' ? 9 : current_char_at_position - '0' - 1)
                            + sb.substring(i + 1);

                    if (!visited.contains(modLockOnwardRotation) && !deadendsSet.contains(modLockOnwardRotation)) {
                        queue.offer(modLockOnwardRotation);
                        visited.add(modLockOnwardRotation);
                    }

                    if (!visited.contains(modLockBackwatdRotation) && !deadendsSet.contains(modLockBackwatdRotation)) {
                        queue.offer(modLockBackwatdRotation);
                        visited.add(modLockBackwatdRotation);
                    }

                }
                size--;

            }
            modificationsMade++;
        }

        return -1;
    }
}

