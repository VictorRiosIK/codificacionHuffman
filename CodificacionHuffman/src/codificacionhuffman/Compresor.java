package codificacionhuffman;

import huffman.Arbol;
import huffman.Lista;
import huffman.ListaArboles;
import huffman.Nodo;
import huffman.NodoArbol;
import huffman.NodoListaArbol;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private String mensaje;
    private String resultado;
    private Lista camino;
    private String codigo;
    private String codigoEncriptado;
    private Fichero fichero;
    private int maximoBinario;
    private Set<Character> hashSet;
     private Set<String> hashSetS;
    private ArrayList<Character> letras;//lista para las letras
    private ArrayList<String> binarios;//lista para guardar las repticiones de cada letra de texto
    public Compresor(String mensajeCodificar) throws InterruptedException, IOException {
        mensaje = mensajeCodificar;
        letras=new ArrayList<Character>();
        binarios=new ArrayList<String>();
        camino = new Lista();
        resultado = "";
        codigo="";
        fichero=new Fichero();
        maximoBinario=0;
        Lista l = ToNodos();
        ListaArboles la = cuentaLetras(l);
        ListaArboles l2 = juntaNodo(la);
		// System.out.println(l2.getInicio().toString());
        // Arbol a= new Arbol();
        // a.enOrder(l2.getInicio().getDato().getRaiz());
        encuentraCamino(l2.getInicio().getDato().getRaiz(), "");
        Lista listaCaminos = regresaCaminos();
        String x = convierte(listaCaminos);
        
        System.out.println("Binario" + x);
        this.codigoEncriptado=x;
        //fichero.enviaBinario(x);
        encriptar(x);
        //encripta(x);
        //Thread.sleep(2500);
        //rellenarBinarios();
       /*hashSet= new HashSet<Character>(letras);
        letras.clear();
        letras.addAll(hashSet);//eliminamos repetidos de la lista letras
      
        hashSetS= new HashSet<String>(binarios);
        binarios.clear();
        binarios.addAll(hashSetS);//eliminamos repetidos de la lista letras*/
        System.out.println("MAXIMO:"+maximoBinario);
    }
    
    public Compresor(String mensaje,String resultado) {
    	this.mensaje=mensaje;
    	this.resultado=resultado;
    }
    
   
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Lista ToNodos() {
        Lista l = new Lista();
        for (int i = 0; i < mensaje.length(); i++) {
            l.insertarFinal((mensaje.charAt(i)));
        }
        return l;

    }

    public ListaArboles cuentaLetras(Lista l) {
        ListaArboles la = new ListaArboles();
        Nodo aux = l.getInicio();
        while (aux != null) {
            Integer x = l.eliminarValor(aux.getDato());
            NodoArbol nuevo = new NodoArbol(aux.getDato(), x);
            Arbol a = new Arbol(nuevo);
            la.insertarOrdenado(a);
            aux = l.getInicio();
        }
        return la;
    }

    public NodoArbol uneNodos(NodoListaArbol a, NodoListaArbol b) {
        NodoArbol c = new NodoArbol('\u0000',
                ((a.getDato().getRaiz().getDato()) + (b.getDato().getRaiz()
                .getDato())));
        c.setIzq(a.getDato().getRaiz());
        c.setDer(b.getDato().getRaiz());
        return c;
    }

    public ListaArboles juntaNodo(ListaArboles l) {
        NodoListaArbol aux = l.getInicio();
        NodoListaArbol aux2 = null;
        while ((aux != null) && (aux.getSiguiente() != null)) {
            l.setInicio(aux.getSiguiente());
            aux.setSiguiente(null);
            aux2 = l.getInicio();
            l.setInicio(aux2.getSiguiente());
            aux2.setSiguiente(null);
            NodoArbol nuevo = uneNodos(aux, aux2);
            Arbol a = new Arbol(nuevo);
            l.insertarOrdenado(a);
            aux = l.getInicio();
        }
		// Arbol a=l.getInicio().getDato();
        // a.enOrder(a.getRaiz());
        // a.encuentraCamino(a.getRaiz(), "");
        // System.out.println("dato: "+l.getInicio().getDato().getRaiz().getDato());
        // System.out.println("letra: "+l.getInicio().getDato().getRaiz().getLetra());
        return l;
    }

    public void recorrer2(Lista l) {
        Nodo n = l.getInicio();
        while (n != null) {
            System.out.print(n.getDato() + n.getCamino() + "->");
            n = n.getSiguiente();
        }
    }

    public String eliminarUltimo(String re) {
        String cadena = "";
        for (int i = 0; i < re.length() - 1; i++) {
            cadena += re.charAt(i);
        }
        return cadena;
    }

    public void encuentraCamino(NodoArbol r, String c) {
        // Lista camino = new Lista();
        resultado += c;
        if (r != null) {
            if (r.getLetra() != '\u0000') { // si es una letra
                camino.insertarFinal(r.getLetra(), resultado);
            }
            encuentraCamino(r.getIzq(), "0");
            if (r.getIzq() != null) {
                resultado = eliminarUltimo(resultado);
            }
            encuentraCamino(r.getDer(), "1");
            if (r.getDer() != null) { // si no es un nodo hoja
                resultado = eliminarUltimo(resultado);
            }
        } else {
            resultado = eliminarUltimo(resultado);
        }
    }

    public Lista regresaCaminos() { // retornamos la lista que contiene los
        // caminos de cada caracter
        return camino;
    }

    public String busca(char s, Lista l) {
        String camino = "";
        Nodo aux = l.getInicio();
        while (aux != null) {
            if (aux.getDato() == s) {
                camino = aux.getCamino();
            }
            aux = aux.getSiguiente();
        }
        //System.out.println("Camino:"+ camino + " Char:"+s);
        letras.add(s);
        binarios.add(camino);
        if(compruebaCadenasCompletasBinario(s,camino)==1){
           
        }else{
             fichero.escribrFichero(s,camino);
             System.out.println(""+s+camino);
        }
        return camino;
    }
    public void rellenarBinarios(){
        //fichero.escribrFichero(caracter,auxBin);
        
    }
    public int compruebaCadenasCompletasBinario(char caracter, String binario){
        int cantidadLetra=0;
        obtenerMaximo(binario);
        
        for (int i = 0; i < letras.size(); i++) {
            if(letras.get(i)==caracter){
                cantidadLetra++;
               // System.out.println("ENCONTRO"+caracter);
            }
           
        }
        
         if(cantidadLetra>1){
                return 1;
            }else{
                return 0;
            }
    }
    public void obtenerMaximo(String binario){
        
        if(binario.length()>maximoBinario){
            maximoBinario=binario.length();
        }
    }
    public String convierte(Lista camino) {
        String c = "";
        for (int i = 0; i < mensaje.length(); i++) {
            c = c + busca(mensaje.charAt(i), camino);
        }System.out.println("Convierte"+ c);
        return c;
    }

    public char toAscii(String s) {// obtiene un codigo de 8 o menor
        String ascii = "";
        int numero = 0;
        int contador = 0;
        for (int i = 0; i < s.length(); i++) {// binario es string
            if (contador <= 8) {
                ascii = ascii + s.charAt(i);
                numero = Integer.parseInt(ascii, 2);
                if (contador == 8) {
                    ascii = "";
                    contador = 0;
                }
            }
        }
        return (char) numero;
    }

    public void encripta(String codigoHuffman) {
        String bites = "";
        String codigo = "";
        char c;
        int contador = 0;
        if (codigoHuffman.length() >= 8) {
            for (int i = 0; i < codigoHuffman.length(); i++) {
                if (contador <= 8) {
                    bites = bites + codigoHuffman.charAt(i);
                    contador++;
                    if (contador == 8) {
                        c = toAscii(bites);
                        codigo = codigo + c;
                        contador = 0;
                        bites = "";
                    }
                }
            }
        } else {
            c = toAscii(codigoHuffman);
            codigo = codigo + c;
        }
        System.out.println("" + codigo);
        fichero.escribirCodificacion(codigo);
        
    }

    public void encripta2(String codigoHuffman) {
        String bites = "";
        String codigo="";
        char c;
        int contador = 0;
        for (int i = 0; i < codigoHuffman.length(); i++) {
            bites = bites + codigoHuffman.charAt(i);
            contador++;
            if (contador == 8) {
                c = toAscii(bites);
                codigo = codigo + c;
                contador = 0;
                bites = "";
            }
        }
        System.out.println("Codigo Encriptado " + codigo);
        
    }
    
    public void encriptar(String binario) {
   	 int suma=0;
   	 String cadenaFinal="";
   	 int bandera=0;
   	 String aux="";
   	 int c=0;
   	 
   	 for(int i=0;i<binario.length();i++) {
   		 if(binario.charAt(i)=='0') {
   			 c++;
   		 }
   		 else if(binario.charAt(i)=='1' && bandera==0 ) {
   			 bandera=1;
   		 }
   		 if(c==2) {
   			 cadenaFinal=cadenaFinal+'a';   //0000100101 aa173  rre  
   			 														
   			 c=0;
   		 } 
   		 if(bandera==1) {
   			 aux=aux+binario.charAt(i);
   		 }
   	 }
   	 
   	 for(int i=0;i<aux.length();i++) {
   		 if(aux.charAt(i)=='1') {
   			 suma=suma+(int)Math.pow(2,i);
   		 }
   	 }
   	cadenaFinal=cadenaFinal+String.valueOf(suma);
   	 //escribirCompresion(cadenaFinal);
    }
    
    private String rellenar(String cadena){
        //Rellenamos la cadena con ceros a la izquierda
        String nueva="";
        for(int i=0;i<8-cadena.length();i++){
        nueva+="0";
        }
        nueva+=cadena;
        return nueva;
    }
        private String quitar(String cad,Integer n){
        //Quitamos a la cadena n caracteres
        String nueva="";
        for(int i=n;i<cad.length();i++)
        nueva+=cad.charAt(i);
        return nueva;
        
    }
        
    //Nueva forma de pensar problema
        
     
     
     private void escribirCompresion(String codigo) {
    	 try {
  	       FileOutputStream fos = new FileOutputStream("d:/prueba.txt");
  	       Writer out = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
  	       out.write(codigo);
  	       out.close();
  	    } 
  	    catch (IOException e) {
  	       e.printStackTrace();
  	    } 
     }
    
	 //private ArrayList<Arbol> arbol;
	 /*private ArrayList<Character> letras;//lista para las letras
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
	*/
	
	
	 
	 
	 
	 
}
