public class Solution_Day_5 {

      //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
        public ListNode deleteMiddle(ListNode head) {
            int length = 0;
            ListNode temp = head;
            if(temp.next == null){
                return null;
            }
            while(temp!=null){
                temp = temp.next;
                length++;
            }

            int n = (int)(Math.floor(length/2));
            ListNode node = head;
            ListNode prev = head;
            for(int i = 0 ; i < n; i++){
                prev = node;
                node = node.next;
            }

            prev.next = node.next;
            return head;
    }
}
