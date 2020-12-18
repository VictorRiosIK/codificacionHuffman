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
    public Fichero(){
        fileChooser = new JFileChooser();
        directorio=new File("C:\\CodificadorHuffman");
        directorio.mkdir();
    }
    public void obtenerFicheroALeer(){
        fileChooser.showOpenDialog(fileChooser);
    }
}
