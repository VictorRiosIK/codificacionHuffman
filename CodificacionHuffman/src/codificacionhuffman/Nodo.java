package codificacionhuffman;

public class Nodo {

	private Nodo padre;
	private Nodo izquierda;
	private Nodo derecha;
	private Character letra;
	private Integer peso;
	private Character binario;
//---------------------------------Constructores--------------------------------
	public Nodo(Nodo padre, Nodo izquierda, Nodo derecha, Character letra, Integer peso, Character binario) {
	super();
	this.padre = padre;
	this.izquierda = izquierda;
	this.derecha = derecha;
	this.letra = letra;
	this.peso = peso;
	this.binario = binario;
	}
	public Nodo() {
		setPadre(null);
		setIzquierda(null);
		setDerecha(null);
		setLetra(null);
		setPeso(null);
		setBinario(null);
	}
	
	public Nodo(Character binario,Integer peso) {
		this.binario=binario;
		this.peso=peso;
		setPadre(null);
		setLetra(null);
		setIzquierda(null);
		setDerecha(null);
	}
	
	public Nodo(Character binario,Integer peso,Character letra) {
		this.binario=binario;
		this.peso=peso;
		setPadre(null);
		setLetra(letra);
		setIzquierda(null);
		setDerecha(null);
		
	}
	public Nodo(Integer peso,Character letra) {
		this.binario=null;
		this.peso=peso;
		setPadre(null);
		setLetra(letra);
		setIzquierda(null);
		setDerecha(null);
		
	}
	public Nodo(Integer peso) {
		this.binario=null;
		this.peso=peso;
		setPadre(null);
		setLetra(null);
		setIzquierda(null);
		setDerecha(null);
		
	}
	
	public Nodo(Nodo padre,Character binario,Integer peso) {
		this.binario=binario;
		this.peso=peso;
		setPadre(padre);
		setLetra(null);
		setIzquierda(null);
		setDerecha(null);
	}
	
//----------------------------------Geters and Seters------------------------	
	public Nodo getPadre() {
		return padre;
	}
	public void setPadre(Nodo nodo) {
		this.padre = nodo;
	}
	
	public Nodo getIzquierda() {
		return izquierda;
	}
	public void setIzquierda(Nodo izquierda) {
		this.izquierda = izquierda;
	}
	public Nodo getDerecha() {
		return derecha;
	}
	public void setDerecha(Nodo derecha) {
		this.derecha = derecha;
	}
	public Character getLetra() {
		return letra;
	}
	public void setLetra(Character letra) {
		this.letra = letra;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	public Character getBinario() {
		return binario;
	}
	public void setBinario(Character binario) {
		this.binario = binario;
	}
	
	
	
}
