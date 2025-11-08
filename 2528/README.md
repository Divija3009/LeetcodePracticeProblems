# 2528. Maximize the Minimum Powered City

## Intuition
We want to make the weakest (least-powered) city as strong as possible after optimally placing up to k new stations.
To find the best possible minimum power efficiently:
- Use binary search to guess a possible minimum power value mid.
- For each guess, check whether it’s feasible to make every city have at least mid power using ≤ k new stations.

## Approach
1. Precompute coverage with a difference array
Each existing station affects all cities in its range [i − r, i + r].
Using a difference array, we mark where each station’s influence starts and ends:
```
diff[left] += stations[i];
if (right < n) diff[right] -= stations[i];

```
After taking prefix sums, diff[i] represents the current power at city i.

2. Binary search on the minimum power

We binary search between:
- left = minimum initial station count
- right = sum of all stations + k (worst-case upper bound)

For each middle value mid:
- Run a feasibility check to see if every city can reach at least power mid.

3. Feasibility check
The helper check() simulates adding stations using a difference array:
- Traverse cities from left to right, keeping a running total of current power (cumSum).
- If a city’s power < mid, calculate how many more stations (need) are required to reach mid.
- Deduct need from k.
If need > k, mid is not achievable → return false.
- Add need stations effectively at position i + r by updating the difference array:
these stations increase power for the next 2r+1 cities.
- If the sweep finishes without exhausting k, mid is achievable.

## Complexity
1. TC- O(n × log(sum + k))
2. SC- O(n)
sum = total of all initial stations.