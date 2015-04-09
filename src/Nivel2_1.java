import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
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
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abelardo
 */
public class Nivel2_1 extends JFrame implements Runnable,ActionListener,KeyListener{
    
    private final int iMAXANCHO = 10; // maximo numero de personajes por ancho
    private final int iMAXALTO = 8;  // maxuimo numero de personajes por alto
    private Jugador jugJuan;
    private Jefe jefAlacran;
    //private Alacran alaAlacranLado;
    private Alacran alaAlacranArriba;
    private Serpiente serSerpiente;
    private Cactus catCactus;
    private Powerup pw;
    private Moneda objMoneda;
    //private Objeto objPowerUp;
    //private Objeto objRestVida;
    //private Objeto objVidaExtra;
    private Image dbImage;    // Imagen a proyectar
    private int iCantMunicion;
    private int iCantMoneda;
    private int iDireccion; //Direccion de paddle
    private int iDirBala;  //Direccion bala
    private int iVidas; // Vidas del juego
    private int iPuntos; // Vidas del juego
    private Image imagameover; //Despliega imagen de fin de juego
    private boolean bFin;
    private boolean bPausa;
    private boolean bCont;
    private boolean bP2;
    long lbeforeTime; //long que me dira el tiempo del sistema
    private LinkedList <Alacran>lklAlacran; //Lista Encadenada de fantasmas
    private LinkedList <Lobo>lklLobo; //Lista Encadenada de fantasmas 
    private LinkedList <Powerup>lklVidas; //Lista Encadenada de fantasmas 
    
    /* objetos para manejar el buffer del Applet y este no parpadee */
    private Image    imaImagenApplet;   // Imagen a proyectar en Applet	
    private Graphics graGraficaApplet;  // Objeto grafico de la Image

    
    private Vector vec; //Objeto vector para guardar los dats
    private String nombreArchivo; //Nombre del archivo
    
    public Nivel2_1(){
        super("Nivel 2 ");
        setSize(800,600);
        setResizable(false);
        setLayout(new BorderLayout());
        /*
        JButton btn1= new JButton("Boton Prueba");
        btn1.addActionListener(this);
       
        JPanel jpn1 = new JPanel();
        jpn1.add(btn1);
        
        this.add(jpn1,BorderLayout.WEST);
        jpn1.setOpaque(false);
        */
        addKeyListener(this);
        
        iPuntos=0;
        iDireccion = 0;
        iDirBala = 1;
        iVidas= 4; /////////////////checar esto//////////////////////
        iCantMunicion = 6;
        iCantMoneda = 0;
        bFin= false;
        bPausa= false;
        bCont = false;
        bP2 = false;
        //URL goURL = this.getClass().getResource("gameOver2.png");
        //imagameover = Toolkit.getDefaultToolkit().getImage(goURL);
        
        nombreArchivo = "DatosJuego.txt";
        vec = new Vector();
        
        /* PARA NO CALIFICAR EL RUNNABLILTY
        // Declaras un hilo
        Thread th = new Thread (this);
        // Empieza el hilo
        th.start ();
        */
        
        // defino la imagen de Juan
	URL urlImagenJuanLado = this.getClass().getResource("recursos/Juan_arriba.png");
        URL urlImagenJuanArriba = this.getClass().getResource("recursos/Juan_arriba.png");
        URL urlImagenAlacranArriba = this.getClass().getResource("recursos/alacran_arriba.gif");
        URL urlImagenLobo = this.getClass().getResource("recursos/lobo_derecha.gif");
        URL urlImagenSerpiente = this.getClass().getResource("recursos/vibora.gif");
        URL urlImagenSerpienteAtk = this.getClass().getResource("recursos/vibora_atk.gif");
        URL urlImagenCactus = this.getClass().getResource("recursos/Cactus.png");
        URL urlImagenVida = this.getClass().getResource("recursos/heart.png");
        URL urlImagenRevolver = this.getClass().getResource("recursos/Revolver6.png");
        
        // se crea el objeto para Juan 
        /* int iPosX = (iMAXANCHO - 1) * getWidth() / iMAXANCHO;
           int iPosY = (iMAXALTO - 10) * getHeight() / iMAXALTO;   */
        int iPosX = 400;
        int iPosY = 450;
            jugJuan = new Jugador(382,440,150,150,
                    Toolkit.getDefaultToolkit().getImage(urlImagenJuanArriba), iVidas,iVidas, iCantMunicion, iCantMoneda);
        
        lklAlacran = new LinkedList();
        lklAlacran.add(new Alacran(381,200,50,50,Toolkit.getDefaultToolkit().getImage(urlImagenAlacranArriba)));
        lklAlacran.add((new Alacran(400,300,50,50,Toolkit.getDefaultToolkit().getImage(urlImagenAlacranArriba))));
        lklAlacran.add((new Alacran(704,400,50,50,Toolkit.getDefaultToolkit().getImage(urlImagenAlacranArriba))));
        //lklSerpiente.add((new Serpiente(650,500,50,50,Toolkit.getDefaultToolkit().getImage(urlImagenSerpiente))));
        
        lklLobo = new LinkedList();
        lklAlacran.add(new Alacran(218,390,50,50,Toolkit.getDefaultToolkit().getImage(urlImagenAlacranArriba)));
        lklAlacran.add(new Alacran(500,360,50,50,Toolkit.getDefaultToolkit().getImage(urlImagenAlacranArriba)));
        //lklLobo.add(new Lobo(704,430,110,50,Toolkit.getDefaultToolkit().getImage(urlImagenLobo)));
        
        lklVidas = new LinkedList();
        pw = new Powerup(62,98,100,100,
                Toolkit.getDefaultToolkit().getImage(urlImagenRevolver));
        
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

        
    }
    
