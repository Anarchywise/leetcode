import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Node;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode cur =head;
        for(int i=1;i<=right;i++){
            map.put(i,cur);
            cur = cur.next;
        }
        if(cur!=null){
            map.put(right+1,cur);
        }else{
            map.put(right+1,null);
        }
        int count =1;
        while(count<=right){
            if(left-1<=count){
                if(left-1==count){
                    map.get(count).next = map.get(right);
                }else if(count == left){
                    map.get(count).next = map.get(right+1);
                }else{
                    map.get(count).next = map.get(count-1);
                }
            }
            count++;
        }
        if(left==1){
            return map.get(right);
        }
        return head;
    }
}