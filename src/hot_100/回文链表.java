package hot_100;

public class 回文链表 {

    public boolean isPalindrome1(ListNode head) {
        if (head==null||head.next==null){return true;}

        ListNode cur = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            cur = cur.next;
            fast = fast.next.next;
        }

        ListNode newhead = reverseList(cur.next);
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


    public boolean isPalindrome(ListNode head) {
        ListNode cur=head;
        int size =0;
        while (cur!=null){
            size++;
            cur=cur.next;
        }
        ListNode fast=head;
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
    public ListNode reverseList(ListNode head) {
        ListNode temp=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=temp;
            temp=cur;
            cur=next;
        }
        return temp;
    }

}
