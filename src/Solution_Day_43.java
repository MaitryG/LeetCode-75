public class Solution_Day_43 {

    //  Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode doubleIt(ListNode head) {

            if(head.next==null){
                int value = head.val * 2;
                if(value <= 9 && value >= 0){
                    head.val = value;
                    return head;
                }else{
                    ListNode temp = new ListNode();
                    head.val = (value - (value%10))/10;
                    temp.val = value%10 ;
                    head.next = temp;
                    temp.next = null;
                    return head;
                }
            }

            ListNode temp1 = head;
            int x = 1;
            int c = 1;
            while(temp1.next!=null){
                temp1 = temp1.next;
                x = x * 10;
                c++;
            }
            c=c-1;
            x = x/10;
            temp1 = head;
            int k = 0;
            int i = c;
            while(temp1!=null){
                k = temp1.val * (int)Math.pow(10,i) + k;
                i--;
                temp1 = temp1.next;
            }

            k = k*2;
            int x2 = k;
            c = 1;
            i=1;
            while(k!=0){
                k = k/10;
                c = c*10;
                i++;
            }
            c=c/10;
            int arr[] = new int[i];
            int j = 0;
            while(x2!=0){
                arr[j] = x2%10;
                x2 = x2/10;
                j++;
            }

            ListNode new_head = new ListNode(arr[arr.length-2], null);
            ListNode temp3 = new_head;

            for(int m = arr.length-3; m >= 0; m--){
                ListNode new_node = new ListNode(arr[m], null);
                temp3.next = new_node;
                temp3 = new_node;
            }

            return new_head;



        }
    }
}
