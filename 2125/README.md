# Approach

This optimized approach avoids checking every pair of rows by:

1. Iterating through each row once.
2. Counting the number of '1's (devices) in that row.
3. When a row has at least one device:
4. Multiply its device count by the previous non-zero row’s device count to get the number of beams between them.
5. Update prev to store the current count.

This works because beams only form between consecutive non-empty rows.

# Time & Space Complexity

## Time Complexity: 
O(m × n)
(where m = number of rows, n = length of each row)

## Space Complexity: 
O(1)
(only uses a few variables)