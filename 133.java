/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.HashMap;

class Solution {
    Map<Node,Node> map = new HashMap<>();


    /*
     * 如果该点已经遍历过了,那么不遍历该点的neighbors,但是要返回该点的克隆
     * cloneGraph 将克隆该点以及其neighbors,neighbor的neighbor....
     * 
     * 用map将克隆过的点存储起来,
     * 
     * 深度优先遍历
     * 
     * node的neighbor会继续克隆neighbor
     * 
     * 要避免重复遍历
     */
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node temp = new Node(node.val);
        map.put(node,temp);
        for(int i=0;i<node.neighbors.size();i++){
            temp.neighbors.add(cloneGraph(node.neighbors.get(i)));
        }
        return temp;
    }
}