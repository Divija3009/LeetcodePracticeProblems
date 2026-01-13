# Leetcode 3453. Separate Squares I

## Intitution
We want to find a horizontal line y = midY such that:
```
We want to find a horizontal line y = midY such that:
```
1. for that we need to traverse to each value of y and then need to find the optimal y where the areas are equal.
2. despite of going linearly, we can choose binary search(values of potential y is sorted)

## Approach: Binary Search on Answer

1. Decide Binary Search Range
“have lowest y & highest y + l for binary search” can be the answer
2. Total Area Calculation
“totalarea = sum of areas of all squares”
3. Once total area is known:
- We only need to compare bottomArea with totalArea / 2
- No need to separately compute topArea
4. Binary Search Decision Logic
- if bottomarea ≥ toparea → reduce y
- else → increase y
```
if bottomArea(midY) ≥ totalArea / 2:
    high = midY   // move down
else:
    low = midY    // move up

```
5. How to Calculate bottomArea(midY)
For each square, three cases:
```
square bottom = y
square top    = y + l

```
Case 1: Square fully below the line
```
if midY >= y + l:
    area += l * l
```
Case 2: Square partially below the line
```
else if midY > y:
    area += (midY - y) * l

```
Case 3: Square fully above the line
```
Case 3: Square fully above the line
```
6. Precision / Termination
high and low is acceptable 10^-5
```
while (high - low > 1e-5)

```
## Complexity Analysis
Each check is O(n), binary search adds log(range)
- Time:  O(n × log(range))
- Space: O(1)
