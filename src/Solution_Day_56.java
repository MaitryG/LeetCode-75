public class Solution_Day_56 {
    // Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


    class Solution {
        public Node getMergedList(Node head){
            if(head==null){
                return head;
            }

            Node curr = head;
            while(curr!=null){
                while(curr.child!=null){
                    Node temp = curr.next;
                    curr.next = getMergedList(curr.child);
                    curr.child = null;
                    Node temp1 = curr.next;
                    temp1.prev = curr;
                    while(temp1.next!=null){
                        temp1 = temp1.next;
                    }
                    temp1.next = temp;
                    if(temp != null){
                        temp.prev = temp1;
                        curr = temp;

                    }
                }
                curr = curr.next;
            }

            return head;
        }
        public Node flatten(Node head) {
            Node curr = head;
            if(head == null){
                return null;
            }
            while(curr!=null){
                while(curr.child!=null){
                    Node temp = curr.next;
                    curr.next = getMergedList(curr.child);
                    curr.child = null;
                    Node temp1 = curr.next;
                    temp1.prev = curr;
                    while(temp1.next!=null){
                        temp1 = temp1.next;
                    }
                    temp1.next = temp;
                    if(temp != null){
                        temp.prev = temp1;
                        curr = temp;

                    }
                }
                curr = curr.next;

            }

            return head;
        }
    }
}
