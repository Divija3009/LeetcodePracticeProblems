# Problem 3318 Maximum Subarray Sum With Length Divisible by K

## Approach — Kadane’s Algorithm on Blocked Subarrays

### Key Insight

- A subarray of length divisible by k must start at some index i and end at:
```
j = i + k - 1          (length = k)
j = i + 2k - 1         (length = 2k)
j = i + 3k - 1         (length = 3k)

```

This means:
- For each possible start offset (0 to k−1)
- We collect sums of blocks of size k, 2k, 3k…

These block sums act like “chunks”, and we can apply Kadane’s algorithm on these chunk sums to find the maximum possible subsequence of blocks.
(Kadane’s algorithm answers this question at every element:
Should I extend the current subarray,
or should I start a new subarray from this element?)

### Apply This Same Concept to Your Problem (Block Kadane)

Instead of “single elements”, you have block sums (subarrays of size k, 2k, 3k,…).
For each starting offset:
```
subSum = sum of block i..j (length = t*k)

```
And Kadane becomes:
```
currSum = max(subSum, currSum + subSum)
```

Where:
- subSum → start a new valid block-subarray
- currSum + subSum → extend the previous sequence of blocks

This is exactly Kadane’s logic, but applied to block sums.

### Time & Space Complexity
- Time: O(n) — Each element is processed only a few times (k groups, stepping in jumps of k)
- Space: O(n) — Prefix sum array