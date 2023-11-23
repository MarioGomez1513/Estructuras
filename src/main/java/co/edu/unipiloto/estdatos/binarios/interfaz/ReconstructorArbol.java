/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.estdatos.binarios.interfaz;

/**
 *
 * @author mario
 */
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class ReconstructorArbol implements IReconstructorArbol {

    private String inOrden;
    private String preOrden;
    private ArbolBinario arbol;

    private int preOrdenIndex;
    private Map<Integer, Integer> inOrdenMap;

    public ReconstructorArbol() {
        this.inOrden = "";
        this.preOrden = "";
        this.arbol = new ArbolBinario();
        this.preOrdenIndex = 0;
        this.inOrdenMap = new HashMap<>();
    }

    @Override
    public void cargarArchivo(String nombre) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data/" + nombre))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("in-orden=")) {
                    this.inOrden = line.substring(9);
                } else if (line.startsWith("pre-orden=")) {
                    this.preOrden = line.substring(10);
                }
            }
        }
    }

    @Override
    public void reconstruir() {
        for (int i = 0; i < inOrden.length(); i++) {
            inOrdenMap.put((int) inOrden.charAt(i), i);
        }
        arbol.raiz = reconstruirRecursivo(0, inOrden.length() - 1);
    }

    private NodoArbol reconstruirRecursivo(int inOrdenInicio, int inOrdenFin) {
        if (inOrdenInicio > inOrdenFin) {
            return null;
        }

        int valorActual = preOrden.charAt(preOrdenIndex++) - '0';
        NodoArbol nodo = new NodoArbol(valorActual);

        if (inOrdenInicio == inOrdenFin) {
            return nodo;
        }

        int inOrdenIndex = inOrdenMap.get(valorActual);

        nodo.izquierdo = reconstruirRecursivo(inOrdenInicio, inOrdenIndex - 1);
        nodo.derecho = reconstruirRecursivo(inOrdenIndex + 1, inOrdenFin);

        return nodo;
    }

    @Override
    public void imprimirArbolEnJSON() {
        arbol.imprimirEnJSON();
    }

    @Override
    public void crearArchivo() throws FileNotFoundException, UnsupportedEncodingException {
       
    }
}
