package hot_100.链表;

import hot_100.ListNode;

public class 两两交换链表中的结点 {

    public hot_100.ListNode swapPairs1(hot_100.ListNode head) {

        if (head==null||head.next==null){return head;}

        hot_100.ListNode pre = new hot_100.ListNode();
        pre.next = head;
        hot_100.ListNode left = head;
        hot_100.ListNode right = head.next;
        hot_100.ListNode rNext = right.next;
        hot_100.ListNode res = right;

        while (right!= null){
            pre.next = right;
            right.next = left;
            left.next = rNext;
            pre = left;
            if (rNext==null || rNext.next==null){break;}
            left = rNext;
            right = rNext.next;
            rNext = right.next;
        }
        return res;
    }

    public hot_100.ListNode swapPairs(hot_100.ListNode head) {
        if (head==null||head.next==null){return head;}
        hot_100.ListNode pre=new hot_100.ListNode();
        hot_100.ListNode cur=new hot_100.ListNode();
        hot_100.ListNode curNext=new hot_100.ListNode();
        hot_100.ListNode prepre=new ListNode();
        prepre.next=head;
        pre=head;
        cur=head.next;
        curNext=(cur.next==null?null:cur.next);
        head=head.next;
        while (cur!=null){
            prepre.next=cur;
            cur.next=pre;
            pre.next=curNext;

            prepre=pre;
            pre=curNext;

            cur=(curNext==null?null:curNext.next);
            curNext=(cur==null?null:cur.next);
        }
        return head;
    }

}
