package codificacionhuffman;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
    private ArrayList<Character> letras;//lista para las letras
    private ArrayList<Integer> repeticiones;//lista para guardar las repticiones de cada letra de texto
    private ArrayList<Float> probabilidad;
    private Set<Character> hashSet;
    private Fichero fichero;
    private Descompresor descompresor;
    public Codificador() throws IOException, InterruptedException{
           this.escritorArchivo=new Escritor();
           this.lectorArchivo=new Lector();
           this.fichero=new Fichero();
           this.descompresor=new Descompresor();
           letras=new ArrayList<Character>();
           repeticiones=new ArrayList<Integer>();
           probabilidad=new ArrayList<Float>();
           this.texto="";
    }
    
    //aqui lee el archivo de texto que contiene el binario
    public void calcularCodificacion() throws InterruptedException, IOException{
        JOptionPane.showMessageDialog(null,"\t\tBIENVENIDO AL COMPRESOR DE TEXTO MEDIANTE EL CODIGO DE HUFFMAN\n"
                + "A continuación se le pedira que elija el archivo .txt a codificar");
        lectorArchivo.obtenerFichero();
        texto=lectorArchivo.obtieneTexto();//texto obtenido del archivo
        separarCaracteres();
        this.compresor=new Compresor(texto);
        calculaProbabilidadLetras(texto);
    }
    
    
    public void calcularDescompresor() throws IOException, InterruptedException{
        JOptionPane.showMessageDialog(null,"\t\tBIENVENIDO AL DESCOMPRESOR DE TEXTO MEDIANTE EL CODIGO DE HUFFMAN\n"
                + "A continuación se le pedira que elija el archivo .txt a codificar");
        lectorArchivo.obtenerFichero();
        texto=lectorArchivo.obtieneTexto();//texto obtenido del archivo
        System.out.println("Binario de archivo: "+texto);
       
    }
    public void calculaProbabilidadLetras(String textoOriginal){
        float aux=0;
        double auxEntropia=0,aux2=0;
        for (int i = 0; i < repeticiones.size(); i++) {
            aux=(float)repeticiones.get(i)/textoOriginal.length();
               //System.out.println(""+repeticiones.get(i));
            aux2=(double)1/aux;
            auxEntropia+=(double)aux*log(aux2,2);
            
        }
        fichero.escribirEntropia(auxEntropia);
    }
    private static Double log(double num, int base) {
      return (Math.log10(num) / Math.log10(base));
   }
    public void separarCaracteres(){
         
        for (int i = 0; i < this.texto.length(); i++) {
            letras.add(this.texto.toLowerCase().charAt(i));//transformamos todas a minisculas para facilitar el manejo de las letras 
            
        }
        hashSet= new HashSet<Character>(letras);
        letras.clear();
        letras.addAll(hashSet);//eliminamos repetidos de la lista letras
        
        obtenerRepeticiones();
        //imprimirListasYRepeticiones(); metodo para imprimir las listas
    }
    
    public void obtenerRepeticiones(){//aqui llenamos las listas con letras y repeticiones
        int repeticiones=0;
        String auxLetra="";
        for (int i = 0; i < this.letras.size(); i++) {
            repeticiones=0;
            for (int j = 0; j < this.texto.length(); j++) {
                auxLetra=Character.toString(this.letras.get(i));
                if(auxLetra.equalsIgnoreCase(Character.toString(this.texto.charAt(j)))){
                    repeticiones++;
                }
            }
            this.repeticiones.add(repeticiones);
           
        }
    }
    
    public void imprimirListasYRepeticiones(){
        for (int i = 0; i < this.letras.size(); i++) {
            System.out.println("letra: " + this.letras.get(i) + " -repeticiones en texto: "+ this.repeticiones.get(i));
        }
    }
    
}
