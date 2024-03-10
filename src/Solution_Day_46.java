public class Solution_Day_46 {

     // Definition for singly-linked list.
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head==null || head.next == null){
                return head;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode curr = dummy;
            while(curr.next!=null && curr.next.next!=null){
                ListNode node1 = curr.next;
                ListNode node2 = curr.next.next;

                node1.next = node2.next;
                node2.next = node1;
                curr.next = node2;
                curr = node1;

            }
            return dummy.next;
        }
    }
}
