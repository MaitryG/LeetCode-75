public class Solution_Day_45 {
 // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left == null) {
            tail.next = right;
        }
        if (right == null) {
            tail.next = left;
        }

        return dummy.next;
    }

    public ListNode mergeSort(ListNode list1) {
        ListNode head = list1;
        if (head == null || head.next == null) {
            return head;
        }

        //Split list into two halves
        ListNode left = head;
        ListNode right = getMid(head);
        ListNode temp = right.next;
        right.next = null;
        right = temp;

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);

    }
}
}
