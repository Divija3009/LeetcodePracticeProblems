# LeetCode 3542 — Minimum Operations to Convert Array to Zero

## BruteForce Approach:-

Find distinct positive values in nums → t.
To compute the total number of such operations, observe:

- If we fix a value t, all elements ≥ t can remain together in one region (block).
- Inside such a region, if there is at least one occurrence of t, we can perform one operation to turn those ts → 0.
- Each break where numbers drop below t ends that block and starts a new one.

So for every distinct positive t, we count how many contiguous “blocks” of values ≥ t contain at least one t.
The total number of operations = sum of all these block counts over all distinct t.

### Complexity

- Time Complexity	O(U × n) — for each unique value U, we traverse the array once.
- Space Complexity	O(U) for the set of unique numbers (≈ O(n) worst case).

## Optimal Approach

### Core Idea

While scanning left→right, maintain a strictly increasing stack of positive values that represent the “active minimums” of blocks we can still continue.
- When the next number x is smaller than the stack top, any larger top cannot stay a minimum through x ⇒ pop while top > x.
- If x == 0 ⇒ it never starts a block; just continue.
- If x > 0 and (stack is empty or stack.top < x) ⇒ we’re starting a new block for value x (a region where all numbers are ≥ x and contains at least one x) ⇒ push x and increment ops.

This single pass counts exactly the number of “value-blocks” summed over all distinct positive values, what the brute force computed explicitly per value.

### Complexity

- Time: O(2*n) ~ O(n) each element is pushed/popped at most once.
- Space: O(n) worst-case (monotone stack).
