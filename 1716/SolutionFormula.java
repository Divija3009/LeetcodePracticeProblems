// LeetCode 1716. Calculate Money in Leetcode Bank
// O(1) time, O(1) space — closed-form using week arithmetic.
class SolutionFormula {
    public int totalMoney(int n) {
        if (n == 1) return 1;

        int weeks = n / 7;      // full weeks
        int rem   = n % 7;      // leftover days (0..6)

        // Sum of full weeks:
        // 0th week: 28
        // 1st week: 28 + 7
        // 2nd week: 28 + 7*2
        // ...
        // Sum = 28*weeks + 7*(0 + 1 + ... + (weeks-1)) = 28*weeks + 7*weeks*(weeks-1)/2
        int fullWeeks = 28 * weeks + 7 * weeks * (weeks - 1) / 2;

        // Remaining days start at (weeks + 1) and increase by 1 each day:
        // (weeks+1) + (weeks+2) + ... + (weeks+rem)
        int start = weeks + 1;
        int remSum = rem * start + rem * (rem - 1) / 2;

        return fullWeeks + remSum;
    }
}
