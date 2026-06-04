package hot_100.链表;

public class 链表的中间结点 {

    public ListNode middleNode(ListNode head) {
        ListNode l = head;
        ListNode r = head;

        while (r!= null && r.next != null){
            l = l.next;
            r = r.next.next;
        }
        return l;
    }

}
