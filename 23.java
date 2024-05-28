class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    public ListNode merge(ListNode[] list,int l ,int r){
        if(l>r){
            return null;
        }
        if(l == r){
            return list[l];
        }
        int mid = (l+r)>>1;
        return mergeTwo(merge(list, l, mid), merge(list, mid+1, r));
    }
    //首先合并两个节点   ==>   归并排序  合并一条待合并的数据的哪里到哪里
    public ListNode mergeTwo(ListNode a ,ListNode b){
        ListNode head = new ListNode();
        ListNode cur = head;
        ListNode curA = a;
        ListNode curB = b;
        while(curA!=null&&curB!=null){
            if(curA.val>curB.val){
                //b链比较小
                cur.next =new ListNode(curB.val); 
                curB = curB.next;
            }else{
                cur.next =new ListNode(curA.val); 
                curA = curA.next;
            }
            cur = cur.next;
        }
        while(curA!=null){
            cur.next =new ListNode(curA.val); 
            cur = cur.next;
            curA = curA.next;
        }
        while(curB!=null){
            cur.next =new ListNode(curB.val); 
            cur = cur.next;
            curB = curB.next;
        }
        return head.next;
    }
}