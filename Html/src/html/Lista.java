/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package html;

/**
 *
 * @author user
 */
public class Lista {

    class Node{
        String data;
        Node next;
        public Node(String d){
            this.data = d;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void addNode(String data){
        Node P = new Node(data);

        if(head == null){
            head = P;
            tail = P;
        }else{
            tail.next = P;
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
    
     public void display(){
        // First lets create a node current that will point to the node head
        Node current = head;

        if(current == null){
            System.out.println("The list is empty");
            return;
        }
        System.out.println("The nodes of the singly linked list are: ");
        while(current != null){
            System.out.print(current.data +" -> ");
            current = current.next;
        }
        if(current == null)
            System.out.print("null\n");
    }
    


}
