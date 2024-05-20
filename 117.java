/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.LinkedList;
import java.util.Queue;

//可以使用一个队列来存储,每次看队列有n个对象,根据n来遍历
class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> one = new LinkedList<>();
        Queue<Node> two = new LinkedList<>();
        one.add(root);
        boolean is_one = true;

        while ((!one.isEmpty())||(!two.isEmpty())) {
            if(is_one){
                Node temp = one.poll();
                if(temp.left!=null) two.add(temp.left);
                if(temp.right!=null) two.add(temp.right);
                if(!one.isEmpty()){
                    temp.next = one.peek();
                }else{
                    is_one = false;
                }
            }else{
                Node temp = two.poll();
                if(temp.left!=null) one.add(temp.left);
                if(temp.right!=null) one.add(temp.right);
                if(!two.isEmpty()){
                    temp.next = two.peek();
                }else{
                    is_one = true;
                }
            }
            
        }
        return root;
    }
}