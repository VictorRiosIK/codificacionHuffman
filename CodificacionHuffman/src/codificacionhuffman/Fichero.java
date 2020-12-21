package codificacionhuffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public void obtenerFicheroALeer() {
        String respJOption="";
        
        do{
            
            try{
                int seleccion=fileChooser.showOpenDialog(null);
                File abre = null;
                if(seleccion== JFileChooser.APPROVE_OPTION){
                    abre=fileChooser.getSelectedFile(); 
                    this.rutaArchivo=fileChooser.getSelectedFile().getAbsolutePath();
                }else if(seleccion== JFileChooser.CANCEL_OPTION){
                    System.out.println("cancela");
                }
            }catch(Exception e){
                int opcion=JOptionPane.showConfirmDialog(null,"No se ha seleccionado ningun archivo, ¿Desea seleccionar de nuevo un archivo?","Selecciona una opción",JOptionPane.YES_NO_CANCEL_OPTION);
                System.out.println(""+opcion);
                //Si=0
                //No=1
                //Cancelar=2
                switch(opcion){
                    case 0:
                        respJOption="si";
                        break;
                    default:
                        respJOption="no";
                        JOptionPane.showMessageDialog(null,"\t\tHasta luego!");
                        System.exit(0);
                }
            };
        
        }while(respJOption.equals("si"));
    }
    
    public String getRuta(){
        return this.rutaArchivo;
    }
}
