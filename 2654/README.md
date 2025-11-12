# Leetcode 2654: Minimum Number of Operations to Make All Array Elements Equal to 1

## Intuition

- If the array already contains some 1s, each existing 1 can “clean” a neighbor in one operation (since gcd(1, x) = 1).
So if there are count1 ones, you only need to convert the remaining n - count1 numbers → answer = n - count1.
- If there is no 1 at all, the only way to create a 1 is to find a contiguous subarray whose GCD is 1.
If the shortest such subarray has length L, it takes L - 1 operations to reduce that subarray to a single 1.
After that, use this 1 to convert all remaining n - 1 elements → total (L - 1) + (n - 1).
- If no subarray has GCD 1, it’s impossible → return -1.

## Approach

1. Count existing ones.
If count1 > 0, return n - count1.
2. Otherwise, find the shortest subarray with GCD = 1.
- For each start index i, expand j = i + 1 … n-1, maintaining gcdVal = gcd(gcdVal, nums[j]).
- When gcdVal == 1, update minStepsTo1 = min(minStepsTo1, j - i) and break (no need to extend further from this i).
3. If none found, return -1.
4. If found, total operations = minStepsTo1 + (n - 1).

## Complexity

- Time: O(n^2 * log M) — two pointers over subarrays, each GCD costs log M (where M is the max element).
- Space: O(1) — only counters and running GCD.