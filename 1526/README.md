# Minimum Number of Increments on Subarrays to Form a Target Array (LeetCode 1526)

## Intuition

1. The number of operations equals the total positive increases in the array as you move left to right.
2. You need a new operation only when the next element is greater than the previous one.
3. This approach ensures each “rise” in value from one index to the next is covered by fresh increments.

## Complexity

Time: O(n) — single pass through the array.
Space: O(1) — uses constant extra space.