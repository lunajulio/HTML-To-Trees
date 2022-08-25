/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_n.ario;

/**
 *
 * @author F-E-R
 */
public class Nodo {

    private String info;
    private int canhijos;
    public Nodo hijos[];
    private Nodo hijosT[];
    

    public Nodo(String dato) {
        info = dato;
        this.canhijos = 0;
    }

    private void copiarHijos() {
        hijosT = new Nodo[canhijos + 1];
        for (int i = 0; i < this.canhijos; i++) {
            hijosT[i] = hijos[i];
        }
    }

    public void aumentarHijos(Nodo nodo) {
        copiarHijos();
        hijosT[this.canhijos] = nodo;
        hijos = hijosT;
        this.canhijos++;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCanhijos() {
        return canhijos;
    }

  
    

    
}
