# 757. Set Intersection Size At Least Two

## Intuition

We want to pick as few numbers as possible, but every interval must have at least 2 numbers from our chosen set.

### Key idea:

1. If we process intervals in a smart order, we can reuse already-chosen numbers to satisfy future intervals.
2. To maximize reuse, we want to pick numbers as far to the right as possible (near the interval's end), so they are more likely to lie inside later intervals.
3. So:
- We sort intervals by their end point.
- For intervals with the same end, we sort by start in descending order so that tighter intervals (starting later) are handled first.

This is a classic greedy strategy:

- Always pick the rightmost possible elements that still satisfy the current interval, so they have the best chance to satisfy future ones.

### Why This Sorting?

1. Primary key: end ascending
→ So we always deal with intervals that finish earlier first. This lets us “lock in” numbers near the right side which also work for later intervals.

2. Secondary key: start descending (when end is the same)
→ Among intervals ending at the same point, shorter/tighter ones (larger start) are harder to satisfy.
If we satisfy them first with rightmost numbers (r-1, r), wider intervals with same end will automatically be satisfied too.

## Full Algorithm Steps

1. Sort intervals by:
- end ascending,
- if tie, start descending.
2. Initialize:
- int result = 0;
- int first = -1, second = -1;
3. For each interval [l, r]:
- If l <= first → interval already has at least 2 points → continue.
- Else if l > second → no points inside → add r-1, r.
- Else → only second inside → add r.
4. Return result.

## Complexity
1. Time Complexity: Sorting takes O(n log n).
2. Space Complexity:O(1)