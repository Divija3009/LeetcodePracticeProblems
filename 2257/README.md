# LeetCode 2257 — Count Unguarded Cells in the Grid

## Approach (Sweep & Mark)

- We model the grid and sweep rays from each guard in the four directions. While sweeping:
- Stop if we hit a wall ('W') or another guard ('G').
- For each empty cell we encounter, mark it as seen (set to 1) to avoid double counting when multiple guards see the same cell.
- Finally, the answer is:

  ```
  m * n  -  (#guarded cells we marked)  -  (#guards)  -  (#walls)

  ```
