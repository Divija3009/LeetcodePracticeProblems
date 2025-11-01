# Leetcode 3217:- Delete Nodes from LinkedList Present in Array
## Approach

1. Store elements in a HashMap (or HashSet)

- Traverse the array nums and store each number in a HashMap for constant-time lookup.

- This helps quickly determine whether a node’s value needs to be removed.

2. Iterate through the Linked List

- Maintain a dummy head node (newHead) to simplify handling the list head.

- For each node, check if its value exists in the map:

- If not present, append it to the new list.Otherwise, skip it.

3. Break existing links

- After building the new list, set newHeadTemp.next = null to avoid residual links from the original list.

4. Return the modified list starting from newHead.next.