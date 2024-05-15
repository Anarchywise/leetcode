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
//不足k个的保持原样
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        int i=0;
        Map<Integer,ListNode> map = new HashMap<>();
        while (head!=null) {
            map.put(i+1,head);
            head = head.next;
            i++;
        }
        int size =i;
        size = (size/k)*k;
        i=1;
        while(i<=size){
            if(i%k==1){
                map.get(i).next = map.get(i+2*k-1);//get到的是null也没关系
                System.out.println("i:"+i+"  "+"next:"+(i+2*k-1));
            }else{
                map.get(i).next = map.get(i-1);
                System.out.println("i:"+i+"  "+"next:"+(i-1));
            }
            i++;
        }
        if(map.get(size+1)!=null){
            map.get(size-k+1).next = map.get(size+1);
        }
        int offset =0;
        while(map.get(k-offset)==null){
            offset++;
        }
        return map.get(k-offset);
            
    }
}
