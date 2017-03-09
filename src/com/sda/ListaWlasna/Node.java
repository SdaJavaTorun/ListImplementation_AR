package com.sda.ListaWlasna;

/* Created by Artur Rózgowski on 3/6/17 */
public class Node {
    private String value;
    private Node next;
    private Node prev;

    public Node(String value, Node next, Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public Node(String value) {
        this.value = value;
    }

    public String getValue() { return value; }

    public void setValue() {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
