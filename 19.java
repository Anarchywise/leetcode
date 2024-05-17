import java.util.HashMap;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i =1;
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode temp = head;
        while(temp!=null){
            map.put(i,temp);
            temp = temp.next;
            i++;
        }
        int size = i-1;
        if(size==1){
            return null;
        }
        if(size==n){
            return head.next;
        }
        map.get(size-n).next = map.get(size-n+2);  
        return head;
    }
}