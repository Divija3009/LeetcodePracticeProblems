class Solution {
    public int minDeletionSize(String[] strs) {
        //tabulation approach 2
       
        int cols = strs[0].length();

        int[] dp = new int[cols];
        int max = 1;

        // initialize LIS values
        for (int i = 0; i < cols; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < i; j++) {
                if (isValid(strs, j, i)) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return cols - max;
    }

    private boolean isValid(String[] strs, int prev, int curr) {
        for (int r = 0; r < strs.length; r++) {
            if (strs[r].charAt(prev) > strs[r].charAt(curr)) {
                return false;
            }
        }
        return true;
    }
}
