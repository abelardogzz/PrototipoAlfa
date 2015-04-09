/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abelardo
 */

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaSeleccion extends JFrame implements ActionListener, KeyListener, Runnable {
    
    public static boolean N2=false;
    
    public static void main(String[] args){ 
        
         //Crea un nuevo objeto JFrameHolaMundo
        PantallaSeleccion holaMundo = new PantallaSeleccion();
        holaMundo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Despliega la ventana en pantalla al hacerla visible
        holaMundo.setVisible(true);
        
        holaMundo.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
              System.exit(0);
          }
     });
        
        
    }
    
    public PantallaSeleccion(){
        super("Pantalla de Seleccion");
        setSize(600,600);
        JPanel pnlPanel = new JPanel();
        pnlPanel.add(Box.createRigidArea(new Dimension(0,5)));
        add(pnlPanel);
        pnlPanel.setLayout(new BoxLayout(pnlPanel,BoxLayout.PAGE_AXIS));
        setResizable(false);
        JButton btn1= new JButton("Nueva Partida");
        JButton btn2= new JButton("Cargar Partida");
        btn1.setActionCommand("b1");
        btn2.setActionCommand("b2");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        pnlPanel.add(btn1);
        pnlPanel.add(btn2);
        addKeyListener(this);
        
        this.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
              System.exit(0);
          }
        });
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
        String sMensaje = e.getActionCommand();
            
            if (sMensaje=="b1"){
                System.out.println(sMensaje);
                Nivel1 HolaMundo2 = new Nivel1();
                HolaMundo2.setVisible(true);
                this.dispose();
                
            }
            else{
                SeleccionarArchivo selVentana = new SeleccionarArchivo();
                selVentana.setVisible(true);
                this.dispose();
            }
            
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    //Aqui se cambia de pantalla
    public void keyReleased(KeyEvent ke) {
       
     }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}


