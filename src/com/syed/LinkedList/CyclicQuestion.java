package com.syed.LinkedList;

import java.util.List;

public class CyclicQuestion {
    public boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    //find length of the cycle
    public int lengthCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                //length calc
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                }while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    public  ListNode detectCycle(ListNode head){
        int length = 0;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0){
            return null;
        }
        // find the start node
        ListNode f = head;
        ListNode s = head;

        while (length > 0){
            s = s.next;
            length--;
        }

        // keep moving both forwards and they will meet at the start of cycle

        while (f != s){
            f = f.next;
            s = s.next;
        }
        return s;
    }
    public ListNode middleNode(ListNode head){
        ListNode s = head;
        ListNode f = head;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next;
        }
        return s;
    }
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
