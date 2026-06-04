package hot_100.链表;

import hot_100.ListNode;

public class 合并两个有序链表 {

    public hot_100.ListNode mergeTwoLists(hot_100.ListNode list1, hot_100.ListNode list2) {
        if(list1==null&&list2==null){
            return null;
        }
        if(list1==null)return list2;
        if(list2==null)return list1;

        hot_100.ListNode n1 = list1;
        hot_100.ListNode n2 = list2;
        hot_100.ListNode head = list1.val<list2.val?list1:list2;
        hot_100.ListNode pre  = new ListNode();

        while(n1!=null && n2!=null){

            if(n1.val<n2.val){
                pre.next = n1;
                pre = pre.next;
                n1 = n1.next;
            }else{
                pre.next = n2;
                pre = pre.next;
                n2 = n2.next;
            }
        }
        if(n1!=null){
            pre.next = n1;
        }
        if(n2!= null){
            pre.next = n2;
        }
        return head;
    }
}
