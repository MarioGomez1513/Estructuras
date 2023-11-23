/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.estdatos.binarios.interfaz;

/**
 *
 * @author mario
 */
public class NodoArbol {
    public int valor;
    public NodoArbol izquierdo;
    public NodoArbol derecho;

    public NodoArbol(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}
