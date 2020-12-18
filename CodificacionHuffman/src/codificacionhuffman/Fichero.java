package codificacionhuffman;

import java.io.File;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HUGO
 */
public class Fichero {
    private File directorio;
    private JFileChooser fileChooser;
    private String rutaArchivo;
    public Fichero(){
        fileChooser = new JFileChooser();
        directorio=new File("C:\\CodificadorHuffman");
        directorio.mkdir();
        rutaArchivo="";
    }
    public void obtenerFicheroALeer(){
        fileChooser.showOpenDialog(fileChooser);
        String ruta = fileChooser.getSelectedFile().getAbsolutePath();
        this.rutaArchivo=ruta;
    }
    
    public String getRuta(){
        return this.rutaArchivo;
    }
}
