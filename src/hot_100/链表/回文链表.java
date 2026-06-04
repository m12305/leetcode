package hot_100.链表;

import hot_100.ListNode;

public class 回文链表 {

    public boolean isPalindrome1(hot_100.ListNode head) {
        if (head==null||head.next==null){return true;}

        hot_100.ListNode cur = head;
        hot_100.ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            cur = cur.next;
            fast = fast.next.next;
        }

        hot_100.ListNode newhead = reverseList(cur.next);
        cur = head;

        while (newhead!=null){
            if (cur.val== newhead.val){
                cur = cur.next;
                newhead = newhead.next;
            }else {
                return false;
            }
        }

        return true;
    }


    public boolean isPalindrome(hot_100.ListNode head) {
        hot_100.ListNode cur=head;
        int size =0;
        while (cur!=null){
            size++;
            cur=cur.next;
        }
        hot_100.ListNode fast=head;
        for (int i = 0; i <size/2; i++) {
            fast=fast.next;
        }
        fast=reverseList(fast);
        for (int i = 0; i <size/2; i++) {
            if (head.val!=fast.val){return false;}
            head=head.next;
            fast=fast.next;
        }
        return true;
    }


    //反转链表
    public hot_100.ListNode reverseList(hot_100.ListNode head) {
        hot_100.ListNode temp=null;
        hot_100.ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=temp;
            temp=cur;
            cur=next;
        }
        return temp;
    }

}
