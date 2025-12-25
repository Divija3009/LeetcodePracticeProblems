# 3075. Maximize Happiness of Selected Children

## Key Insight
To maximize the total happiness:
- Always pick the child with the highest current happiness
- Since happiness decreases by 1 after each turn, the i-th selected child effectively contributes:

```
max(happiness[i] - i, 0)

```
## Approach (Greedy + Sorting)

1. Sort the happiness array in descending order
2. Iterate over the first k elements
3. For each index i: Add max(happiness[i] - i, 0) to the result
4. Stop early if values become 0

## Complexity Analysis
- Time Complexity:	O(n log n)
- Space Complexity:	O(n) (boxing to Integer[])