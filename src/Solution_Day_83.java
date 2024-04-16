public class Solution_Day_83 {
    //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode temp = head;
            ListNode prev = null;
            if(head==null){
                return null;
            }

            while(temp!=null){
                if(temp.val == val){
                    if(temp==head){
                        head = temp.next;
                        temp = head;
                    }else{
                        prev.next = temp.next;
                        temp.next = null;
                        temp = prev.next;
                    }
                }else{
                    prev = temp;
                    temp = temp.next;
                }
            }

            return head;
        }
    }
}
