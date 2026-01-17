# Course Schedule II (LeetCode 210)

## Problem Statement
There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`.

You are given an array `prerequisites` where  
`prerequisites[i] = [ai, bi]` indicates that you must take course `bi` first if you want to take course `ai`.

Return **one valid order** in which all courses can be completed.  
If it is impossible to finish all courses, return an **empty array**.

---

## 💡 Key Insight
This problem can be modeled as a **Directed Graph**:

- **Nodes** → Courses
- **Edges** → Prerequisite relationships (`bi → ai`)

The task is to find a **Topological Ordering** of the graph.

- If a **cycle exists**, topological ordering is not possible
- If the graph is a **DAG**, a valid course order exists

---

## Approach: Kahn’s Algorithm (BFS Topological Sort)

We use **Breadth-First Search (BFS)** with **indegree tracking** to generate the course order.

---

## 🔄 Algorithm Steps

### Step 1: Build the Graph
- Create an adjacency list
- For each prerequisite `[course, prereq]`, add:

### Step 2: Compute Indegree
- `indegree[i]` stores how many prerequisites course `i` has

---

### Step 3: Initialize Queue
- Add all courses with `indegree = 0` to the queue
- These courses can be taken immediately

---

### Step 4: BFS Traversal
- Remove a course from the queue
- Add it to the topological order
- Reduce indegree of its dependent courses
- If a dependent course reaches indegree `0`, add it to the queue

---

### Step 5: Cycle Check
- If the size of the topological order is **less than `numCourses`**, a cycle exists
- Return an empty array in that case

---

## Time & Space Complexity

- Time: O(V + E)
- Space: O(V + E)
Where:
V = number of courses and E = number of prerequisites