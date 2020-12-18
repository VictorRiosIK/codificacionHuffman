package codificacionhuffman;

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
    
    public Codificador(){
           this.escritorArchivo=new Escritor();
           this.lectorArchivo=new Lector();
           this.compresor=new Compresor();
    }
    
}
