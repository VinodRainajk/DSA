package src.LinkedList;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    static class Node{
        int value;
        int key;
        Node next;
        Node prev;
    }

    int cache_size;
    Node head = null;
    Node tail = head;

    Map<Integer,Integer> keyPair = new HashMap<>();
    Map<Integer, Node> location = new HashMap<>();

    public LRUCache(int capacity) {
        this.cache_size = capacity;
    }

    public int get(int key) {
        System.out.println("get key"+key);
        if(keyPair.containsKey(key)){
            Node val = location.get(key);
            increment(val,'E');
            return keyPair.get(key);
        }else{
            return -1;
        }

    }

    public void increment(Node value, char type){

        System.out.println("increment type "+type);
        if(head == null){
            head = value;
            tail = head;
            return;
        }

        if(head==value){
            return;
        }
        Node newTail = tail;

        if(type == 'E'){

            if(tail == value && value.prev != null){
                newTail = value.prev;
            }
            System.out.println("value "+value.value);
            System.out.println("head "+head.value);
            value.prev.next = value.next;

            if(value.next ==null){
                value.prev =  null;
            }else{
                value.next.prev = value.prev;
            }

            value.next = null;
            value.prev = null;
            tail = newTail;
        }


        Node temp = head;
        value.next = temp;
        temp.prev = value;
        head = value;

    }

    public void remove() {
        if (tail == null) return;

        int key = tail.key;
        keyPair.remove(key);
        location.remove(key);

        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }
    }


    public void put(int key, int value) {
        // code to check the size and remove the element
        if (keyPair.containsKey(key)) {
            keyPair.put(key, value);
            Node nod =   location.get(key);
            nod.value = value;
            location.put(key, nod);

            increment(nod, 'E'); // move to head
            return;
        }


        if(keyPair.size()>= cache_size){
            remove();
        }

        // code to add the element
        keyPair.put(key,value);
        Node node= new Node();
        node.key =  key;
        node.value = value;
        node.next = null;
        node.prev = null;
        location.put(key,node);
        increment(node,'N');
    }

    public static void main(String[] args) {
        // Initialize LRUCache with capacity 3
        LRUCache obj = new LRUCache(3);

        // Perform operations
        obj.put(1, 1);               // cache: [1]
        obj.put(2, 2);               // cache: [2, 1]
        obj.put(3, 3);               // cache: [3, 2, 1]
        obj.put(4, 4);               // evicts key 1, cache: [4, 3, 2]
        System.out.println(obj.get(4)); // returns 4, cache: [4, 3, 2]
        System.out.println(obj.get(3)); // returns 3, cache: [3, 4, 2]
        System.out.println(obj.get(2)); // returns 2, cache: [2, 3, 4]
        System.out.println(obj.get(1)); // returns -1 (not found)
        obj.put(5, 5);               // evicts key 4, cache: [5, 2, 3]
        System.out.println(obj.get(1)); // returns -1 (not found)
        System.out.println(obj.get(2)); // returns 2, cache: [2, 5, 3]
        System.out.println(obj.get(3)); // returns 3, cache: [3, 2, 5]
        System.out.println(obj.get(4)); // returns -1 (not found)
        System.out.println(obj.get(5)); // returns 5, cache: [5, 3, 2]
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */