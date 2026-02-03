# Trionic Array I (LeetCode 3637)

## Problem Statement

You are given an integer array `nums` of length `n`.

An array is called **trionic** if there exist indices `0 < p < q < n - 1` such that:

- `nums[0...p]` is **strictly increasing**
- `nums[p...q]` is **strictly decreasing**
- `nums[q...n - 1]` is **strictly increasing**

Return `true` if `nums` is trionic, otherwise return `false`.

---

## Intuition

A trionic array follows a **three-phase pattern**:

1. First strictly increasing sequence  
2. Then strictly decreasing sequence  
3. Finally strictly increasing sequence again  

We scan the array once and identify:
- `p`: end of the first increasing phase
- `q`: end of the decreasing phase

If all three phases exist and follow strict ordering, the array is trionic.

---

## Approach (Single Pass)

1. Traverse from left to right while elements are **strictly increasing** to find index `p`
2. From `p`, traverse while elements are **strictly decreasing** to find index `q`
3. Ensure the remaining elements after `q` are **strictly increasing**
4. Validate index constraints: `0 < p < q < n - 1`

---

## Time and Space Complexity
- Time Complexity: O(n)
- Space Complexity: O(1)