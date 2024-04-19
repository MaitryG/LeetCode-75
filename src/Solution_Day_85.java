public class Solution_Day_85 {
    //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode temp = head;
            StringBuilder s = new StringBuilder();

            while(temp!=null){
                s.append(temp.val);
                temp = temp.next;
            }

            String s1 = s.toString();
            String s2 = s.reverse().toString();


            return s1.equals(s2);
        }
    }
}
