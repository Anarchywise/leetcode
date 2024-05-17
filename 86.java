import java.util.HashMap;
import java.util.Map;



class LRUCache {

    Node head = new Node(-1,0);
    Node tail = new Node(-1,0);
    
    Map<Integer,Node> map = new HashMap<>();
    int size =0;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.before = head;
        this.size =0;
    }
    
    public int get(int key) {
        test(head, "getBefore");
        if(map.containsKey(key)){
            Node temp = map.get(key);
            if(temp==tail) tail = temp.before;
            moveToHead(temp);
            test(head, "getAfter");
            return temp.value;
        }else{
            test(head, "getAfter");
            return -1;
        }
    }
    
    public void put(int key, int value) {
        test(head, "putBefore");
        if(map.containsKey(key)){
            //更新temp的val
            Node temp = map.get(key);
            temp.value = value;
            map.put(key, temp);
            //更新temp的位置,放到head的前面
            moveToHead(temp);
        }else if(size>=capacity){
            //map移除最后一个元素tail.before
            map.remove(tail.before.key);
            //链表中移除tail.before
            tail.before.before.next = tail;
            tail.before = tail.before.before;
            Node node = new Node(key,value);
            addToHead(node);
            map.put(key,node);
        }else{
            Node node = new Node(key,value);
            addToHead(node);
            map.put(key,node);
            size++;
        }
        test(head, "putAfter");
    }
    public void moveToHead(Node node){
        if(head.next == node){
            return;
        }
        //断开
        node.before.next = node.next;
        node.next.before = node.before;
        //连head后面一个
        node.next = head.next;
        node.next.before = node;
        //连head
        head.next = node;
        node.before = head;
    }

    public void addToHead(Node node){
        //连head后一个
        node.next = head.next;
        head.next.before = node;
        //连head
        head.next = node;
        node.before =head;
    }

    class Node{
        int key;
        int value;
        Node next;
        Node before;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
        Node(){}
    }

    public void test(Node node,String msg){
        System.out.print(msg);
        Node temp = node;
        while(temp!=null){
            System.out.print(temp.key+" ");
            temp = temp.next;
        }
        System.out.println("lastOne"+tail.before.key);
    }
}

