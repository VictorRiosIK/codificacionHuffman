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
    public Lector(){
        this.fichero=new Fichero();
        
    }
    public void obtenerFichero(){
        fichero.obtenerFicheroALeer();
    }
    
    
}