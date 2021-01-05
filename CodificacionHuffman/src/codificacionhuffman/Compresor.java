package codificacionhuffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HUGO
 */
public class Compresor {
    
	 private ArrayList<Arbol> arbol;
	 private ArrayList<Character> letras;//lista para las letras
	 private ArrayList<Integer> repeticiones;//lista para guardar las repticiones de cada letra de texto
	 
	 public Compresor(ArrayList<Arbol> arbol, ArrayList<Character> letras, ArrayList<Integer> repeticiones) {
		super();
		this.arbol = arbol;
		this.letras = letras;
		this.repeticiones = repeticiones;
	}
	 
	public Compresor() {
			arbol = new ArrayList<Arbol>();
			letras = new ArrayList<Character>();
			repeticiones = new ArrayList<Integer>();
	}
	 
	

	public void insertarDatos(ArrayList<Character> letras,ArrayList<Integer> repeticiones ) {
		this.letras=letras;
		this.repeticiones=repeticiones;
		
	 }
	 
	 public void Fucionar(Nodo uno,Nodo dos) {
		 Integer suma=uno.getPeso()+dos.getPeso();
		 
		 Arbol aux=new Arbol();
		 	
		 if(uno.getPeso()>dos.getPeso()) {
			 aux.InsertarNodoSolo(dos,uno,suma);	 
		 }
		 else {
			 aux.InsertarNodoSolo(uno,dos,suma);
		 }
		 arbol.add(aux);	
		 Collections.sort(arbol);
	}
	 
	 
}
