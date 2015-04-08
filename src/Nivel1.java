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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abelardo
 */
public class Nivel1 extends JFrame implements ActionListener, KeyListener, Runnable {
    
    public static boolean N2=false;
    
    public static void main(String[] args){ 
        
         //Crea un nuevo objeto JFrameHolaMundo
        Nivel1 holaMundo = new Nivel1();
        //Despliega la ventana en pantalla al hacerla visible
        holaMundo.setVisible(true);
        
        holaMundo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Despliega la ventana en pantalla al hacerla visible
        holaMundo.setVisible(true);
        
        holaMundo.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
              System.exit(0);
          }
     });
        
        
        
    }
    
    public Nivel1(){
        super("Nivel 1");
        setSize(800,600);
        setResizable(false);
        setLayout(new FlowLayout());
        
        JButton btn1= new JButton("Prueba");
        btn1.setActionCommand("b1");
        btn1.addActionListener(this);
        add(btn1);
        addKeyListener(this);
        
        this.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
              System.exit(0);
          }
        });
        
    }
    
    
    
    
    public void actionPerformed(ActionEvent e) {
        String BtnPress = e.getActionCommand();
        

        

            Nivel2 HolaMundo2 = new Nivel2();
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


