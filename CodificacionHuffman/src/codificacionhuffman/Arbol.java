package codificacionhuffman;

public class Arbol implements Comparable<Arbol>{
	
	private Nodo raiz;
	

	public Arbol(){
		raiz=null;
	}
	
	public void Insertar(Integer peso,Character letra) {
		raiz=new Nodo(peso,letra);
	}
	
	public void InsertarNodoSolo(Nodo izquierda,Nodo derecha,Integer peso) {
		raiz=new Nodo(peso);
		raiz.setIzquierda(izquierda);
		raiz.setDerecha(derecha);
	}
	
	public Integer getPeso() {
		return raiz.getPeso();
	}
	
	@Override
	public int compareTo(Arbol arbol) {
		// TODO Auto-generated method stub
		return arbol.getPeso().compareTo(getPeso());
	}
	
	
}
