# Leetcode 207: Course Schedule

# Problem Restated(in simple words)
- We have numCourses courses: 0 to numCourses - 1
- Each prerequisite [a, b] means:
- We must complete course b before course a
- Question:
Is it possible to finish all courses?
-We do NOT need the order, only true / false.

## Core Insight (VERY IMPORTANT)

This problem is about cycle detection in a directed graph.

Courses → nodes
Prerequisites → directed edges
- If the graph has a cycle, we can not finish all courses 
- If the graph is acyclic (DAG), we can finish all courses

## Two Standard Ways to Solve
- BFS (Kahn’s Algorithm – indegree)
- DFS (cycle detection using recursion stack)
We’ll do BFS first (most intuitive).

## Approach : BFS (Kahn’s Algorithm)

### Idea
- Count how many prerequisites each course has (indegree)
- Courses with indegree = 0 can be taken immediately
- Remove them and update remaining courses
- If all courses are removed → no cycle

### Algorithm Steps
1. Build graph
```
For [a, b]
Add edge:
b → a
```
2. Compute indegree

- indegree[x] = number of prerequisites for course x

3. Push indegree-0 courses into queue

These courses can be taken first.

4. BFS traversal

- Take a course
- Reduce indegree of dependent courses
- If indegree becomes 0 → add to queue

5.  Final check
- If number of processed courses == numCourses → true
- Else → cycle exists → false

## Time & Space Complexity

- Time: O(V + E)
- Space: O(V + E)
Where:
V = number of courses and E = number of prerequisites