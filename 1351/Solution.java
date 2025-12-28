//Approach 1: Brute Force

class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    result++;
                }
            }
        }

        return result;
    }
}

//Approach 2: Binary Search
class SolutionTwo {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int result = 0;

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (grid[i][mid] < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result += (n - left);
        }

        return result;
    }
}
//Approach 3: Optimal Approach
class SolutionThree {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int result = 0;
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if (grid[row][col] < 0) {
                result += (m - row);
                col--;
            } else {
                row++;
            }
        }

        return result;
    }
}


