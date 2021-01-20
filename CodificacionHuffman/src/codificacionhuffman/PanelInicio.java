/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codificacionhuffman;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import javax.swing.SwingConstants;

/**
 *
 * @author INKAB
 */
public class PanelInicio extends JFrame {
     private JButton [] botones;
     private JPanel panelBotones;
     private Container contenedor;
     private final Fichero fichero;
      Codificador codificadorHoffman;
    public PanelInicio() throws IOException, InterruptedException {
        super();
        codificadorHoffman = new Codificador();
        this.fichero = new Fichero();
        initComponents();
         addWindowListener(new WindowAdapter(){
          public void windowClosing(WindowEvent e){
              dispose();
              System.exit(0);
          } 
       });
    }
    private void initComponents() {
        contenedor = this.getContentPane();
        contenedor.setLayout( new BorderLayout() );
        
        iniciarBotones();
        this.setSize( 500, 300 );
        this.setVisible( true );
        this.setTitle("Codificador de Huffman");
        JLabel lblHola = new JLabel("CODIFICADOR DE HUFFMAN", SwingConstants.CENTER);
        JLabel lblInstrucciones=new JLabel("Instrucciones",SwingConstants.CENTER);
       
        this.setLayout(null);
        this.add( lblHola );
        this.add(lblInstrucciones);
        lblHola.setBounds( 50, 20, 350, 20 );
        lblInstrucciones.setBounds(50,50,350,20);
        this.add(panelBotones,BorderLayout.CENTER);
    }
    private class TomadorDeEvento implements ActionListener {
        private int queBoton;
        public TomadorDeEvento( int quien ) {
            queBoton = quien;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            
            System.out.println( queBoton );
            switch( queBoton ) {
                case 0:
                    try {
                        codificadorHoffman.calcularCodificacion();
                    } catch (Exception ex) {
                        Logger.getLogger(PanelInicio.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                break;
                case 1:
                   //codificadorHoffman.calcularDescompresor();
                
            }
    
        }

        
    }
    public void iniciarBotones(){
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2,2));
        botones = new JButton[2];
        botones[0] = new JButton( "Comprimir" );
        botones[1] = new JButton( "Descomprimir" );
        for( int n=0; n<botones.length; n++ ) {
            panelBotones.add( botones[n] );
            System.out.println("se agrega");
            botones[n].addActionListener( new TomadorDeEvento( n ) );
            }
       contenedor.add( panelBotones, BorderLayout.WEST );
    }
}
