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
    
	//private Fichero fichero;
    private String binario;
    private ArrayList<Character> letras;//lista para las letras
    private ArrayList<String> binariosAsociados;
    private String mensaje;
    private int longitud;
    
    Descompresor(String binario,ArrayList<Character> letras,ArrayList<String> binariosAsociados,int longitud) throws InterruptedException, IOException{
        this.binario=binario;
        this.letras=letras;
        this.binariosAsociados=binariosAsociados;
        this.mensaje="";
        this.longitud=longitud;
     // fichero=new Fichero("descomprimir");
    }
    Descompresor(){
        
    }
   /* public void agregarAListas(String binario,String letra){
        try{
            letras.add(binario.toString());
            binariosAsociados.add(letra.toString());
        }catch(Exception e){
            System.out.println(""+e.getMessage());
        }
    }*/
    
    
    public void imprimeListas(){
        for (int i = 0; i < letras.size(); i++) {
            System.out.println("Letra:"+letras.get(i)+", Binario:"+binariosAsociados.get(i));
        }
    }
    
    public void descomprimir() {
    	String aux="";
    	int c=0;
    	
    	for(int i=0;i<binario.length();i++) {
    		
    		if(c<binariosAsociados.get(i).length()) {
    			aux=aux+binario.charAt(i);
    			c++;
    		}
    		if(c>=binariosAsociados.get(i).length()) {
    			c=0;
    			for(int j=0;j<binariosAsociados.size();j++) {
    				if(aux.equals(binariosAsociados.get(j))) {
    					mensaje=mensaje+letras.get(j);
    				}
    			}
    			aux="";
    		}
    	}
    }
    
    public String getMensaje() {
    	return mensaje;
    }
    
    
    
}
