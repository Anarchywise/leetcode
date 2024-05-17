import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


class ListNode {
     int val;
     ListNode next;
    ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
} 

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode temp = new ListNode(Integer.MIN_VALUE,head);
        ListNode cur = temp;
        while(cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int n = cur.next.val;
                while(cur.next!=null&&cur.next.val==n){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return temp.next;
    }
}
// 不好的办法
/* 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        int i =1 ;
        Map<Integer,ListNode> map = new HashMap<>();
        Map<Integer,List<ListNode>> map_dummpy  = new HashMap<>();
        ListNode temp = head;
        while(temp!=null){
            map.put(i,temp);
            List<ListNode> list = map_dummpy.getOrDefault(temp.val,new ArrayList<ListNode>());
            list.add(temp);
            map_dummpy.put(temp.val,list);
            temp = temp.next;
            i++;
        }
        List<Integer> die = new ArrayList<>();
        
        for(Entry<Integer, List<ListNode>> entry: map_dummpy.entrySet()){
            if(entry.getValue().size()>1){
            
                //这个node只是对实际对象的引用,将node赋值为null并不能改变对象,
                // for(ListNode node: entry.getValue()){
                //     node = null;
                // }
                die.add(entry.getValue().get(0).val);
            }
        }
        
        ListNode newHead = new ListNode();
        temp = newHead;
        for(Entry<Integer,ListNode> entry : map.entrySet()){
            temp.next =null;
            if(!die.contains(entry.getValue().val)){
                temp.next = entry.getValue();
                temp = entry.getValue();
            }
        }
        
        return newHead.next;

    }
}
*/