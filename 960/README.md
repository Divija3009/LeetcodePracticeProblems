# 960. Delete Columns to Make Sorted III

## Key Insight

Instead of thinking about which columns to delete, think about:
```
Which columns can be safely kept in order
```
If we keep the longest possible sequence of columns that maintains sorting for every row,
then everything else must be deleted.

This converts the problem into:
```
Longest Increasing Subsequence (LIS) on columns
```
###  Why isValid() is needed
A column comparison must work across all strings, not just one.

## Complexity Analysis
- Time Complexity: O(cols² × rows)
- Space Complexity: O(cols)