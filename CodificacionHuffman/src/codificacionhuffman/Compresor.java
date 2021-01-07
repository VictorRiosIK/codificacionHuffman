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
	 private String codigoLetra;
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
		 dos.setPadre(aux.getPadre());
		 uno.setPadre(aux.getPadre());
		 
		 if(uno.getPeso()>dos.getPeso()) {
			 aux.InsertarNodoSolo(dos,uno,suma); 
		 }
		 else {
			 aux.InsertarNodoSolo(uno,dos,suma);
		 }
		 arbol.remove(0);
		 arbol.remove(0);
		 arbol.add(aux);	
		 Collections.sort(arbol);
	}
	 
	public void llenarCola() {
		
		for(int i=0;i<repeticiones.size();i++) {
			arbol.add(crearArbol(letras.get(i),repeticiones.get(i)));
		}
		Collections.sort(arbol);
		
	}
	
	public Arbol crearArbol(Character letra,Integer repeticiones) {
		Arbol aux=new Arbol(letra,repeticiones);
		return aux;
		
	}
	
	public void establecerBinario(Nodo auxiliar) {
		if(auxiliar==null) {
			
		}
		else {
			if(auxiliar.getIzquierda()!=null) {
				auxiliar.getIzquierda().setBinario('1');
				establecerBinario(auxiliar.getIzquierda());
			}
			if(auxiliar.getDerecha()!=null) {
				auxiliar.getDerecha().setBinario('0');
				establecerBinario(auxiliar.getDerecha());
			}
			
		}
	}
	
	public void encontrarCodigo(Nodo auxiliar,String codigo,Character letra) {
		if(auxiliar==null) {
			
		}
		else {
			if(auxiliar.getIzquierda()!=null) {
				codigo=codigo+auxiliar.getIzquierda().getBinario();
				encontrarCodigo(auxiliar.getIzquierda(),codigo,letra);
			}
			if(auxiliar.getDerecha()!=null) {
				codigo=codigo.substring(0,codigo.length()-1);
				codigo=codigo+auxiliar.getDerecha().getBinario();
				encontrarCodigo(auxiliar.getDerecha(),codigo,letra);
			}
			if(auxiliar.getIzquierda()==null && auxiliar.getDerecha()==null) {
				if(auxiliar.getLetra()==letra) {
					codigoLetra=codigo;
				}
			}
			
		}
	}
	
	public void asignarCodigo() {
		for(int i=0;i<letras.size();i++) {
			encontrarCodigo(arbol.get(0).getId(),"",letras.get(i));
			//--------aqui se pasa al archivo falta codigo para archivo
		}
	}
	
	
	
	 
	 
	 
	 
}
