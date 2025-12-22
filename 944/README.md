# Leetcode 944. Delete Columns to Make Sorted

## Approach
### Column-wise traversal
1. Iterate column by column
2. For each column, compare characters row by row
3. If any character is smaller than the one above it, the column is not sorted
4. Count that column and move on
- Once a column is detected as invalid, there’s no need to check further rows in that column.

### Key Insight

A column is valid only if:
```
strs[0][j] ≤ strs[1][j] ≤ strs[2][j] ≤ ...

```
## Complexity Analysis

- Time Complexity: O(rows × cols)
- Space Complexity: O(1)