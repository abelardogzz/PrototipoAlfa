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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class SeleccionarArchivo extends JFrame implements ActionListener, KeyListener, Runnable {
    
    public static boolean N2=false;
    
    public static void main(String[] args){ 
        
         //Crea un nuevo objeto JFrameHolaMundo
        SeleccionarArchivo holaMundo = new SeleccionarArchivo();
        holaMundo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Despliega la ventana en pantalla al hacerla visible
        holaMundo.setVisible(true);
        
        
        
    }
    
    public SeleccionarArchivo(){
        super("Seleccionar Archivo");
        setSize(600,600);
        setResizable(false);
        setLayout(new FlowLayout());
        JLabel jLbl=new JLabel("Cargar Partida");
        JButton btn1= new JButton("Archivo 1");
        JButton btn2= new JButton("Archivo 2");
        JButton btn3= new JButton("Archivo 3");
        btn1.setActionCommand("b1");
        btn2.setActionCommand("b2");
        btn3.setActionCommand("b3");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        this.add(jLbl);
        add(btn1);
        add(btn2);
        add(btn3);
        addKeyListener(this);
        
        this.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
              System.exit(0);
          }
        });
        
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
        String BtnPress = e.getActionCommand();
        
         
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}


