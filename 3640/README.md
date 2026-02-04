# Trionic Array II (LeetCode 3640)

## 🧩 Problem Description

You are given an integer array `nums` of length `n`.

A **trionic subarray** is a contiguous subarray `nums[l…r]` (`0 ≤ l < r < n`) for which there exist indices `l < p < q < r` such that:

1. `nums[l…p]` is **strictly increasing**
2. `nums[p…q]` is **strictly decreasing**
3. `nums[q…r]` is **strictly increasing**

Your task is to **return the maximum possible sum** of any trionic subarray.

---

## 💡 Key Observations

- The subarray must be **contiguous**
- All three phases (**increase → decrease → increase**) must occur **in order**
- Each phase must contain **at least one valid comparison**
- The maximum sum can be **negative**
- The problem is well suited for **Dynamic Programming** since each position depends only on the next position

---

## DP State Definition

We use Dynamic Programming with **trend states** to track which phase of the trionic pattern we are in.

### State

- `i` → current index (0 to n)
- `trend` →
  - `0` → not started (looking for first increase)
  - `1` → first increasing
  - `2` → decreasing
  - `3` → second increasing (valid trionic)

`dp[i][trend]` stores the **maximum trionic sum starting at index `i`** in the given trend.

---

## 🚀 Approach 1: Recursion + Memoization

### Idea
- Use DFS with memoization
- Avoid recomputation by caching `(i, trend)`
- Naturally explores all valid trionic paths

### Complexity
- **Time:** `O(n)`
- **Space:** `O(n)` (memo table + recursion stack)

---

## 🚀 Approach 2: Tabulation (Bottom-Up DP)

### Idea
- Build DP table from index `n → 0`
- Avoid recursion
- Cleaner base-case handling with `n + 1` DP size

### Complexity
- **Time:** `O(n)`
- **Space:** `O(n)`
- Can be optimized to **O(1)** using rolling arrays

---

