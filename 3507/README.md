## 3507. Minimum Pair Removal to Sort Array I

### Problem Summary
You are given an integer array `nums`. You can repeatedly perform the following operation:

- Select the **adjacent pair with the minimum sum** (if multiple exist, choose the **leftmost** one).
- Replace the pair with their **sum**.

Your task is to return the **minimum number of operations** required to make the array **non-decreasing**.

An array is **non-decreasing** if every element is greater than or equal to the previous one.

---

### Approach Overview
This solution uses a **greedy simulation** strategy:

1. Convert the input array into a `LinkedList` for easier removal.
2. Repeatedly:
   - Check if the list is already sorted.
   - Find the adjacent pair with the **minimum sum**.
   - Replace the left element of the pair with the sum.
   - Remove the right element of the pair.
   - Count the operation.
3. Stop when the list becomes non-decreasing.

---

### Algorithm Steps
1. Initialize a `LinkedList<Integer>` from the input array.
2. While the list is **not sorted**:
   - Iterate through adjacent pairs to find the minimum sum.
   - Replace the left index with the sum.
   - Remove the right index.
   - Increment operation count.
3. Return the total number of operations.

---

### Correctness
- The problem **forces a greedy choice**: always pick the adjacent pair with the minimum sum.
- Leftmost tie-breaking is naturally handled by scanning from left to right.
- Each operation reduces the size of the list, guaranteeing termination.

---

### ⏱️ Complexity Analysis
- **Time Complexity:**  
  - Each iteration scans the list → `O(n)`
  - Up to `n` iterations → **`O(n²)`**

- **Space Complexity:**  
  - Uses a `LinkedList` copy of the array → **`O(n)`**
