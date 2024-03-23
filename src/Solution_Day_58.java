public class Solution_Day_58 {

    //  Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public int[] nextLargerNodes(ListNode head) {
            int answer[];

            ListNode temp = head;
            if(head==null){
                return null;
            }
            int len = 0;
            while(temp!=null){
                temp = temp.next;
                len++;
            }

            answer = new int[len];

            ListNode temp1 = head;
            ListNode temp2 = head.next;
            int max = Integer.MIN_VALUE;
            int i=0;
            while(temp1.next!=null){
                temp2 = temp1.next;
                max = temp1.val;
                while(temp2!=null){
                    // max = Math.max(max, temp2.val);
                    if(temp2.val > max){
                        max = temp2.val;
                        break;
                    }
                    temp2 = temp2.next;
                }
                if(max==temp1.val){
                    max = 0;
                }
                answer[i] = max;
                temp1 = temp1.next;
                i++;
            }

            return answer;
        }
    }
}
