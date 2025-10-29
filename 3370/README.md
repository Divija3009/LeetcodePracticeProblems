# Leetcode 3370 Smallest Number

The logic starts with x = 1 and repeatedly applies the formula x = x * 2 + 1 until x becomes greater than or equal to the given number n.

Each iteration roughly doubles the value of x (plus 1), which means the growth is exponential. Because of this, the number of iterations required to reach or exceed n is very small — approximately proportional to the logarithm of n.

In other words, the loop continues as long as x < n, and since x grows as 1, 3, 7, 15, 31, ..., the loop executes about O(log n) times. Once x reaches or surpasses n, it is returned as the smallest number satisfying the condition.

## When does the loop stop?
The loop runs while x < n.

Stop condition ≈ 2^(k+1) - 1 >= n
→ 2^(k+1) >= n + 1
→ k + 1 >= log₂(n + 1)
→ k = O(log n)

## Final Time Complexity:

Time Complexity: O(log n)