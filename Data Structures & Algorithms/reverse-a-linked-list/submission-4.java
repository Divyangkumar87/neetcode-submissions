class Solution {
    public ListNode reverseList(ListNode head) {
        //base condition
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
