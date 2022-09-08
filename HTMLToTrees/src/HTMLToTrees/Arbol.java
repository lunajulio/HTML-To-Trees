
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLToTrees;

import java.util.HashMap;

/**
 *
 * @author F-E-R
 */
public class Arbol {

    private Nodo raiz;
    private int altura, nodos_nivel, cont = 0;
    public HashMap hijoypadre = new HashMap();  //Diccionario para guardar el padre del hijo
    private String[] info_nivel = new String[1000];

    public Arbol(String dato) {
        raiz = new Nodo(dato);
    }

    public Arbol() {
        raiz = null;
    }

    public void setRaiz(String dato) {
        this.raiz = new Nodo(dato);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public int getNodos_nivel(Nodo nodo, int n) {   //Función para obetener la cantidad de nodos de un nivel
        nodos_nivel = 0;
        vernivel(nodo, n);
        return nodos_nivel;
    }

    public int Altura(Nodo nodo) {  //Función para obetener la altura de un árbol
        int mayor = 0, temp;
        if (nodo == null) {
            altura = 0;
        } else {
            for (int i = 0; i < nodo.getCanhijos(); i++) {
                temp = Altura(nodo.hijos[i]);
                if (temp > mayor) {
                    mayor = temp;
                }
            }
            altura = mayor + 1;
        }
        return altura;
    }

    public void Insertar(Nodo nodo, String dato, String padre) {
        Nodo nuevo = new Nodo(dato);
        if (nodo.getInfo().equals(padre)) {
            nodo.aumentarHijos(nuevo);
            hijoypadre.put(nuevo.getInfo(), nodo);
        } else {
            for (int i = 0; i < nodo.getCanhijos(); i++) {
                if (nodo.hijos[i].getInfo().equals(padre)) {
                    nodo.hijos[i].aumentarHijos(nuevo);
                    hijoypadre.put(nuevo.getInfo(), nodo.hijos[i]);
                } else {
                    Insertar(nodo.hijos[i], dato, padre);
                }
            }
        }
    }
    
    /*Subrutina para establecer las coordenadas de un nodo en la pantalla */
    public void establecer_coordenadas(Nodo nodo, String target, int x, int y) {
        if (nodo.getInfo().equals(target)) {
            nodo.punto.setLocation(x, y);
        } else {
            for (int i = 0; i < nodo.getCanhijos(); i++) {
                if (nodo.hijos[i].getInfo().equals(target)) {
                    nodo.hijos[i].punto.setLocation(x, y);
                } else {
                    establecer_coordenadas(nodo.hijos[i], target, x, y);
                }
            }
        }
    }

    public void recorrerarbol(Nodo nodo) {
        if (nodo == this.raiz) {
//            System.out.println("{" + escribir_nodo(this.raiz.getInfo()) + "}");
            System.out.println("{" + this.raiz.getInfo() + "}");
        }
        for (int i = 0; i < nodo.getCanhijos(); i++) {
//            System.out.println("{" + escribir_nodo(nodo.hijos[i].getInfo()) + "}");
            System.out.println("{" + nodo.hijos[i].getInfo() + "}");
            recorrerarbol(nodo.hijos[i]);
        }
    }

    public String escribir_nodo(String info_nodo) {  //Función para obtener la información de un nodo sin su identificador
        char[] cadena_div = info_nodo.toCharArray();
        String inf = "";
        for (int i = 0; i < cadena_div.length; i++) {
            if (Character.isAlphabetic(cadena_div[i])) {
                inf += cadena_div[i];
            }
        }
        return inf;
    }

    private void vernivel(Nodo nodo, int n) {       //Subrutina para obtener la cantidad de nodos de un nivel
        if (nodo != null) {
            if (n == 0) {
                nodos_nivel++;
            }
            for (int i = 0; i < nodo.getCanhijos(); i++) {
                vernivel(nodo.hijos[i], n - 1);
            }
        }
    }

    public String[] getInfo_nivel(Nodo nodo, int n) {   //Función para obtener la información de los nodos de un nivel
        cont = 0;
        info_nodos_nivel(nodo, n);
        return info_nivel;
    }

    private void info_nodos_nivel(Nodo nodo, int n) { //Subrutina para obtener la información de los nodos de un nivel
        if (nodo != null) {
            if (n == 0) {
//                info_nivel[cont] = escribir_nodo(nodo.getInfo());
                info_nivel[cont] = nodo.getInfo();
                cont++;
            }
            for (int i = 0; i < nodo.getCanhijos(); i++) {
                info_nodos_nivel(nodo.hijos[i], n - 1);
            }
        }
    }

}
