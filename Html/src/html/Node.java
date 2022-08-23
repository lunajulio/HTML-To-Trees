/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html;
import org.jsoup.nodes.Element;
/**
 *
 * @author user
 */
public class Node {
    Element data;
    Node next;
    
    public Node(Element data) {
        this.next = null;
        this.data = data;
    }
    
    Node head = null;
    Node tail = null;
    
   
   
}
