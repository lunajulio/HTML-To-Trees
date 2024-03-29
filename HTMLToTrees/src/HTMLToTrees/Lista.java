/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLToTrees;

/**
 *
 * @author user
 */
public class Lista {

    class Node {

        String data;
        Node next;
        Node prev;

        public Node(String d) {
            this.data = d;
            this.next = null;
            this.prev = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(String data) {
        Node P = new Node(data);
        if (head == null) {
            head = P;
            tail = P;
        } else {
            tail.next = P;
            P.prev = tail;
            tail = P;
        }
    }

    public boolean search(String data) {
        Node P = head;
        while (P != null) {
            if (P.data.equals(data)) {
                return true;
            }
            P = P.next;
        }
        return false;
    }
}
