package hot_100.链表;

import hot_100.ListNode;

public class 两数相加 {


    public hot_100.ListNode addTwoNumbers(hot_100.ListNode l1, hot_100.ListNode l2) {
        hot_100.ListNode res = new ListNode();
        hot_100.ListNode cur = res;
        hot_100.ListNode n1 = l1;
        hot_100.ListNode n2 = l2;
        int plus = 0;

        while (l1!= null && l2!= null){
            int temp = (l1.val+ l2.val + plus)%10;
            cur.next= new ListNode(temp);
            cur = cur.next;
            plus = (l1.val+ l2.val +plus)/10;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1!=null){
            while (l1!=null){
                int temp = (l1.val+ plus)%10;
                cur.next= new hot_100.ListNode(temp);
                cur = cur.next;
                plus = (l1.val +plus)/10;
                l1 = l1.next;
            }
        }
        if (l2!=null){
            while (l2!=null){
                int temp = (l2.val+ plus)%10;
                cur.next= new hot_100.ListNode(temp);
                cur = cur.next;
                plus = (l2.val +plus)/10;
                l2 = l2.next;
            }
        }
        if (plus!=0){
            cur.next= new ListNode(plus);
        }
        return res.next;
    }
}
