package com.syed.LinkedList;

public class CheckIfPalindrome {


    private void reverse(ListNode node){


        if (node == tail){
            head = tail;
            return;
        }

        reverse(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public ListNode middleNode(ListNode head){
        ListNode s = head;
        ListNode f = head;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    class ListNode{
        int val;
        ListNode next;

        public ListNode(){
        }
        ListNode(int x){
            val = x;
            next = null;
        }
    }
}
