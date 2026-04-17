package hot_100;

public class 环形链表 {


    //双指针
    public boolean hasCycle(ListNode head) {
        if (head==null||head.next==null){return false;}
        ListNode left = head;
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
