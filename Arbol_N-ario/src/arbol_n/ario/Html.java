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
    
    public static String link;

    /**
     * @param args the command line arguments
     */
    public static void main() throws IOException {
        Html v = new Html();
        /* Document doc = Jsoup.parse(html);*/
        Document doc = Jsoup.connect(link).get();
        v.print(doc);
    }

    public static Arbol arbolito = new Arbol("");
    public int c = 0, k = 0;

    public void print(Element root) {
        Lista list = new Lista();
        Elements elm = root.children();
        String padre = root.nodeName() + k;
        if (c == 0) {
            arbolito.setRaiz(padre);
        }
        c++;
        for (Element e : elm) {
            if (list.search(e.nodeName()) == false) {
                list.addNode(e.nodeName());
                k++;
                String hijo = e.nodeName() + k;
                arbolito.Insertar(arbolito.getRaiz(), hijo, padre);
                print(e);
            }
        }
    }

}
