package graphs;

import java.util.*;

public class RottenOranges {
    public int orangesRotting(int[][] grid){
        // Check if there are any fresh oranges initially
        boolean freshExists = false;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    freshExists = true;
                    break;
                }
            }
        }

        if(!freshExists){
            return 0;
        }

        int minutes =0;
        Queue<int[]> rottenQueue = new LinkedList<>();
        int freshCount = 0;
        int rowCount = grid.length;

        for(int i=0; i<rowCount; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 2){
                    rottenQueue.offer(new int[] { i, j});
                }else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        while(!rottenQueue.isEmpty()){
            minutes++;
            int rottenCount = 0;
            int queueSize = rottenQueue.size();

            for(int k=0; k < queueSize; k++){
                int[] coordinates = rottenQueue.poll();
                int x = coordinates[0];
                int y = coordinates[1];

                int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

                for(int[] dir : directions){
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if(nx >=0 && nx < rowCount
                            && ny >=0 && ny < grid[nx].length && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        rottenQueue.offer(new int[] {nx, ny});
                        rottenCount++;
                    }
                }
            }
            if(rottenCount == 0){
                break;
            }

            freshCount -= rottenCount;
        }

        if(freshCount > 0){
            return -1;
        }else {
            return minutes - 1;
        }
    }

    public static void main(String[] args){
        RottenOranges rottenOrangesObj = new RottenOranges();

        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(rottenOrangesObj.orangesRotting(grid1));

        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(rottenOrangesObj.orangesRotting(grid2));

        int[][] grid3 = {{0, 2}};
        System.out.println(rottenOrangesObj.orangesRotting(grid3));
    }

}
