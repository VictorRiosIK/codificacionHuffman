package codificacionhuffman;

import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HUGO
 */
public class Lector {
    private Fichero fichero;
    private String pathArchivoTxt;
    private File archivo;
    public Lector(){
        this.fichero=new Fichero();
        
    }
    public void obtenerFichero(){
        this.fichero.obtenerFicheroALeer();
        this.obtienePathArchivo();
    }
    
    
    private void obtienePathArchivo(){
        this.pathArchivoTxt=fichero.getRuta();
        this.archivo=new File(pathArchivoTxt);
    }
    
    public String getPathArchivo(){
        return this.pathArchivoTxt;
    }
    
    
}
