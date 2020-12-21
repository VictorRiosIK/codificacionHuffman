package codificacionhuffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

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
    private String texto;
    private FileReader fileReader;
    private BufferedReader buffer;
    public Lector(){
        this.fichero=new Fichero();
        this.texto="";
    }
    public void obtenerFichero(){
        this.fichero.obtenerFicheroALeer();
        this.obtienePathArchivo();
    }
    
    
    private void obtienePathArchivo(){
        this.pathArchivoTxt=fichero.getRuta();
        this.archivo=new File(pathArchivoTxt);
    }
    public String obtieneTexto(){
        try{
            this.fileReader=new FileReader(this.archivo);
            buffer=new BufferedReader(this.fileReader);
            while((this.texto=this.buffer.readLine()) != null){
                System.out.print(this.texto);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error leyendo el archivo");
        }
        return this.texto;
    }
    public String getPathArchivo(){
        return this.pathArchivoTxt;
    }
    public File getArchivo(){
        return this.archivo;
    }
    
    
}
