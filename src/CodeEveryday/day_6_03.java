package CodeEveryday;

import hot_100.ListNode;

public class day_6_03 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here

        //反转链表
        ListNode newhead1 = reverse(head1);
        ListNode newhead2 = reverse(head2);
        //相加
        ListNode head = addTwoNumbers(newhead1,newhead2);
        //反转
        return reverse(head);
    }

    public static ListNode reverse(ListNode node){
        if (node.next==null){return node;}

        ListNode pre = new ListNode();
        ListNode cur = node;
        ListNode curNext = cur.next;

        while (curNext!=null){
            cur.next = pre;
            pre = cur;
            cur = curNext;
            curNext = cur.next;
        }
        cur.next = pre;
        return cur;
    }

    public static ListNode addList(ListNode head1,ListNode head2){
        return null;
    }

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
