package hot_100.链表;

import hot_100.ListNode;

public class 删除链表倒数第n个结点 {

    public hot_100.ListNode removeNthFromEnd(hot_100.ListNode head, int n) {
        if (head==null){return null;}

        hot_100.ListNode cur=new hot_100.ListNode();
        hot_100.ListNode curNext=new hot_100.ListNode();
        hot_100.ListNode pre=new ListNode();
        cur=curNext=head;
        pre.next=head;

        for (int i = 0; i < n-1; i++) {
            if (curNext==null){return null;}
            curNext=curNext.next;
        }
        while(curNext.next!=null){
            pre=pre.next;
            cur=cur.next;
            curNext=curNext.next;
        }
        pre.next=cur.next;
        if (head==cur){return head.next;}
        return head;
    }

}
