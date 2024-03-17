public class Solution_Day_53 {

     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head==null){
                return null;
            }
            if(head.next == null){
                return head;
            }
            if(k==0){
                return head;
            }
            // ListNode prev = head;
            // ListNode temp = head.next;
            //  while(temp.next!=null){
            //         temp = temp.next;
            //         prev = prev.next;
            // }
            // ListNode tail = temp;

            // for(int i = 1 ; i <= k; i++){
            //     tail.next = head;
            //     prev.next = null;
            //     head = tail;
            //     tail = prev;
            // }

            // return head;


            ListNode temp = head;
            int l = 1;
            while(temp.next!=null){
                temp = temp.next;
                l++;
            }

            temp.next = head;
            // temp = head;
            k = k%l;
            int i = l-k;
            while(i>0){
                temp = temp.next;
                i--;
            }
            head = temp.next;
            temp.next = null;

            return head;


        }
    }
}
