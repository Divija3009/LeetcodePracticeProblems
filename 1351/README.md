# 1351. Count Negative Numbers in a Sorted Matrix

## Observations
1. Once a negative number appears in a row, all elements to its right are also negative
2. Once a negative number appears in a column, all elements below it are also negative
3. This sorted structure allows multiple optimized approaches

## Approach 1: Brute Force
🔹 Idea
Traverse every cell and count negative values.

### Complexity

- Time: O(m * n)
- Space: O(1)

## Approach 2: Binary Search Per Row
🔹 Idea
Each row is sorted → find the first negative number using binary search, then count remaining elements.

### Complexity

- Time: O(m * log n)
- Space: O(1)

## Approach 3: Staircase Walk (Optimal)
🔹 Idea
- Start from bottom-left:
- If value is negative → count all elements to the right and move u, 
Else → move right
This works because each move eliminates a full row or column.

### Complexity

- Time: O(m + n)
- Space: O(1)