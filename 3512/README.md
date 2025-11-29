# 3512 - Minimum Operations to Make Array Sum Divisible by K

## Key Observation

To make the total sum divisible by k, only one thing matters:

The remainder when the total sum is divided by k.

Let:
```
sum = total sum of all elements
r = sum % k
```
If:
```
r == 0: already divisible → 0 operations
r != 0: we must fix the remainder
```
To correct the remainder, we can increase or decrease any element by exactly r units.
Thus:
Minimum operations = r = sum % k

## Time & Space Complexity
- Time	O(n) — iterate once to compute sum
- Space	O(1) — constant extra memory