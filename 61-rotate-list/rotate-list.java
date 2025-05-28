class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find the length and the tail of the list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Make the list circular
        tail.next = head;

        // Step 3: Find the new head after rotating
        k = k % length; // handle k > length
        int stepsToNewHead = length - k;
        ListNode newTail = tail;

        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // Step 4: Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
