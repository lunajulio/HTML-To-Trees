/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLToTrees;

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
        Document doc = Jsoup.connect(link).get();   //Lectura del link a través de la libreía JSoup
        v.print(doc);
    }

    public static Arbol arbolito = new Arbol("");
    private int c = 0, k = 0;

    private void print(Element root) {      //Subrutina para transformar el HTML en árbol
        Lista list = new Lista();
        Elements elm = root.children();     //Obteniendo hijos de un nodo padre 
        String padre = root.nodeName() + k; // La variable @k sirve como identificador para evitar nodos con información exactamente igual
        if (c == 0) {
            arbolito.setRaiz(padre);
        }
        c++;
        for (Element e : elm) { //Recorriendo cada hijo del padre
            if (list.search(e.nodeName()) == false) {   //Validando hijos repetidos
                list.addNode(e.nodeName());
                k++;    //Cambiando el identificador
                String hijo = e.nodeName() + k;
                arbolito.Insertar(arbolito.getRaiz(), hijo, padre);  //Insertando la información del HTML en el árbol
                print(e);
            }
        }
    }

}
