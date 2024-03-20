public class Solution_Day_55 {
    // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public void insertAtPos(ListNode dummy, ListNode node){
            ListNode current = dummy;
            while(current.next!=null && current.next.val < node.val){
                current = current.next;
            }

            node.next = current.next;
            current.next = node;
        }
        public ListNode insertionSortList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode current = head;
            ListNode dummy = new ListNode(0);
            while(current!=null){
                ListNode next = current.next;
                insertAtPos(dummy, current);
                current = next;
            }
            return dummy.next;
        }
    }
}
