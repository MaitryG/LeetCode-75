public class Solution_Day_41 {

     // Definition for singly-linked list.
      public class ListNode {
      int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public boolean seenSoFar(int i, int val, ListNode head){
            int c=0;
            ListNode temp = head;
            while(c!=i){
                if(temp.val == val){
                    return true;
                }
                temp = temp.next;
                c++;
            }

            return false;
        }
        public ListNode deleteDuplicates(ListNode head) {
            // ListNode temp = head;
            // ListNode prev=null;
            // int i=0;
            // while(temp!=null){
            //     if(seenSoFar(i, temp.val, head)){
            //         prev.next = temp.next;
            //         temp.next = null;
            //         prev = temp;
            //         temp = prev.next;
            //         System.out.println(prev.val);
            //         // System.out.println(temp.val);
            //     }else{
            //         prev = temp;
            //         temp = temp.next;
            //         System.out.println(prev.val);
            //         System.out.println(temp.val);

            //     }
            //     i++;
            // }

            ListNode temp=head;
            if(head == null){
                return null;
            }
            while(temp.next!=null){
                if(temp.val == temp.next.val){
                    temp.next = temp.next.next;
                }else{
                    temp = temp.next;
                }
            }

            return head;
        }
    }
}
