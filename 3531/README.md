# Count Covered Buildings (LeetCode 3531)
## Intuition

For each building at coordinate (x, y):

Look at all buildings on the same row y
→ Keep minX and maxX

Look at all buildings on the same column x
→ Keep minY and maxY

A building (x, y) is covered if and only if:
```
minX < x < maxX   (not at boundary of its row)
minY < y < maxY   (not at boundary of its column)

```
## Algorithm
1. Build Maps

We create two hash maps:
```
yToMinMaxX : maps row y → [minX, maxX]
xToMinMaxY : maps column x → [minY, maxY]

```
While iterating buildings:
Update min/max X values for row y and Update min/max Y values for column x

2. Count Covered Buildings

For each building (x, y):
Check:
```
xr = yToMinMaxX.get(y) → [minX, maxX]
yr = xToMinMaxY.get(x) → [minY, maxY]

if (minX < x < maxX) AND (minY < y < maxY)
       → building is covered(Increment count)

```
## Complexity
Tc and SC:  O(n)
