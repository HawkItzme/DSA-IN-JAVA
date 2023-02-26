package com.syed.LinkedList;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class LL {

    private Node head;
    private Node tail;

    private int size;
    public LL(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null){
            tail = head;
        }

        size+=1;
    }

    public void insertLast(int val){
        if (tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index){
        if (index == 0){
            insertFirst(val);
            return;
        }
        if (index == size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i< index; i++){
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }


    //Insert using Recursion
    public void insertRec(int val, int index){
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node){
        if (index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index--, node.next);
        return node;
    }

    public int deleteLast(){
        if (size <= 1){
            deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail= secondLast;
        tail.next = null;
        return val;
    }

    public int delete(int index){
        if (index == 0){
            return deleteFirst();
        }
        if (index == size - 1){
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        return val;
    }

    public Node find(int value){
        Node node = head;
        while (node != null){
            if (node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public void duplicatesRemove(){
        Node node = head;

        while (node.next != null){
            if (node.value == node.next.value){
                node.next = node.next.next;
                size--;
            }else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    //recursion reverse
    private void reverse(Node node){
        if (node == tail){
            head = tail;
            return;
        }

        reverse(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;
    }

    //inplace reversal of LL
    public void reverse(){
        if (size < 2){
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if (next != null){
                next = next.next;
            }
        }
        head = prev;
    }

    //Reversal of LL in the range
    public Node reverseBetween(Node head, int left, int right){
        if (left == right){
            return head;
        }

        //skipping the first left - 1 nodes
        Node current = head;
        Node prev = null;
        for (int i = 0; current != null && i < left - 1; i++){
            prev = current;
            current = current.next;
        }

        Node last = prev;
        Node newEnd = current;

        //Reversing the required range of LL
        Node next = current.next;

        for (int i = 0; current != null && i < right - left + 1; i++){
            current.next = prev;
            prev = current;
            current = next;
            if (next != null){
                next = next.next;
            }
        }

        if (last != null){
            last.next = prev;
        }else {
            head = prev;
        }
        newEnd.next = current;
        return head;
    }

    //merge
    public static LL merge(LL first, LL second){
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while (f != null && s != null){
            if (f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            }else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while (f != null){
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }

    public void bubbleSort(){
        bubblesort(size -1 , 0);
    }

    private void bubblesort(int row, int col){
        if (row == 0){
            return;
        }

        if (col < row){
            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value){
                //swap
                if (first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }else if (second == tail){
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                }else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubblesort(row, col + 1);
        }else {
            bubblesort(row - 1, 0);
        }
    }

    //Reverse List returned
    public Node reverseList(Node head) {
        if (head == null) {
            return head;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public Node middleNode(Node head){
        Node s = head;
        Node f = head;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    //Palindrome
    public boolean isPlaindrome(Node head){
        Node mid = middleNode(head);
        Node headSecond = reverseList(mid);
        Node reverseHead = headSecond;

        //compare both the values
        while(head != null && headSecond != null){
            if (head.value != headSecond.value){
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(reverseHead);

        return head == null || headSecond == null;
    }

    public void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node mid = middleNode(head);

        Node hs = reverseList(mid);
        Node hf = head;

        // rearrange
        while (hf != null && hs != null) {
            Node temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // next of tail to null
        if (hf != null) {
            hf.next = null;
        }
    }
}
