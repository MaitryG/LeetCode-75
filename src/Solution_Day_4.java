public class Solution_Day_4 {

      //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

        public ListNode oddEvenList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }

            ListNode ptr1 = head;
            ListNode ptr2 = head.next;
            ListNode ptr2_head = ptr2;
            ListNode temp = head;
            while(ptr1!=null && ptr1.next!=null && ptr2!=null && ptr2.next!=null){
                ptr1.next = ptr2.next;
                ptr1 = ptr1.next;
                ptr2.next = ptr1.next;
                ptr2 = ptr2.next;

            }
            ptr1.next = ptr2_head;

            return head;
        }
}
