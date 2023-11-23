package co.edu.unipiloto.estdatos.binarios.interfaz;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface IReconstructorArbol {

    public void cargarArchivo(String nombre) throws IOException;
    public void reconstruir();
    public void imprimirArbolEnJSON();
    public void crearArchivo() throws FileNotFoundException, UnsupportedEncodingException;
}
