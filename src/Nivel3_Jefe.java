import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.net.URL;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abelardo
 */
public class Nivel3_Jefe extends JFrame implements ActionListener, KeyListener, Runnable {
    
    private Jugador jugJuan;    //objeto Jugador
    private Jefe jefFinal;  //objeto Jefe
    private Moneda objMoneda;   //objeto Moneda
    private Objeto objRestVida; //objeto Objeto
    private Objeto objVidaExtra;    //objeto Objeto
    private Image dbImage;    // Imagen a proyectar
    private int iCantMunicion;  //cantidad de municiones
    private int iCantMoneda;    //cantidad de monedas
    private int iVidas; // Vidas del juego
    private int iDireccion;
    private boolean bFin;
    private boolean bPausa;
    private boolean bCont;
    private boolean bP2;
    private boolean bMov;
    long lbeforeTime; //long que me dira el tiempo del sistema
    private LinkedList <Powerup>lklVidas; //Lista Encadena de Vidas del Jugador
    /* objetos para manejar el buffer del Applet y este no parpadee */
    private Image    imaImagenApplet;   // Imagen a proyectar en Applet	
    private Graphics graGraficaApplet;  // Objeto grafico de la Image
    private Vector vec; //Objeto vector para guardar los dats
    private String nombreArchivo; //Nombre del archivo
    public static boolean N2=false;
    
    /**
     * main
     * 
     * Metodo usado para crear el nivel jefe del juego
     * y haciendolo visible al usaurio.
     * 
     */
    
