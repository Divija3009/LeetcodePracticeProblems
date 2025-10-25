// LeetCode 1716. Calculate Money in Leetcode Bank
// O(n) time, O(1) space — simulate day by day.
class SolutionIterative {
    public int totalMoney(int n) {
        if (n == 1) return 1;

        int sum = 1, counter = 1, start = 1; // day 1 put $1

        for (int day = 2; day <= n; ++day) {
            if ((day - 1) % 7 == 0) { // new Monday
                ++start;              // next Monday starts $1 higher
                counter = 0;          // reset day offset inside the week
            }
            sum += (start + counter); // deposit for this day
            ++counter;                // move to next day in the week
        }
        return sum;
    }
}
