public class Solution_Day_66 {

    //  Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            int temp_count = 0;
            ListNode temp = list1;
            while(temp_count!=a-1){
                temp = temp.next;
                temp_count++;
            }

            ListNode temp1 = temp;
            while(temp_count!=b+1){
                temp1 = temp1.next;
                temp_count++;
            }


            temp.next = list2;
            ListNode temp3 = list2;
            while(temp3.next!=null){
                temp3 = temp3.next;
            }

            temp3.next = temp1;
            return list1;
        }
    }
}
