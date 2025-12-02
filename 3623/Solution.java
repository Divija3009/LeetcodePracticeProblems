import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {

        final int MOD = 1_000_000_007;

        // 1. Sort points based on y-coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        long ans = 0;
        long previousPairsSum = 0;

        int n = points.length;

        // 2. Group points with same y-level
        int i = 0;
        while (i < n) {
            int y = points[i][1];
            int count = 0;

            // Count all points having this y
            while (i < n && points[i][1] == y) {
                count++;
                i++;
            }

            // 3. Compute number of horizontal segments on this y-level
            long pairs = (long) count * (count - 1) / 2;  // C(count, 2)

            // 4. Combine with all previous y-levels
            // trapezoids formed = pairs_current * sum(previous_pairs)
            ans = (ans + pairs * previousPairsSum) % MOD;

            // 5. Update previous pairs sum
            previousPairsSum = (previousPairsSum + pairs) % MOD;
        }

        return (int) ans;
    }
}
