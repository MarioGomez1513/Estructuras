/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.estdatos.binarios.interfaz;

/**
 *
 * @author mario
 */
public class ArbolBinario {

    NodoArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void agregarNodo(int valor) {
        raiz = agregarNodoRecursivo(raiz, valor);
    }

    private NodoArbol agregarNodoRecursivo(NodoArbol nodo, int valor) {
        if (nodo == null) {
            return new NodoArbol(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = agregarNodoRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = agregarNodoRecursivo(nodo.derecho, valor);
        }

        return nodo;
    }

    public void imprimirEnOrden() {
        imprimirEnOrdenRecursivo(raiz);
        System.out.println();
    }

    private void imprimirEnOrdenRecursivo(NodoArbol nodo) {
        if (nodo != null) {
            imprimirEnOrdenRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            imprimirEnOrdenRecursivo(nodo.derecho);
        }
    }

    public void imprimirEnJSON() {
        System.out.println("{");
        imprimirEnJSONRecursivo(raiz);
        System.out.println("}");
    }

    private void imprimirEnJSONRecursivo(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print("\"valor\": " + nodo.valor);
            if (nodo.izquierdo != null || nodo.derecho != null) {
                System.out.print(", \"izquierdo\": ");
                imprimirEnJSONRecursivo(nodo.izquierdo);
                System.out.print(", \"derecho\": ");
                imprimirEnJSONRecursivo(nodo.derecho);
            }
            System.out.println();
        }
    }

    public boolean contieneSubArbol(ArbolBinario subArbol) {
        return contieneSubArbolRecursivo(raiz, subArbol.raiz);
    }

    private boolean contieneSubArbolRecursivo(NodoArbol nodo, NodoArbol subArbolRaiz) {
        if (nodo == null) {
            return false;
        }

        if (sonIguales(nodo, subArbolRaiz)) {
            return true;
        }

        return contieneSubArbolRecursivo(nodo.izquierdo, subArbolRaiz) || contieneSubArbolRecursivo(nodo.derecho, subArbolRaiz);
    }

    private boolean sonIguales(NodoArbol nodoA, NodoArbol nodoB) {
        if (nodoA == null && nodoB == null) {
            return true;
        }
        if (nodoA == null || nodoB == null) {
            return false;
        }

        return (nodoA.valor == nodoB.valor) && sonIguales(nodoA.izquierdo, nodoB.izquierdo) && sonIguales(nodoA.derecho, nodoB.derecho);
    }
}
