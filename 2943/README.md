# Leetcode 2943 Maximize Square Hole Area in a Grid

# Intuition
Removing a horizontal line creates a vertical gap
Removing a vertical line creates a horizontal gap
So:
- Horizontal bars control the height of the hole
- Vertical bars control the width of the hole
To form a big square hole, we need:
- a large vertical gap (height)
- a large horizontal gap (width)

## How do we get a bigger gap?
A bigger gap is formed when we remove maximum consecutive lines.

Example:

Removing bars [3,4,5] together creates one large gap
Removing [3,5] does not (they are not consecutive)

So the problem reduces to:
Find the maximum number of consecutive removed bars
for both horizontal and vertical directions.

## Converting bars to gap size
If we remove:
k consecutive bars
Then the gap created is:
```
k + 1
```
So:
- Maximum height = maxConsecutiveHorizontal + 1
- Maximum width = maxConsecutiveVertical + 1

## Why take min?
A square needs equal height and width.
Even if:
- height = 6
- width = 4
The biggest square possible is:
```
4 × 4

and 

side = min(maxConsecutiveHorizontal + 1,
           maxConsecutiveVertical   + 1)

area = side × side
```
## Complexity

- Time: O(h log h + v log v) (sorting)
- Space: O(1) extra space

