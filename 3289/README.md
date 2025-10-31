# LeetCode 3289 — Get Sneaky Numbers (Two Duplicates)

Given an array nums of length n + 2 containing the integers 0..n-1. Exactly two numbers appear twice, and every other number appears once. Return the two duplicated (“sneaky”) numbers in any order.

This README explains two approaches:

## Approach 1 — Counting / Frequency Array
### Idea / Intuition
Since all values are in 0..n-1, we can keep a frequency array count of size n.
As we scan nums, whenever a value’s count exceeds 1, it’s a duplicate. Collect two such values and return.

### Steps
1. Create int[] count = new int[n] where n = nums.length - 2.
2. Iterate nums:
3. Increment count[nums[i]].
4. If count[nums[i]] becomes 2, append nums[i] to result.
5. Stop after finding two numbers.
6. Return the pair.

### Time & Space

1. Time: O(n) — single pass through nums.
2. Space: O(n) — frequency array of length n.

## Approach 2 — Math with Sum & Sum of Squares (O(1) Extra Space)
### Idea / Intuition

Let the two duplicates be x1 and x2.
Compute:
```
sum = Σ nums[i]
squaredSum = Σ nums[i]^2
```
Also compute the expected totals if there were no duplicates:
```
expectedSum = Σ_{k=0}^{n-1} k = n(n-1)/2
expectedSquaredSum = Σ_{k=0}^{n-1} k^2 = n(n-1)(2n-1)/6
```
Then define the differences:
```
S = sum - expectedSum = x1 + x2
Q = squaredSum - expectedSquaredSum = x1^2 + x2^2
From identities:

(x1 + x2)^2 = x1^2 + x2^2 + 2x1x2
=> S^2 = Q + 2P, where P = x1 * x2
=> P = (S^2 - Q)/2
```
Now x1 and x2 are the roots of:
```
t^2 - S * t + P = 0
```
Solve via quadratic formula:
```
discriminant D = S^2 - 4P
x1 = (S + sqrt(D)) / 2
x2 = (S - sqrt(D)) / 2
```
### Time & Space

1. Time: O(n) — single pass to accumulate sums.
2. Space: O(1) — only a few variables.