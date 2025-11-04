# 3318. Find X-Sum of All K-Long Subarrays I

## Approach
1. Iterate over each sliding window of length k.
2. For the current window [i … i + k − 1]:
- Build a frequency map using a HashMap<Integer,Integer> where key = number, value = its frequency.
3. Sort the entries of the frequency map:
- Primary key → count (descending)
- Secondary key → value (descending)
4. Take the top x entries after sorting.
5. Compute:
```
sum += value * frequency
```
6. Store the result for this window in the output array.
7. Repeat for all windows.

## Time & Space Complexity

1. Time Complexity	O(n × k × log k) — for each of the (n − k + 1) windows, counting O(k) + sorting O(k log k).
2. Space Complexity O(k) — frequency map and temporary list.