    public static void main(String[] args){
         //Crea un nuevo objeto JFrameHolaMundo
        Nivel2_1 jueJuego = new Nivel2_1();
        jueJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Despliega la ventana en pantalla al hacerla visible
        jueJuego.setVisible(true);
    }

    
    public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(null, "No Funciona", "Hola", 0);
       // System.out.println("Funciona Hola Lalo");
    }

    
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
        
        //Actualiza la imagen de fondo.
        URL urlImagenFondo = this.getClass().getResource("recursos/Fondo2.jpg");
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
     * Metodo sobrescrito de la clase <code>Applet</code>,
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
                  
                    //Pinta malo
                    jugJuan.paint(graDibujo,this);
                    //graDibujo.drawImage(aniAnima.getImagen(),50,50,this);
                    graDibujo.setColor(Color.WHITE);
                    graDibujo.setFont(new Font("Serif", Font.BOLD, 25));
                    graDibujo.drawString("Nivel 2", 5 , 54);
                    graDibujo.setFont(new Font("Serif", Font.BOLD, 18));
                    graDibujo.drawString("Balas", 5 , 124);
                    
                    pw.paint(graDibujo,this);
                    
                    for (Alacran ala1 : lklAlacran) {
                        //Dibuja la imagen de dumbo en el Applet
                        ala1.paint(graDibujo, this);
                    }
                    for (Lobo lob1 : lklLobo) {
                        //Dibuja la imagen de dumbo en el Applet
                        lob1.paint(graDibujo, this);
                    }
                    for (Powerup pwerPower : lklVidas) {
                        pwerPower.paint(graDibujo, this);
                    }
             
            } // sino se ha cargado se dibuja un mensaje 
            else {
                    //Da un mensaje mientras se carga el dibujo	
                    graDibujo.drawString("No se cargo la imagen..", 20, 20);
            }
        /*}
        else{
            graDibujo.drawImage(imagameover, 150, 150, this);
            graDibujo.setFont(new Font("Serif", Font.BOLD, 25));
            graDibujo.drawString("SI deseas volver a jugar oprime tecla Y", 200 , 100);
        }*/
    }
    
    
    public void keyTyped(KeyEvent ke) {
        
    }

    
    public void keyPressed(KeyEvent ke) {
        
    }

    
    public void keyReleased(KeyEvent ke) {
        
    }
   
}
