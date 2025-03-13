/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    // Define a custom Pair class to store <Integer, ListNode>
    // `val` holds the integer value of a node, and `node` holds the corresponding ListNode
    static class Pair {
        int val;
        ListNode node;

        Pair(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // Create a PriorityQueue (Min-Heap) to store Pair objects
        // The queue sorts elements by `val` (the integer value in each Pair)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

         // Add the head node of each non-null linked list to the priority queue
        for (ListNode list : lists) {
            if (list != null) { // Ensure no null lists are added
                pq.add(new Pair(list.val, list));
            }
        }

        // Create a dummy node to act as the head of the merged linked list
        ListNode dNode = new ListNode(0);
        ListNode temp = dNode; // A pointer to build the merged list

        while (!pq.isEmpty()) {
            // Get the Pair with the smallest value
            Pair p = pq.remove();
            temp.next = p.node; // Add the node to the result list
            temp = temp.next;   // Move to the next node

             // If the current node has a next node, add it to the priority queue
            // This ensures that nodes are added to the queue in sorted order
            if (p.node.next != null) {
                pq.add(new Pair(p.node.next.val, p.node.next));
            }
        }

        return dNode.next; // Return the merged list starting after the dummy node
    }
}