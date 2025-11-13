# 3228. Maximum Number of Operations to Move Ones to the End

## Approach — Greedy (Left → Right Scan)

Every time we encounter a '0', all previously seen '1's (to the left) will eventually need to move past this '0'.
So this '0' contributes count1seen operations.

We simply:
- count '1's seen so far,
- whenever we hit a '0', add count1seen to result,
- skip consecutive zeros in one go (just to avoid repeated checks).
- This greedy logic ensures we count all required swaps.

## Time & Space Complexity

- Time: O(n)
- Space: O(1)