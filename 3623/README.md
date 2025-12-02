# Count the Number of Trapezoids (LeetCode 3623)

## Key Insight (Your Observation)

A trapezoid requires two horizontal (parallel) edges, so the only thing that matters is:

### Points that lie on the same y-coordinate
For each horizontal row with p points:
We can choose any 2 points to form a horizontal segment

Number of segments =
```
C(p, 2) = p * (p - 1) / 2
sum_over_rows( currentRowPairs * sumOfAllPreviousPairs )

```
### Time & Space Complexity
```
Component	             Cost
Sorting	                 O(n log n)
Single pass grouping	 O(n)
Total Time	             O(n log n)
Space	                 O(1) 
```