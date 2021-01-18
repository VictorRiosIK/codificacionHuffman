package codificacionhuffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
    private File archivo;
    private Descompresor descompresor;
    private JFileChooser fileChooser;
    private String rutaArchivo;
    public Fichero() throws IOException, InterruptedException{
        fileChooser = new JFileChooser();
        descompresor=new Descompresor();
        rutaArchivo="";
        directorio=new File("C:\\CodificadorHuffman\\Codificacion");
        directorio.mkdir();
        archivo=new File("C:\\CodificadorHuffman\\Codificacion\\","Codificacion.txt");
        archivo.createNewFile();
        archivo=new File("C:\\CodificadorHuffman\\Codificacion\\","CodificacionCaracteres.txt");
        archivo.createNewFile();
        archivo=new File("C:\\CodificadorHuffman\\Codificacion\\","CodificacionBin.txt");
        archivo.createNewFile();
        archivo=new File("C:\\CodificadorHuffman\\Codificacion\\","Entropia.txt");
        archivo.createNewFile();
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
    public void escribrFichero(char caracter, String binarioAsociado){
       // System.out.println("Llega" + "Char:"+caracter + "Binario:"+binarioAsociado);
        
        try (PrintWriter out = new PrintWriter(new FileOutputStream(("C:\\CodificadorHuffman\\Codificacion\\"+"CodificacionCaracteres.txt"),true))) {
            out.write(caracter+"="+binarioAsociado+"\n");
        }catch(FileNotFoundException fnfe){
            System.out.println("Error. No se tiene registro de ese archivo");
        }
    }
    public void enviaBinario(String x){
        
        try (PrintWriter out = new PrintWriter(new FileOutputStream(("C:\\CodificadorHuffman\\Codificacion\\"+"CodificacionBin.txt"),true))) {
            out.write(x+"\n");
        }catch(FileNotFoundException fnfe){
            System.out.println("Error. No se tiene registro de ese archivo");
        }
    }
    public void escribirCodificacion(String codificado){
        try (PrintWriter out = new PrintWriter(new FileOutputStream(("C:\\CodificadorHuffman\\Codificacion\\"+"Codificacion.txt"),true))) {
            out.write(codificado+"\n");
        }catch(FileNotFoundException fnfe){
            System.out.println("Error. No se tiene registro de ese archivo");
        }
    }
    public void escribirEntropia(double entropia){
         try (PrintWriter out = new PrintWriter(new FileOutputStream(("C:\\CodificadorHuffman\\Codificacion\\"+"Entropia.txt"),true))) {
            out.write("Entropia: "+entropia+" bits\n");
        }catch(FileNotFoundException fnfe){
            System.out.println("Error. No se tiene registro de ese archivo");
        }
    }
    /*METODOS DE DESCOMPRESOR*/
    
    public void traerCodigosLetras(){
         String linea;
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\CodificadorHuffman\\Codificacion\\"+"CodificacionCaracteres.txt"))){
            
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split("=");
                //System.out.println(infoEmp);
                descompresor.agregarAListas(columnas[0],columnas[1]);
            }
            }catch (FileNotFoundException ex) {
                System.out.println("Error. No se tiene registro de ese archivo");
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
       // descompresor.imprimeListas();
    }
    public String getRuta(){
        return this.rutaArchivo;
    }
}
