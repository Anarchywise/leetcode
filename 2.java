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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        int jinwei = 0;
        int sum =0;
        while(l1!=null||l2!=null||jinwei!=0){
            if(l1==null&&l2==null){
                sum = 1;
            }else if(l1==null&&l2!=null){
                sum = l2.val+jinwei;
            }else if(l1!=null&&l2==null){
                sum = l1.val+jinwei;
            }else{
                sum = l1.val + l2.val+jinwei;
            }
            jinwei =0;
            if(sum>=10){
                sum = sum%10;
                jinwei =1;
            }
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }

            current.next = new ListNode(sum);
            current = current.next;
        }
        return head.next;
    }
}