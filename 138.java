
// Definition for a Node.

import java.util.HashMap;
import java.util.Map;

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
    public Node copyRandomList(Node head) {
        //在遍历链表时,random指向的Node可能还没有被复制
        //先遍历一遍,创建Node数量的对应new Node,并存入Map
        //再遍历一遍,根据head的next,random从Map中找到newHead的next和random填入
        Map<Node,Node> map = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        Node newHead = map.get(head);
        temp =head;
        Node temp2 =newHead;
        while(temp2!=null){
            temp2.random = map.get(temp.random);
            temp2.next = map.get(temp.next);
            temp2 =temp2.next;
            temp = temp.next;
        }
        return newHead;
    }
}