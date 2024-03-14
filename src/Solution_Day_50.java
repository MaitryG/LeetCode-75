public class Solution_Day_50 {
     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public void reorderList(ListNode head) {
            if(head.next==null){
                return;
            }

            ListNode temp1 = head;
            ListNode temp2 = head.next;
            ListNode temp3;
            ListNode temp4 = temp2;
            if(temp2.next == null){
                temp3 = temp2;
            }else{
                temp3 = temp2.next;
            }

            while(temp2.next!=null && temp2.next.next!=null){
                //System.out.println(temp2.val);
                temp3 = temp1;
                temp4 = temp2;
                while(temp4.next!=null){
                    temp3 = temp3.next;
                    temp4 = temp4.next;
                }

                temp1.next = temp4;
                temp4.next = temp2;
                temp1 = temp2;
                temp2 = temp2.next;
                temp3.next = null;
            }
            System.out.println(temp1.val);
            System.out.println(temp3.val);
            System.out.println(temp4.val);
            temp1.next = temp3;
            temp3.next = temp2;
            temp2.next = null;
            System.out.println(temp2.val);
            System.out.println(temp3.val);

        }
    }
}
