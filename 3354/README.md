# Count Valid Selections (LeetCode 3354)

## Approach 1 – Simulation-Based Solution

This approach directly simulates the described process.
1. For each index where arr[i] == 0:
2. Simulate once by moving left, and once by moving right.
3. During the simulation:
4. Maintain a copy of the array.
5. Decrement values as per the rules.
6. Flip directions after consuming one value.
7. Stop once the pointer goes out of bounds.
8. If all numbers become zero by the end of the simulation, the path is valid.

## Approach 2 – Observation / Prefix Sum Solution

We can deduce the result mathematically instead of simulating the process.
Let:
leftSum = sum of all elements before index i
rightSum = sum of all elements after index i

Then, for each i where arr[i] == 0:
If leftSum == rightSum → both directions are valid → add 2.
If |leftSum - rightSum| == 1 → only one direction is valid → add 1.

Otherwise → add 0.

This logic arises from balancing how much “work” remains on each side of the pointer.