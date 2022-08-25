/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_n.ario;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Html {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Html v = new Html();

        String html = "<html>"
                + "<head>"
                + "<title>"
                + "First parse"
                + "</title>"
                + "</head>"
                + "<body>"
                + "<p>Parsed HTML into a doc."
                + "</p>"
                + "</body>"
                + "</html>";
        /* Document doc = Jsoup.parse(html);*/

        Document doc = Jsoup.connect("https://register.sandbox.game/").get();
        Elements elm = doc.getAllElements();
        v.print(doc, "");
        arbolito.recorrerarbol(arbolito.getRaiz());

        
    }
    
    public static Arbol arbolito = new Arbol("html");

    public void print(Element root, String esp) {

        Lista list = new Lista();
        Elements elm = root.children();

        for (Element e : elm) {
            if (list.search(e.nodeName()) == false) {
                list.addNode(e.nodeName());

//               System.out.println(esp + e.nodeName()+ ":"); 
                print(e, esp + "  ");
            }

        }
        if (list.search(root.nodeName()) == false) {
            Lista.Node p = list.tail;
            while (p != null) {
                System.out.println(p.data);
                arbolito.Insertar(arbolito.getRaiz(), p.data, root.nodeName());
                p = p.prev;
            }
//            System.out.println(root.nodeName() + "---------------------");
//            list.display();
        }

    }

}
