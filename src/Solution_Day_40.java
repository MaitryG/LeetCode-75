import java.util.HashSet;
public class Solution_Day_40 {
     // Definition for singly-linked list.
     class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            HashSet<ListNode> hs = new HashSet<>();
            int j = 0;
            ListNode temp = head;
            if(temp==null || head.next==null){
                return null;
            }
            while(true){
                if(hs.contains(temp)){
                    // for(ListNode i : hs){
                    //     j++;
                    //     if(i == temp){
                    //         return temp;
                    //     }
                    // }
                    return temp; //Get index of temp
                }else{
                    hs.add(temp);
                    temp = temp.next;
                }
                if(temp==null){
                    return null;
                }
            }
        }
    }
}
