/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codificacionhuffman;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.System;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/**
 *
 * @author HUGO
 */
public class CodificacionHuffman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        
       PanelInicio panel=new PanelInicio();
       panel.setVisible(true);
       panel.setLocationRelativeTo(null);
       
    	   System.out.println("Kevin");
    	
    	
    }
    
}



/*String palabra="00110111";
int entero=1831234123;
String p=String.valueOf(entero);
System.out.println(p);
byte[] bytes = ByteBuffer.allocate(4).putInt(entero).array();

String cadena= new String(bytes,Charset.forName("UTF-8"));
System.out.println(palabra);
System.out.println(cadena);

try {
       FileOutputStream fos = new FileOutputStream("d:/prueba.txt");
       Writer out = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
       out.write(cadena);
       out.close();
    } 
    catch (IOException e) {
       e.printStackTrace();
    }

 }*/