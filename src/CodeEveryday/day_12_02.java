package CodeEveryday;

public class day_12_02 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        int count1 = 0;
        int count2 = 0;
        while (cur1 != null) {
            count1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            count2++;
            cur2 = cur2.next;
        }
        cur1 = pHead1;
        cur2 = pHead2;
        if (count1 > count2) {
            for (int i = 0; i < (count1 - count2); i++) {
                cur1 = cur1.next;
            }
        }
        if (count1 < count2) {
            for (int i = 0; i < (count2 - count1); i++) {
                cur2 = cur2.next;
            }
        }
        while(cur1!=null){
            if(cur1.equals(cur2)){
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }
}
