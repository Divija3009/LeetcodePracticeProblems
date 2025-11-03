# LeetCode 1578 – Minimum Time to Make Rope Colorful

## Approach

The idea is greedy — for each group of consecutive balloons with the same color, we want to keep the one with the largest neededTime and remove all others.

Steps:

1. Initialize two variables:
prev – keeps track of the previous balloon in the sequence and min – stores total minimum time.
2. Iterate through the string colors and if the current balloon has the same color as the previous one:
- Add the smaller of the two times to min and Keep the index (prev) of the larger time balloon (since we “keep” it).
- If the color changes, move prev to the current balloon.
3. Return min as the total minimum removal time.

## Complexity Analysis
1. Time	O(n) – one pass through the string
2. Space	O(1) – only constant extra variables