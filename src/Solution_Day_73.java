public class Solution_Day_73 {
    class MyHashMap {
        class Node{
            int value;
            Node next;
            int key;
            public Node(int key, int value, Node next){
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }

        Node[] arr = new Node[19997];


        public MyHashMap() {
        }
        static final int size = 19997;
        static final int mult = 12582917;
        public int hash(int key){
            return (int)((long)key * mult % size);
        }

        public void put(int key, int value) {
            remove(key);
            int h = hash(key);
            Node temp = new Node(key, value, arr[h]);
            arr[h] = temp;
        }

        public int get(int key) {
            int indx = hash(key);
            Node temp = arr[indx];

            while(temp!=null){
                if(temp.key == key){
                    return temp.value;
                }
                temp = temp.next;
            }

            return -1;
        }

        public void remove(int key) {
            int indx = hash(key);
            Node temp = arr[indx];
            if(temp == null) return;
            if(temp.key == key){
                arr[indx] = temp.next;
            }
            else{
                while(temp.next!=null){
                    if(temp.next.key == key){
                        temp.next = temp.next.next;
                        return;
                    }
                    temp = temp.next;
                }
            }
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
