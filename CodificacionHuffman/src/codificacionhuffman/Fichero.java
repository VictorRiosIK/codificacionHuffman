package codificacionhuffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
    private ArrayList<String> binarios;
    private ArrayList<Character> letras;
    public Fichero() throws IOException, InterruptedException{
        fileChooser = new JFileChooser();
        descompresor=new Descompresor();
        rutaArchivo="";
        binarios=new ArrayList<String>();
        letras=new ArrayList<Character>();
      
        directorio=new File("C:\\CodificadorHuffman");
        directorio.mkdir();
        directorio=new File("C:\\CodificadorHuffman\\Codificacion");
        directorio.mkdir();
        
        archivo=new File("C:\\CodificadorHuffman\\Codificacion\\","Codificacion.txt");
        archivo.createNewFile();
        archivo=new File("C:\\CodificadorHuffman\\Codificacion\\","llave.txt");
        archivo.createNewFile();
        archivo=new File("C:\\CodificadorHuffman\\Codificacion\\","codigoComprimido.txt");
        archivo.createNewFile();
        archivo=new File("C:\\CodificadorHuffman\\Codificacion\\","Entropia.txt");
        archivo.createNewFile();
        archivo=new File("C:\\CodificadorHuffman\\Codificacion\\","codigoDescomprimido.txt");
        archivo.createNewFile();
    }
    public Fichero(String eccion){
        
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
        
        try (PrintWriter out = new PrintWriter(new FileOutputStream(("C:\\CodificadorHuffman\\Codificacion\\"+"llave.txt"),true))) {
            out.write(caracter+"ª"+binarioAsociado+"\n");
        }catch(FileNotFoundException fnfe){
            System.out.println("Error. No se tiene registro de ese archivo");
        }
        
    }
    public void enviaBinario(String x){
        
        try (PrintWriter out = new PrintWriter(new FileOutputStream(("C:\\CodificadorHuffman\\Codificacion\\"+"codigoComprimido.txt"),true))) {
            out.write(x+"\n");
        }catch(FileNotFoundException fnfe){
            System.out.println("Error. No se tiene registro de ese archivo");
        }
        /*try {
  	       FileOutputStream fos = new FileOutputStream("C:\\CodificadorHuffman\\Codificacion\\"+"llave.txt");
  	       Writer out = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
  	       out.write(x+"\n");
  	       out.close();
  	    } 
  	    catch (IOException e) {
  	       e.printStackTrace();
  	    }*/
    }
    public void escribirCodificacion(String codificado){
        try (PrintWriter out = new PrintWriter(new FileOutputStream(("C:\\CodificadorHuffman\\Codificacion\\"+"Codificacion.txt"),true))) {
            out.write(codificado);
        }catch(FileNotFoundException fnfe){
            System.out.println("Error. No se tiene registro de ese archivo");
        }
        /*try {
  	       FileOutputStream fos = new FileOutputStream("C:\\CodificadorHuffman\\Codificacion\\"+"Codificacion.txt");
  	       Writer out = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
  	       out.write(codificado+"\n");
  	       out.close();
  	    } 
  	    catch (IOException e) {
  	       e.printStackTrace();
  	    }*/
    }
    public void escribirEntropia(double entropia){
        /* try (PrintWriter out = new PrintWriter(new FileOutputStream(("C:\\CodificadorHuffman\\Codificacion\\"+"Entropia.txt"),true))) {
            out.write("Entropia: "+entropia+" bits\n");
        }catch(FileNotFoundException fnfe){
            System.out.println("Error. No se tiene registro de ese archivo");
        }*/try {
  	       FileOutputStream fos = new FileOutputStream("C:\\CodificadorHuffman\\Codificacion\\"+"Entropia.txt");
  	       Writer out = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
  	       out.write("Entropia: "+entropia+" bits\n");
  	       out.close();
  	    } 
  	    catch (IOException e) {
  	       e.printStackTrace();
  	    }
    }
    /*METODOS DE DESCOMPRESOR*/
    
    public void traerCodigosLetras(){
         String linea;
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\CodificadorHuffman\\Codificacion\\"+"CodificacionCaracteres.txt"))){
            
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split("ª");
                //System.out.println(infoEmp);
               
                
            }
            }catch (FileNotFoundException ex) {
                System.out.println("Error. No se tiene registro de ese archivo");
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        descompresor.imprimeListas();
       // descompresor.imprimeListas();
    }
    public void llenarCodigoDescomprimido(String descifrado){
       
  	       try (PrintWriter out = new PrintWriter(new FileOutputStream(("C:\\CodificadorHuffman\\Codificacion\\"+"codigoDescomprimido.txt"),true))) {
            out.write(descifrado);
        }catch(FileNotFoundException fnfe){
            System.out.println("Error. No se tiene registro de ese archivo");
        }
  	     
  	    
    }
    public void abrirAmbosFicherosDesompresion(String pathKey1, String pathKey2){
        System.out.println(""+pathKey1);
         System.out.println(""+pathKey2);
        String mensaje="";
        String linea;
         BufferedReader aux;
        try(BufferedReader br1 = new BufferedReader(new FileReader(pathKey1))){
              
            while ((linea = br1.readLine()) != null) {//C:\\CodificadorHuffman\\Codificacion\\"+"llave.txt
                
                    
                String[] columnas = linea.split("ª");
                 
                binarios.add(columnas[1]);
                letras.add(columnas[0].charAt(0));
                /*if(linea.equals(columnas[1])){
                    escribirCodificacion("IGUAL"+ columnas[0]);
                }*/
                
            }
            }catch (Exception ex) {
                System.out.println("Error. No se tiene registro de ese archivo"+ex.getMessage());
            }
        
        compruebaBinarioCompletoConLista(pathKey2);
        
    }
    public void compruebaBinarioCompletoConLista(String pathKey2){
        String mensaje="";
        String linea;
        try(BufferedReader br1 = new BufferedReader(new FileReader(pathKey2))){
              
                
                while( (linea = br1.readLine()) != null){//"C:\\CodificadorHuffman\\Codificacion\\"+"codigoComprimido.txt"
                      
                      
                    /*if(a.equals(binarios.get(i))){
                      escribirCodificacion("IGUAL"+ letras.get(i));  
                    }
                    if(i==3){
                        i=0;
                    }*/
                       for (int j = 0; j < binarios.size(); j++) {
                           if(linea.equals(binarios.get(j))){
                               llenarCodigoDescomprimido(""+letras.get(j));  
                           }
                        }
                }
                
                
            
            }catch (Exception ex) {
                System.out.println("Error. No se tiene registro de ese archivo"+ex.getMessage());
            }
    }
    
    public String getRuta(){
        return this.rutaArchivo;
    }
}
