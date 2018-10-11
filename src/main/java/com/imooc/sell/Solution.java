package com.imooc.sell;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
}


public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode dummyHead = head;
        for (int i = 1; i < 5; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode newHead = reverseKGroup(dummyHead.next, 2);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;


        ListNode newhead = new ListNode(0);
        ListNode returnHead = newhead;
        while (head != null) {
            List<Integer> data = new ArrayList<>();

            for (int i = 0; i < k & head != null; i++) {
                data.add(head.val);
                head = head.next;
            }
            if (data.size() == k) {
                for (int i = data.size(); i > 0; i--) {
                    newhead.next = new ListNode(data.get(i - 1));
                    newhead = newhead.next;
                }
            } else {
                for (Integer aData : data) {
                    newhead.next = new ListNode(aData);
                    newhead = newhead.next;
                }
            }
        }
        return returnHead.next;
    }
}
