public class Solution_Day_25 {

//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public int pairSum(ListNode head) {
            int first_ptr = 0;
            int length = 0;

            ListNode temp = head;
            while(temp!=null){
                length++;
                temp = temp.next;
            }

            ListNode temp2 = head;
            ListNode temp1 = head;
            int j = 0;
            while(j!=length/2){
                temp1 = temp1.next;
                j++;
            }
            ListNode reversedListHead = reverseList(temp1);
            int sum = 0;
            int max = 0;
            int i = 0;
            while(i!=length/2){
                sum = temp2.val + reversedListHead.val;
                System.out.println(sum);
                temp2 = temp2.next;
                reversedListHead = reversedListHead.next;
                max = Math.max(max, sum);
                i++;
            }

            return max;
        }

        public ListNode reverseList(ListNode head){
            ListNode temp = head;
            ListNode prev = null;
            ListNode temp1 = null;
            while(temp != null){
                temp1 = temp.next;
                temp.next = prev;
                prev = temp;
                temp = temp1;
            }
            return prev;

        }
    }
}
