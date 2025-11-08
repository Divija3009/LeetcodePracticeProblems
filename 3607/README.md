# LeetCode 3607 — Power Grid Maintenance

## Idea
- The problem is about managing cities connected by power lines. Cities connected through any sequence of power lines form a group.
Even if some cities shut down, the connections between cities never change — only the availability of cities does.
- So, the main idea is:
1. Group all cities that are connected to each other (using DFS or BFS).
2. Keep track of which cities are still powered in each group.
3. When a query comes in:
- For [1, x]: return the smallest still-powered city from the same group as x.
- For [2, x]: mark city x as shut down (remove it from the powered list).

## Approach (DFS version)

1. Build a graph of city connections using an adjacency list.
2. Run DFS from each unvisited city to find all cities connected to it, forming one group.
3. For each group, maintain a sorted set (TreeSet) of cities that are still powered.
4. For each query:

- [1, x]: If x is still powered → return x.
- Else if any city in its group is powered → return the smallest city number.
- Else → return -1.
- [2, x]: remove x from its group’s set of powered cities.

## Complexity Recap

- Time: O((c + n) + q log c) with TreeSet
- Space: O(c + n)
