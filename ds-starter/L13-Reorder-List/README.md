#  README - Reorder List 

##  Problem Statement
> Given the head of a singly linked list L0 → L1 → … → Ln, reorder it to follow the pattern:
L0 → Ln → L1 → Ln−1 → L2 → Ln−2 → …
> The reordering must be done in place, meaning you may not create or copy extra lists or change the node values.
Your task is to rearrange the nodes by adjusting the next pointers only.

---

##  Assumptions
- The list may be empty (head = null). 
- Each node contains an integer value and a reference to the next node.
- The reordering must be done in place, using only pointer manipulation.
- The algorithm must run in O(n) time and use O(1) extra space.
- The list may contain either an odd or even number of nodes
- The order of nodes is based purely on rearranging pointers, not values.

---

##  Conceptual Solution

The algorithm works in three main steps:
1. Find the middle of the list
   Use two pointers (`slow` and `fast`).
   - Slow moves one node at a time. 
   - Fast moves two nodes at a time. 
     When fast reaches the end, slow will be at the middle. 
     This divides the list into a left half and a right half. 
2. Reverse the right half:
   - Detach the right half by setting slow.next = null.
   - Reverse the right half in place. 
     After this step, the list will like this: 
   - Left: 1 → 2 → 3
   - Right (reversed): 5 → 4
3. Merge the two halves alternately
   - Use two pointers, p1 (for the left) and p2 (for the right). 
   - Alternately merge the nodes together:
     - Connect one from the left, then one from the right, and repeat. 
   - Stop when the right half runs out (while (p2 != null)). 

By following this process, the nodes are rearranged to alternate from the front 
and back of the list without using extra money. 

---

##  Example

Input: 
1 → 2 → 3 → 4 → 5

Process: 
- Step 1: Find the middle - slow stops at 3
- Step 2: Reverse right half - 5 → 4.
- Step 3: Merge - 1 → 5 → 2 → 4 → 3

Output:
  1 → 5 → 2 → 4 → 3

Explanation: 
The list is reordered by alternating nodes from the start and end: 
- First node (1), last node (5), second node (2), second-to-last node (4), then
middle node (3). 

##  Time and Space Complexity 

- Time Complexity: O(n)
  - Each node is visited a constant number of times (finding middle,
    reversing, and merging). 
- Space Complexity: O(1)
  - All operations are done in place with a few extra pointer variables only. 


##  Summary 

This algorithm efficiently reorders a singly linked list by combining three 
fundamental linked list techniques:
- Fast/slow pointer traversal 
- In-place reversal 
- Alternating merge

It avoids additional data structures, maintains O(1) space complexity, and 
ensures that all node connections are correctly rewired to produce the final 
reordered list.


