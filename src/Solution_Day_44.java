public class Solution_Day_44 {

    //s  Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy_node = new ListNode(0);
            dummy_node.next = head;

            ListNode left_prev = dummy_node;
            ListNode current = head;
            for(int i = 0 ; i < left-1; i++){
                left_prev = left_prev.next;
            }

            current = left_prev.next;


            for(int i = 0 ; i < right - left ; i++){
                ListNode tmp = current.next;
                current.next = tmp.next;
                tmp.next = left_prev.next;
                left_prev.next = tmp;
            }


            return dummy_node.next;


        }
    }
}
