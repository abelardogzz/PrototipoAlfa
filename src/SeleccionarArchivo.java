/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abelardo
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
        JPanel pnlPanel = new JPanel();
        pnlPanel.add(Box.createRigidArea(new Dimension(0,5)));
        add(pnlPanel);
        pnlPanel.setLayout(new BoxLayout(pnlPanel,BoxLayout.PAGE_AXIS));
        setLayout(new BorderLayout());
        JLabel jLbl=new JLabel("Cargar Partida");
        JButton btn1= new JButton("Archivo 1");
        JButton btn2= new JButton("Archivo 2");
        JButton btn3= new JButton("Archivo 3");
        JButton btnRegresar= new JButton("Regresar");
        btn1.setActionCommand("b1");
        btn2.setActionCommand("b2");
        btn3.setActionCommand("b3");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btnRegresar.addActionListener(this);
        pnlPanel.add(jLbl);
        pnlPanel.add(btn1);
        pnlPanel.add(btn2);
        pnlPanel.add(btn3);
        
        this.add(pnlPanel,BorderLayout.CENTER);
        this.add(btnRegresar,BorderLayout.SOUTH);
        
        addKeyListener(this);
        
        this.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
              System.exit(0);
          }
        });
        
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
        String BtnPress = e.getActionCommand();
        
        if (BtnPress == "Regresar"){
            PantallaSeleccion pantSel = new PantallaSeleccion();
            pantSel.setVisible(true);
            this.dispose();
        }
        
         
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
    
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void run() {
    
    }

    
}


