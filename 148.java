import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public ListNode sortList(ListNode head) {
        ListNode new_head = new ListNode(Integer.MIN_VALUE+1);
        List<Integer> res = new ArrayList<>();
        ListNode cur = head;
        while(cur!=null){
            res.add(cur.val);
            cur = cur.next;
        }
        res.sort((a,b)->{
            return a-b;
        });
        cur = new_head;
        for(int i:res){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return new_head.next;
    }
}