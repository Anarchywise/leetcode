import java.util.HashMap;
import java.util.Map;

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0){
            return head;
        }
        int i=1;
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode temp = head;
        while(temp!=null){
            map.put(i, temp);
            temp = temp.next;
            i++;
        }
        int size = i-1;
        if(size==1||k%size==0){
            return head;
        }
        map.get(size).next = map.get(1);
        map.get(size-k%size).next =null;

        return map.get(size - k%size +1);

    }  
}