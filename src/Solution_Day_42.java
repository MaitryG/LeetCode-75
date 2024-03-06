import java.util.HashSet;

public class Solution_Day_42 {
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;

        }
    }
    private Node head;
    public Node removeDuplicates(){
        HashSet<Integer> hs = new HashSet<Integer>();
        Node temp = head;
        Node prev = null;

        while(temp!=null){
            if(hs.contains(temp.value)){
                prev.next = temp.next;
                temp = temp.next;
            }else{
                hs.add(temp.value);
                prev = temp;
                temp = temp.next;
            }
        }

        return head;


    }
}
