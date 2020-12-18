package codificacionhuffman;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
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
        try{
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
        this.rutaArchivo=ruta;
        }catch(Exception e){
            int opcion=JOptionPane.showConfirmDialog(null,"No se ha seleccionado ningun archivo, ¿Desea seleccionar de nuevo un archivo?","Selecciona una opción",JOptionPane.YES_NO_CANCEL_OPTION);
            
        }
    }
    
    public String getRuta(){
        return this.rutaArchivo;
    }
}
