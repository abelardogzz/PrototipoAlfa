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
import java.util.Random;
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
public class Nivel3_1 extends JFrame implements ActionListener, KeyListener, Runnable {
    
    private Jugador jugJuan;    //objeto Jugador
    private Cholo chlCholo; //objeto Cholo
    private Cholo chlCholo2;    //objeto Cholo
    private Moneda objMoneda;   //objeto Moneda
    private Objeto objRestVida; //objeto Objeto
    private Objeto objVidaExtra;    //objeto Objeto
    private Image dbImage;    // Imagen a proyectar
    private int iCantMunicion;  //cantidad de municiones
    private int iCantMoneda;    //cantidad de monedas
    private int iVidas; // Vidas del juego
    private Powerup pw; //objeto Powerup
    private boolean bFin;
    private boolean bPausa;
    private boolean bCont;
    private boolean bP2;
    long lbeforeTime; //long que me dira el tiempo del sistema
    private LinkedList <Powerup>lklVidas; //Lista Encadena de Vidas del Jugador
    private LinkedList <Cholo>lklCholos;//Lista Encadena de Cholos
    /* objetos para manejar el buffer del Applet y este no parpadee */
    private Image    imaImagenApplet;   // Imagen a proyectar en Applet	
    private Graphics graGraficaApplet;  // Objeto grafico de la Image
    private Vector vec; //Objeto vector para guardar los dats
    private String nombreArchivo; //Nombre del archivo
    public static boolean N2=false;
    
    public static void main(String[] args){ 
        
         //Crea un nuevo objeto nvlNivel3_1
        Nivel3_1 nvlNivel3_1 = new Nivel3_1();
        //Despliega la ventana en pantalla al hacerla visible
        nvlNivel3_1.setVisible(true);
        
        nvlNivel3_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Despliega la ventana en pantalla al hacerla visible
        nvlNivel3_1.setVisible(true);
        
        //Para que se pueda cerrar la pantalla
        nvlNivel3_1.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
              System.exit(0);
          }
        });
 
    }
    
    /**
     * Nivel3_1
     * 
     * Metodo constructor usado para crear el nivel del juego
     * con sprites y escenarios.
     * 
     */
    
    public Nivel3_1(){
        //Aqui se establece lo basico del JFrame
        super("Nivel 3 - 1");
        setSize(800,600);
        setResizable(false);
        setLayout(new FlowLayout());
        
        //Defino variables de juego
        iVidas= 4; 
        iCantMunicion = 6;
        iCantMoneda = 0;
        bFin= false;
        bPausa= false;
        bCont = false;
        bP2 = false;
        //URL goURL = this.getClass().getResource("gameOver2.png");
        //imagameover = Toolkit.getDefaultToolkit().getImage(goURL);
        
        //de define archivo en donde se guardan y cargan datos
        nombreArchivo = "DatosJuego.txt";
        vec = new Vector();
   
        
        // defino las imagenes que usare
	URL urlImagenJuanLado = this.getClass().getResource("recursos/juanito.gif");
        URL urlImagenJuanArriba = this.getClass().getResource("recursos/Juan_arriba.png");
        URL urlImagenCholo = this.getClass().getResource("recursos/cholo.gif");
        URL urlImagenVida = this.getClass().getResource("recursos/heart.png");
        URL urlImagenRevolver = this.getClass().getResource("recursos/Revolver6.png");
        
        //A continuacion se ponen los objetos de esta pantalla
        jugJuan = new Jugador(382,440,150,
                    150,
                    Toolkit.getDefaultToolkit().getImage(urlImagenJuanArriba), iVidas,
                iVidas, iCantMunicion, iCantMoneda);
        
        pw = new Powerup(62,98,100,100,
                Toolkit.getDefaultToolkit().getImage(urlImagenRevolver));
        
        lklVidas = new LinkedList();
        lklCholos = new LinkedList();
        
        //Las vidas del jugador
        for (int i=0;i<4;i++){
            Powerup pwrVida = new Powerup(5+i*50,64,50,50,
                Toolkit.getDefaultToolkit().getImage(urlImagenVida));
            lklVidas.add(pwrVida);
        }
        
        //Los cholos
        for (int i=0;i<6;i++){
           Random randR = new Random();
           Cholo chlCholos = new Cholo((i+3)*65, randR.nextInt((200 - 65) + 1) + 65,55,70,
                Toolkit.getDefaultToolkit().getImage(urlImagenCholo));
           lklCholos.add(chlCholos);
        
        }
        
        //Este metodo se utiliza para que se cierre la ventana una vez que se este
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
     * Metodo usado para correr el nivel 3-1 del juego.
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
        
   
        URL urlImagenFondo = this.getClass().getResource("recursos/fondo3.png");
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
                  
                    //Pinta a Juan y sus balas
                    jugJuan.paint(graDibujo,this);
                    pw.paint(graDibujo,this);
                    
                    //se pinta la informacion del nivel
                    graDibujo.setColor(Color.WHITE);
                    graDibujo.setFont(new Font("Serif", Font.BOLD, 25));
                    graDibujo.drawString("Nivel 3 - 1 ", 5 , 54);
                    graDibujo.setFont(new Font("Serif", Font.BOLD, 18));
                    graDibujo.drawString("Balas", 5 , 124);
                    
                    //se pintan las vidas
                    for (Powerup pwerPower : lklVidas) {
                        pwerPower.paint(graDibujo, this);
                    }
                    
                    //se pintan los cholos
                    for (Cholo chlCholos : lklCholos) {
                        chlCholos.paint(graDibujo, this);
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
        
    }

    /**
     * keyReleased
     * 
     * Metodo usado para cambiar de nivel si se oprime la tecla indicada.
     * 
     * 
     */
    
    public void keyReleased(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
            Nivel3_Jefe nvlNivel = new Nivel3_Jefe();
            nvlNivel.setVisible(true);
            this.dispose();
        }
    }
}