public class Solution_Day_84 {

     // Definition for singly-linked list.
     class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode middleNode(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }

            ListNode slow = head;
            ListNode fast = head.next;
            int c = 0;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            if(fast==null){
                return slow;
            }else{
                return slow.next;
            }
        }
    }
}
