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
    public ListNode removeNthFromEnd(ListNode head, int n) {
     ListNode temp=head;

       // if(head.next==null){
         //   return null;
        //}

        int count=0;
        while(temp!=null){
            temp=temp.next;
            count+=1;
        }

        temp=head;
        int a=count-n;
        if(count==n) return head.next;

        for(int i=1;i<a;i++){
            temp=temp.next;
            }
        temp.next=temp.next.next;
        return head;
    }
}
    