package hot_100.链表;

import hot_100.ListNode;

public class 排序链表 {

    public hot_100.ListNode sortList(hot_100.ListNode head) {
        if (head==null || head.next == null){return head;}
        hot_100.ListNode r = middleNode(head);
        return mergeTwoLists(sortList(head),sortList(r));
    }

    // 21. 合并两个有序链表（双指针）
    private hot_100.ListNode mergeTwoLists(hot_100.ListNode list1, hot_100.ListNode list2) {
        hot_100.ListNode dummy = new hot_100.ListNode(); // 用哨兵节点简化代码逻辑
        hot_100.ListNode cur = dummy; // cur 指向新链表的末尾
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1; // 把 list1 加到新链表中
                list1 = list1.next;
            } else { // 注：相等的情况加哪个节点都是可以的
                cur.next = list2; // 把 list2 加到新链表中
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2; // 拼接剩余链表
        return dummy.next;
    }

    // 876. 链表的中间结点（快慢指针）
    private hot_100.ListNode middleNode(hot_100.ListNode head) {
        hot_100.ListNode pre = head;
        hot_100.ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow; // 记录 slow 的前一个节点
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; // 断开 slow 的前一个节点和 slow 的连接
        return slow;
    }


}
