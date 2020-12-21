package codificacionhuffman;

import java.io.File;
import java.util.ArrayList;
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
public class Codificador {
    private Escritor escritorArchivo;
    private Lector lectorArchivo;
    private Compresor compresor;
    private String texto;
    private ArrayList<String> letras;//lista para las letras
    private ArrayList<Integer> repeticiones;//lista para guardar las repticiones de cada letra de texto
    
    public Codificador(){
           this.escritorArchivo=new Escritor();
           this.lectorArchivo=new Lector();
           this.compresor=new Compresor();
           letras=new ArrayList<String>();
           repeticiones=new ArrayList<Integer>();
    }
    public void calcularCodificacion(){
        JOptionPane.showMessageDialog(null,"\t\tBIENVENIDO AL COMPRESOR DE TEXTO MEDIANTE EL CODIGO DE HUFFMAN\n"
                + "A continuación se le pedira que elija el archivo .txt a codificar");
        lectorArchivo.obtenerFichero();
        texto=lectorArchivo.obtieneTexto();
        
        
    }
    
}
