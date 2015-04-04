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
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PantallaBienvenida extends JFrame implements ActionListener, KeyListener, Runnable {
    
    public static boolean N2=false;
    
    public static void main(String[] args){ 
        
         //Crea un nuevo objeto JFrameHolaMundo
        PantallaBienvenida holaMundo = new PantallaBienvenida();

        //Despliega la ventana en pantalla al hacerla visible
        holaMundo.setVisible(true);
        
        
        
    }
    
    public PantallaBienvenida(){
        super("El Misterio del Burro");
        setSize(600,600);
        setResizable(false);
        setLayout(new FlowLayout());
        JLabel jLbl=new JLabel("El Misterio del Burro");
        JButton btn1= new JButton("Iniciar");
        btn1.setActionCommand("b1");
        btn1.addActionListener(this);
        this.add(jLbl);
        add(btn1);
        addKeyListener(this);
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
        String BtnPress = e.getActionCommand();
        
            PantallaSeleccion HolaMundo2 = new PantallaSeleccion();
            HolaMundo2.setVisible(true);
            HolaMundo2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispatchEvent(new WindowEvent(this, 
                                                WindowEvent.WINDOW_CLOSING));
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


