package org.lldpractice.lrucache.customlinkedlist;

import org.lldpractice.lrucache.cache.Node;

public class CustomLinkedList {
    private Node head;
    private Node tail;

    public CustomLinkedList() {
        this.tail = this.head = null;
    }

    public void addLast(Node node) {
        if (tail == null)
            head = tail = node;
        else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }

        //System.out.println("head : " + head.getKey() + " tail : " + tail.getKey());
    }

    public Node getFirst() {
        return head;
    }

    public Node removeFirst() {
        if(head == null)
            return null;

        Node removed = head;

        if(head == tail)
            head = tail = null;

        else if(head.getNext() != null)
        {
            head.getNext().setPrev(null);
            head = head.getNext();
        }

        removed.setPrev(null);
        removed.setNext(null);

        return removed;
    }

    public void moveToTail(Node node) {
        if (node == null || node == tail)
            return;
        else if (node == head) {
            //If head, move head to next node
            head = head.getNext();
            if(head != null)
                head.setPrev(null);
        }
        else {
            //If middle element update the prev and next reference
            Node prev = node.getPrev();
            Node next = node.getNext();
            prev.setNext(next);
            next.setPrev(prev);
        }

        //add to tail
        node.setNext(null);
        tail.setNext(node);
        node.setPrev(tail);
        tail = node;
    }
}
