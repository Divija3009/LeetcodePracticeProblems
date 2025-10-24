class SolutionBacktrack {
    // digitCount[d] = remaining times digit d may be used (start at d)
    int[] digitCount = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    // Try to build a number of exact length `count`, starting from value `curr`
    // Return the first valid number > n, or 0 if none for this length/prefix
    int backtrack(int n, int curr, int count) {
        if (count == 0) {
            // Valid iff for any digit that appeared partially, it's invalid.
            // Remaining must be either 0 (used exactly d times) or d (unused).
            for (int digit = 1; digit <= 9; digit++) {
                if (digitCount[digit] != 0 && digitCount[digit] != digit) {
                    return 0;
                }
            }
            return curr > n ? curr : 0;
        }

        int result = 0;

        // Place next digit (1..9), respecting remaining quota (digitCount[d] <= count)
        for (int digit = 1; digit <= 9; digit++) {
            if (digitCount[digit] > 0 && digitCount[digit] <= count) {
                digitCount[digit]--;
                result = backtrack(n, curr * 10 + digit, count - 1);
                digitCount[digit]++; // undo
            }
            if (result != 0) break; // early exit once found
        }

        return result;
    }

    // LeetCode signature
    public int nextBeautifulNumber(int n) {
        int numDigits = String.valueOf(n).length();

        int result = backtrack(n, 0, numDigits);
        if (result == 0) {
            result = backtrack(n, 0, numDigits + 1);
        }
        return result;
    }
}
