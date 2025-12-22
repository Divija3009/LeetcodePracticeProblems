# 955. Delete Columns to Make Sorted II

## Core Idea (Greedy)

We process columns left to right, deciding whether each column:
Must be deleted because it breaks lexicographic order, or
Can be kept, helping establish sorted order for some rows
We track which adjacent rows are already confirmed sorted so we don’t compare them again.

## Key Insight
Once two rows are confirmed ordered:
```
strs[i] < strs[i+1]
```

they never need further comparison.
This allows us to:
- Avoid deleting safe columns
- Only delete columns that cause an actual violation

## Complexity Analysis
- Time Complexity: O(rows × cols)
- Space Complexity: O(rows)