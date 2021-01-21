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
    private ArrayList<String> letras;//lista para las letras
    private ArrayList<String> binariosAsociados;
    Descompresor() throws InterruptedException, IOException{
        
        this.letras=new ArrayList<String>();
        this.binariosAsociados=new ArrayList<String>();
      fichero=new Fichero("descomprimir");
       
    }
    
    public void agregarAListas(String binario,String letra){
        try{
            letras.add(binario.toString());
            binariosAsociados.add(letra.toString());
        }catch(Exception e){
            System.out.println(""+e.getMessage());
        }
    }
    
    
    public void imprimeListas(){
        for (int i = 0; i < letras.size(); i++) {
            System.out.println("Letra:"+letras.get(i)+", Binario:"+binariosAsociados.get(i));
        }
    }
    
    
    
}
