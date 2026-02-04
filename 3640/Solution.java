//Java Tabulation Implementation

class Solution {
    static final long NEG_INF = Long.MIN_VALUE / 2;

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n + 1][4];

        // Base case
        for (int t = 0; t < 4; t++) {
            dp[n][t] = (t == 3) ? 0 : NEG_INF;
        }

        // Bottom-up DP
        for (int i = n - 1; i >= 0; i--) {
            for (int trend = 0; trend < 4; trend++) {
                long take = NEG_INF;
                long skip = NEG_INF;

                if (trend == 0) {
                    skip = dp[i + 1][0];
                }

                if (trend == 3) {
                    take = nums[i];
                }

                if (i + 1 < n) {
                    int curr = nums[i];
                    int next = nums[i + 1];

                    if (trend == 0 && next > curr)
                        take = Math.max(take, curr + dp[i + 1][1]);
                    else if (trend == 1) {
                        if (next > curr)
                            take = Math.max(take, curr + dp[i + 1][1]);
                        else if (next < curr)
                            take = Math.max(take, curr + dp[i + 1][2]);
                    }
                    else if (trend == 2) {
                        if (next < curr)
                            take = Math.max(take, curr + dp[i + 1][2]);
                        else if (next > curr)
                            take = Math.max(take, curr + dp[i + 1][3]);
                    }
                    else if (trend == 3 && next > curr) {
                        take = Math.max(take, curr + dp[i + 1][3]);
                    }
                }

                dp[i][trend] = Math.max(take, skip);
            }
        }

        return dp[0][0];
    }
}