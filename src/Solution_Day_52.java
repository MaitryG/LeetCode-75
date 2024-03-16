public class Solution_Day_52 {

     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1.next==null && l2.next==null){
                int sum = l1.val + l2.val;

                if(sum > 9){
                    int carry = 1;
                    l2.val = sum%10;
                    ListNode temp = new ListNode(carry, l2);
                    return temp;
                }else{
                    l2.val = sum;
                    return l2;
                }
            }


            ListNode temp = l1;
            ListNode prev1 = null;
            ListNode temp2;

            while(temp!=null){
                temp2 = temp.next;
                temp.next = prev1;
                prev1 = temp;
                temp = temp2;
            }
            //prev1 is my head;

            temp = l2;
            ListNode prev2 = null;
            temp2 = l2;

            while(temp!=null){
                temp2 = temp.next;
                temp.next = prev2;
                prev2 = temp;
                temp = temp2;
            }
            //prev2 is my head;

            ListNode temp1 = prev1;
            temp2 = prev2;
            int carry =0;
            ListNode newNode = null;
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;


            while(temp1!=null && temp2!=null){
                int sum = temp2.val + temp1.val + carry;

                if(sum > 9){
                    carry = 1;
                    newNode = new ListNode((sum%10), null);
                    tail.next = newNode;
                    tail = tail.next;
                }else{
                    carry = 0;
                    newNode = new ListNode((sum), null);
                    tail.next = newNode;
                    tail = tail.next;
                }
                temp2 = temp2.next;
                temp1 = temp1.next;
            }

            if(temp1==null && temp2==null){
                if(carry == 1){
                    newNode = new ListNode(carry, null);
                    tail.next = newNode;
                    tail = tail.next;
                }
            }

            if(temp1==null && temp2 != null){
                while(temp2!=null){
                    int sum = temp2.val + carry;
                    if(sum>9){
                        carry = 1;
                        newNode = new ListNode((sum%10), null);
                        tail.next = newNode;
                        tail = tail.next;
                    }else{
                        carry = 0;
                        newNode = new ListNode((sum), null);
                        tail.next = newNode;
                        tail = tail.next;
                    }
                    temp2 = temp2.next;
                }

                if(carry==1){
                    newNode = new ListNode((carry), null);
                    tail.next = newNode;
                    tail = tail.next;
                }
            }

            if(temp2==null && temp1 != null){
                while(temp1!=null){
                    int sum = temp1.val + carry;
                    if(sum>9){
                        carry = 1;
                        newNode = new ListNode((sum%10), null);
                        tail.next = newNode;
                        tail = tail.next;
                    }else{
                        carry = 0;
                        newNode = new ListNode((sum), null);
                        tail.next = newNode;
                        tail = tail.next;
                    }
                    temp1 = temp1.next;
                }

                if(carry==1){
                    newNode = new ListNode((carry), null);
                    tail.next = newNode;
                    tail = tail.next;
                }
            }


            ListNode temp3 = dummy.next;
            ListNode prev3 = null;
            temp2 = dummy.next;

            while(temp3!=null){
                temp2 = temp3.next;
                temp3.next = prev3;
                prev3 = temp3;
                temp3 = temp2;
            }

            return prev3;

        }
    }
}
