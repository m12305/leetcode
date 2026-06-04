package hot_100.链表;

import hot_100.ListNode;

public class 环形链表 {


    //双指针
    public boolean hasCycle(hot_100.ListNode head) {
        if (head==null||head.next==null){return false;}
        hot_100.ListNode left = head;
        ListNode right = head;
        while (right!=null&&right.next!=null){
            left = left.next;
            right = right.next.next;
            if (left==right){
                return true;
            }
        }
        return false;
    }
}