    public static void main(String[] args){ 
        
         //Crea un nuevo objeto nvlNivel3_Jefe
        Nivel3_Jefe nvlNivel3Jefe = new Nivel3_Jefe();
        //Despliega la ventana en pantalla al hacerla visible
        nvlNivel3Jefe.setVisible(true);
        
        nvlNivel3Jefe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Despliega la ventana en pantalla al hacerla visible
        nvlNivel3Jefe.setVisible(true);
        
        //Para que se pueda cerrar la pantalla
        nvlNivel3Jefe.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
              System.exit(0);
          }
        });
 
    }
    
    /**
     * Nivel3_Jefe
     * 
     * Metodo constructor usado para crear el nivel jefe del juego
     * con sprites y escenarios.
     * 
     */
    
    public Nivel3_Jefe(){
        //Aqui se establece lo basico del JFrame
        super("Nivel 3 - Jefe");
        setSize(800,600);
        setResizable(false);
        setLayout(new FlowLayout());
        
        //Defino variables de juego
        iVidas= 4; 
        iCantMunicion = 6;
        iCantMoneda = 0;
        iDireccion = 0;
        bFin= false;
        bPausa= false;
        bCont = false;
        bP2 = false;
        bMov = false;
        //URL goURL = this.getClass().getResource("gameOver2.png");
        //imagameover = Toolkit.getDefaultToolkit().getImage(goURL);
        
        nombreArchivo = "DatosJuego.txt";
        vec = new Vector();
   
        
        // defino las imagenes que usare
	URL urlImagenJuanLado = this.getClass().getResource("recursos/juanito.gif");
        URL urlImagenJuanStatic = this.getClass().getResource("recursos/juanito_static.gif");
        URL urlImagenJuanArriba = this.getClass().getResource("recursos/Juan_arriba.png");
        URL urlImagenJefeFinal = this.getClass().getResource("recursos/jefe_final.png");
        URL urlImagenVida = this.getClass().getResource("recursos/heart.png");
        
        
        //A continuacion se ponen los objetos de esta pantalla
        jugJuan = new Jugador(0,467,100,
                    100,
                    Toolkit.getDefaultToolkit().getImage(urlImagenJuanLado), iVidas,
                iVidas, iCantMunicion, iCantMoneda);
        
        jefFinal = new Jefe(681,457,70,120,
                Toolkit.getDefaultToolkit().getImage(urlImagenJefeFinal), 2);
        
        lklVidas = new LinkedList();
        
        //Las vidas del jugador
        for (int i=0;i<4;i++){
            Powerup pwrVida = new Powerup(5+i*50,64,50,50,
                Toolkit.getDefaultToolkit().getImage(urlImagenVida));
            lklVidas.add(pwrVida);
        }
        //Este metodo se utiliza para que se cierre la ventana una vez que se est
         //coriendo el juego
        this.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
              System.exit(0);
          }
        });

        addKeyListener(this);
  
    }

    
    public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(null, "No Funciona", "Hola", 0);
       // System.out.println("Funciona Hola Lalo");
    }

    /**
     * run
     * 
     * Metodo usado para correr el nivel jefe del juego.
     * 
     * 
     */
    
    public void run () {
        lbeforeTime = System.currentTimeMillis();
        /* mientras dure el juego, se actualizan posiciones de jugadores
           se checa si hubo colisiones para desaparecer jugadores o corregir
           movimientos y se vuelve a pintar todo
        */ 
        while (true) {
            
            if(!bCont){
                
                if(!bPausa){
                    repaint();
                    actualiza();
                    checaColision();
                } 
                
            }
            
            try	{
                // El thread se duerme.
                Thread.sleep (20);
            }
            catch (InterruptedException iexError) {
                System.out.println("Hubo un error en el juego " + 
                        iexError.toString());
            }
	}
    }
    
    public void actualiza(){
    //Dependiendo de la direccion del elefante es hacia donde se mueve.
        if (bMov){
            switch(iDireccion) {
                    case 1: {
                        jugJuan.setX(jugJuan.getX() - 1);
                        break;    //se mueve hacia la izquierda
                    }
                    case 2: {
                        jugJuan.setX(jugJuan.getX() + 1); 
                        break;    //se mueve hacia la derecha
                    }
            }
        }
    }
    
    public void checaColision(){
                
    }
    
   /**
     * paint
     * 
     * Metodo sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo lo que hace es actualizar el contenedor y 
     * define cuando usar ahora el paint
     * 
     * @param graGrafico es el <code>objeto grafico</code> usado para dibujar.
     * 
     */
    public void paint (Graphics graGrafico){
    // Inicializan el DoubleBuffer
        if (imaImagenApplet == null){
                imaImagenApplet = createImage (this.getSize().width, 
                        this.getSize().height);
                graGraficaApplet = imaImagenApplet.getGraphics ();
        }
        // Actualiza la imagen de fondo.
		graGraficaApplet.setColor (getBackground ());
		graGraficaApplet.fillRect (0, 0, this.getSize().width, this.getSize().height);
        
   
        URL urlImagenFondo = this.getClass().getResource("recursos/fondo_jefe.png");
        Image imaImagenFondo = Toolkit.getDefaultToolkit().getImage(urlImagenFondo);
        graGraficaApplet.drawImage(imaImagenFondo, 0, 0, getWidth(), getHeight(), this);
        
        
        // Actualiza el Foreground.
        graGraficaApplet.setColor (getForeground());
        paint1(graGraficaApplet);

        // Dibuja la imagen actualizada
        graGrafico.drawImage (imaImagenApplet, 0, 0, this);
    }
    
    /**
     * paint1
     * 
     * Metodo sobreescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo se dibuja la imagen con la posicion actualizada,
     * ademas que cuando la imagen es cargada te despliega una advertencia.
     * 
     * @param graDibujo es el objeto de <code>Graphics</code> usado para dibujar.
     * 
     */
    public void paint1(Graphics graDibujo) {
        graDibujo.fillRect(0, 0, WIDTH, HEIGHT);
            if (jugJuan != null) {
                
                    //Dibuja la imagen de principal en el Applet
                  
                    //Pinta a Juan y al jefe final
                    jugJuan.paint(graDibujo,this);
                    jefFinal.paint(graDibujo,this);
                    
                    //se dibuja la informacion del nivel
                    graDibujo.setColor(Color.WHITE);
                    graDibujo.setFont(new Font("Serif", Font.BOLD, 25));
                    graDibujo.drawString("Nivel 3 - Jefe ", 5 , 54);
                    graDibujo.setFont(new Font("Serif", Font.BOLD, 18));
                    graDibujo.drawString("Balas", 5 , 124);
                    
                    //se pintan las vidas
                    for (Powerup pwerPower : lklVidas) {
                        pwerPower.paint(graDibujo, this);
                    }
             
            } // sino se ha cargado se dibuja un mensaje 
            else {
                    //Da un mensaje mientras se carga el dibujo	
                    graDibujo.drawString("No se cargo la imagen..", 20, 20);
            }
 
    }
    
    
    public void keyTyped(KeyEvent ke) {
        
    }

    
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            bMov = true;
            iDireccion = 2;
        }
        if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
            bMov = true;
            iDireccion = 1;
        }
    }

    //Aqui se cambia de pantalla
    public void keyReleased(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            bMov = false;
        }
        if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
            bMov = false;
        }
        /*
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
            
            System.exit(0);
        }*/
    }
}