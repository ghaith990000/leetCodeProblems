package graphs;

import java.util.*;
public class MazeProblem {
    public int nearestExit(char[][] maze, int[] entrance){
        int rows = maze.length;
        int columns = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int steps = 0;
        int x, y;
        while(!queue.isEmpty()){
            steps++;

            int n = queue.size();

            for(int i=0; i<n; i++){
                int[] current = queue.poll();

                for(int[] direction : directions){
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];

                    // Check if this direction out of bound.
                    if(x < 0 || x >= rows || y < 0 || y >= columns) continue;

                    // Check if this direction is the wall
                    if(maze[x][y] == '+') continue;

                    // If this direction is empty, not visited and is at the boundary, we
                    // have arrived at the exit.
                    if(x == 0 || x == rows -1 || y== 0 || y == columns -1) return steps;

                    // Otherwise, we change this direction as visited and put intot the queue
                    // to check at the next step.
                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y});
                }
            }
        }
        // If all the possible nodes and directions checked but no exists found, return -1
        return -1;
    }

    public static void main(String[] args){
        char[][] maze = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };
        int[] entrance = {1, 2};

        MazeProblem mazeObj = new MazeProblem();
        int steps = mazeObj.nearestExit(maze, entrance);
        System.out.println("Steps to nearest exit: " + steps);
    }
}

