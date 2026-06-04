package hot_100.链表;

import hot_100.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class 环形链表2 {

    //用哈希set，先把环形链表的节点都存到set里，再从头遍历链表，如果set包含，那这个节点就是环形的开始
    public hot_100.ListNode detectCycle1(hot_100.ListNode head) {
        if (head==null||head.next==null){return null;}
        hot_100.ListNode fast=new hot_100.ListNode();
        hot_100.ListNode slow=new hot_100.ListNode();
        hot_100.ListNode cur=head;
        HashSet<hot_100.ListNode> hashSet = new HashSet<>();

        fast=slow=head;
        while(slow!=null&&fast!=null){
            if (fast.next==null){return null;}
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){break;}
        }
        if (fast==null||fast.next==null){return null;}
        hashSet.add(fast);
        fast = fast.next;
        while (slow!=fast){
            hashSet.add(fast);
            fast = fast.next;
        }

        while (cur!=null){
            if (hashSet.contains(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //使用哈希map
    public hot_100.ListNode detectCycle(hot_100.ListNode head) {
        hot_100.ListNode pre = null;
        hot_100.ListNode cur = head;
        HashMap<hot_100.ListNode, ListNode> map = new HashMap<>();
        while(cur!=null){
            if (!map.containsKey(cur)){
                map.put(cur,pre);
            }else {
                if (map.get(cur)!=pre){
                    return cur;
                }
            }
            pre = cur;
            cur = cur.next;
        }
        return null;
    }
}
