mport java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys,
                          int[][] containedBoxes, int[] initialBoxes) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] haveBox = new boolean[status.length];
        boolean[] visited = new boolean[status.length];

        // Initially owned boxes
        for (int box : initialBoxes) {
            haveBox[box] = true;
            if (status[box] == 1) {
                queue.offer(box);
            }
        }

        int total = 0;

        while (!queue.isEmpty()) {
            int box = queue.poll();

            if (visited[box])
                continue;

            visited[box] = true;
            total += candies[box];

            // Get keys
            for (int key : keys[box]) {
                status[key] = 1;

                if (haveBox[key] && !visited[key]) {
                    queue.offer(key);
                }
            }

            // Get contained boxes
            for (int newBox : containedBoxes[box]) {
                haveBox[newBox] = true;

                if (status[newBox] == 1 && !visited[newBox]) {
                    queue.offer(newBox);
                }
            }
        }

        return total;
    }
}
