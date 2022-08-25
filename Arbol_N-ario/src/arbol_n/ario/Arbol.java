
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_n.ario;

import java.util.HashMap;

/**
 *
 * @author F-E-R
 */
public class Arbol {

    private Nodo raiz;
    private int altura;
    private int nodos_nivel;
    public HashMap hijoypadre = new HashMap();

    public Arbol(String dato) {
        raiz = new Nodo(dato);
    }

    public Arbol() {
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }  

    public int getNodos_nivel(Nodo nodo, int n) {
        nodos_nivel = 0;
        vernivel(nodo, n);
        return nodos_nivel;
    }
    
    public int Altura(Nodo nodo){
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
            altura = mayor+1;
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

    public void recorrerarbol(Nodo nodo) {
        if (nodo == this.raiz){
            System.out.println("{" + this.raiz.getInfo() + "}");
        }
        for (int i = 0; i < nodo.getCanhijos(); i++) {
            System.out.println("{" + nodo.hijos[i].getInfo() + "}");
            recorrerarbol(nodo.hijos[i]);
        }
    }
    
//    public Nodo obtenerpadre(Nodo nodo){
//        boolean encontrado = false;
//        if (nodo == this.raiz){
//            return null;
//        } else {
//            Nodo temp = this.raiz;
//            for (int i = 0; i < temp.getCanhijos(); i++) {
//                if (temp.hijos[i] == nodo) {
//                    return temp;
//                } else {
//                    
//                }
//            }
//        }
//        return null;
//    }
    
    public void vernivel(Nodo nodo, int n){
        if (nodo != null) {
            if (n == 0) {
                nodos_nivel++;
            }
            for (int i = 0; i < nodo.getCanhijos(); i++) {
                vernivel(nodo.hijos[i], n-1);
            }
        }
    }

}
