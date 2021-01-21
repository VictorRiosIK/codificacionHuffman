/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codificacionhuffman;

import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author INKAB
 */

public class Descompresor {
        private Fichero fichero;
	//private Fichero fichero;
        private String binario;
        private ArrayList<Character> letras;//lista para las letras
        private ArrayList<String> binariosAsociados;
        private String mensaje;
        private int longitud;
    
        Descompresor(String pathKey1, String pathKey2) throws InterruptedException, IOException{
            this.binario=binario;
            this.letras=letras;
            this.binariosAsociados=binariosAsociados;
            this.mensaje="";
            this.longitud=longitud;
            fichero=new Fichero();
            fichero.abrirAmbosFicherosDesompresion(pathKey1, pathKey2);
         
        }
        Descompresor(){

        }
     
    public void imprimeListas(){
        for (int i = 0; i < letras.size(); i++) {
            System.out.println("Letra:"+letras.get(i)+", Binario:"+binariosAsociados.get(i));
        }
    }
    
   public void descomprimir() throws InterruptedException {
    	String aux="";
            for(int i=0;i<binario.length()-1;i+=longitud) {
    		System.out.println("I:"+i);
                aux=binario.substring(i,i+longitud);
    		System.out.println("EXTRAIDO: "+aux );
    		for(int j=0;j<letras.size();j++) {
                    if(binariosAsociados.get(j).equalsIgnoreCase(aux)){
                        Thread.sleep(500);
                        mensaje+=letras.get(j);
                        
                    }
	
                }
                aux="";	
            }
        
    }
    
    public String getMensaje() {
    	return mensaje;
    }
    
    
    
}
