public class Solution_Day_47 {

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

    class Solution {
        public int getIndex(Node head, Node node){
            int i = 0;

            while(head!=null){
                if(head==node){
                    return i;
                }else{
                    i++;
                    head = head.next;
                }

            }
            return -1;

        }
        public Node copyRandomList(Node head) {

            if(head == null){
                return null;
            }

            Node newHead = new Node(head.val);
            Node oldHead = head;
            Node prev = null;

            while(oldHead.next!=null){
                Node temp = new Node(oldHead.next.val);
                if(oldHead==head){
                    newHead.next = temp;
                    prev = temp;
                    oldHead = oldHead.next;
                    continue;
                }
                prev.next = temp;
                temp.next = null;
                prev = prev.next;
                oldHead = oldHead.next;
            }

            oldHead = head;
            Node temp = newHead;

            while(oldHead != null){
                int index = getIndex(head, oldHead.random);

                // System.out.println(index);
                if(index == -1){
                    temp.random = null;
                    temp = temp.next;
                    oldHead = oldHead.next;
                }else{
                    int i = 0;
                    Node x = newHead;
                    while(i!=index){
                        x = x.next;
                        i++;
                    }
                    temp.random = x;
                    temp = temp.next;
                    oldHead = oldHead.next;
                }
            }
            return newHead;
        }

    }
}
