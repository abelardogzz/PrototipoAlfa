
/**
 * Juego Examen parcial 1
 *
 * Chango que se mueve y colisiona con fantasmas(gana puntos)
 *y con niños(pierde vidas). Ademas guarda las posiciones(tecla G) y 
 * las vuelve a cargar (tecla C); mediante el uso de archivos
 *
 * 
 * @author Abelardo Gzz A01195884 y Luis Carlos F. A01196081
 * @version 1.0
 * @date 18/Feb/15
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.util.LinkedList;
import java.applet.AudioClip;
import java.net.URL;
import java.applet.Applet;


/**
 *
 * @author AntonioM
 */
public class Juego extends JFrame implements Runnable, KeyListener {

    private final int iMAXANCHO = 10; // maximo numero de personajes por ancho
    private final int iMAXALTO = 8;  // maxuimo numero de personajes por alto
    private Jugador jugJuan;
    private Jefe jefAlacran;
    //private Alacran alaAlacranLado;
    private Alacran alaAlacranArriba;
    private Serpiente serSerpiente;
    private Cactus catCactus;
    
    private Moneda objMoneda;
    //private Objeto objPowerUp;
    private Arma armArma;
    //private Objeto objRestVida;
    //private Objeto objVidaExtra;
    
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
    private LinkedList <Alacran>lklAlacran; //Lista Encadenada de fantasmas
    private LinkedList <Monstruo>lklMalos2; //Lista Encadenada de fantasmas
    
    /* objetos para manejar el buffer del Applet y este no parpadee */
    private Image    imaImagenApplet;   // Imagen a proyectar en Applet	
    private Graphics graGraficaApplet;  // Objeto grafico de la Image
    private SoundClip sdcSonidoChimpy;   // Objeto sonido de Chimpy
    private SoundClip sdcSonidoChimpy2;   // Objeto sonido de Chimpy
    
    private Vector vec; //Objeto vector para guardar los dats
    private String nombreArchivo; //Nombre del archivo
    
    /** 
     * init
     * 
     * Metodo sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se inizializan las variables o se crean los objetos
     * a usarse en el <code>Applet</code> y se definen funcionalidades.
     * 
     */
    public Juego() {
        // hago el applet de un tamaño 500,500
        setSize(800,600);
        
        //Carga los sonidos
        sdcSonidoChimpy = new SoundClip("aqui va un sonido");
        sdcSonidoChimpy2 = new SoundClip("aqui va otro sonido");
        
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
        //URL goURL = this.getClass().getResource("gameOver2.png");
        //imagameover = Toolkit.getDefaultToolkit().getImage(goURL);
        
        nombreArchivo = "DatosJuego.txt";
        vec = new Vector();
        
        // Declaras un hilo
        Thread th = new Thread (this);
        // Empieza el hilo
        th.start ();
        
        // defino la imagen de Juan
	URL urlImagenJuanLado = this.getClass().getResource("juanito.gif");
        URL urlImagenJuanArriba = this.getClass().getResource("Juan_arriba.png");
        URL urlImagenAlacranLado = this.getClass().getResource("alacran_lado.gif");
        URL urlImagenAlacranArriba = this.getClass().getResource("alacran_arriba.gif");
        URL urlImagenSerpiente = this.getClass().getResource("vibora.gif");
        URL urlImagenSerpienteAtk = this.getClass().getResource("vibora_atk.gif");
        URL urlImagenCactus = this.getClass().getResource("Cactus.png");
        
        // se crea el objeto para Juan 
        /* int iPosX = (iMAXANCHO - 1) * getWidth() / iMAXANCHO;
           int iPosY = (iMAXALTO - 10) * getHeight() / iMAXALTO;   */
        int iPosX = 400;
        int iPosY = 450;
            jugJuan = new Jugador(iPosX,iPosY, (getWidth() / iMAXANCHO)+50,
                    getHeight() / iMAXALTO,
                    Toolkit.getDefaultToolkit().getImage(urlImagenJuanLado), iVidas, iCantMunicion, iCantMoneda);
        
        /*// defino la imagen de la bala
	URL urlImagenBala = this.getClass().getResource("aqui va la imagen de la bala");
            // se crea el objeto para malo 
           // iPosX = (iMAXANCHO - 1) * getWidth() / iMAXANCHO;
            //iPosY = (iMAXALTO - 1) * getHeight() / iMAXALTO;        
        iPosY = iPosY - 200;
            objBala = new Objeto("Bala", iPosX,iPosY, getWidth() / iMAXANCHO,
                    getHeight() / iMAXALTO,
                    Toolkit.getDefaultToolkit().getImage(urlImagenBala));
            
	URL urlImagenPrincipal = this.getClass().getResource("ba.png");*/
        
        
        // creo la lista de animales
        lklAlacran = new LinkedList();
        // genero un numero azar de 3 a 8
        int iAzar = 5;
        
        // genero cada alacran y lo añado a la lista
        for(int iA = 1 ; iA < 5 ; iA++){
            for (int iI = 0; iI < iAzar; iI ++) {
                iPosY = (getHeight() /iMAXALTO) * iA ;    
                iPosX = (getWidth()/ iMAXANCHO) * (iI * 2) ;    
                // se crea el objeto Fantasmita
                Alacran alaAlacran = new Alacran(iPosX, iPosY, getWidth() / iMAXANCHO,
                    getHeight() / iMAXALTO,
                    Toolkit.getDefaultToolkit().getImage(urlImagenAlacranLado));
                //Se agrega el fantasma a la lista
                lklAlacran.add(alaAlacran);
            }
        }
    }
    
    public static void main(String[] args){
         //Crea un nuevo objeto JFrameHolaMundo
        Juego jueJuego = new Juego();
        jueJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Despliega la ventana en pantalla al hacerla visible
        jueJuego.setVisible(true);
    }	
    /** 
     * start
     * 
     * Metodo sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se crea e inicializa el hilo
     * para la animacion este metodo es llamado despues del init o 
     * cuando el usuario visita otra pagina y luego regresa a la pagina
     * en donde esta este <code>Applet</code>
     * 
     */
    /*public void start () {
        // Declaras un hilo
        Thread th = new Thread (this);
        // Empieza el hilo
        th.start ();
    }*/
	
    /** 
     * run
     * 
     * Metodo sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, que contendrá las instrucciones
     * de nuestro juego.
     * 
     */
    public void run () {
        
        /* mientras dure el juego, se actualizan posiciones de jugadores
           se checa si hubo colisiones para desaparecer jugadores o corregir
           movimientos y se vuelve a pintar todo
        */ 
        while (true) {
            if(!bCont){
                
                if(!bPausa){
                    actualiza();
                    checaColision();
                } 
                repaint();
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
    
    void reinicia(){
        //reinicia el paddle
        int iPosX = 600;
        int iPosY = 450;
            jugJuan.setX(iPosX);
            jugJuan.setY(iPosY);
        
        //reinicia  bala
        iPosY = iPosY - 200;
            //objBala.setX(iPosX);
            jugJuan.setY(iPosY);/////////////////////checar esto/////////////
        
        //Borra la lista encadenada
        lklAlacran.clear();
        URL urlImagenPrincipal = this.getClass().getResource("ba.png");
         // genero cada juanito y lo añado a la lista
        for(int iA = 1 ; iA < 5 ; iA++){
            for (int iI = 0; iI < 5; iI ++) {
                iPosY = (getHeight() /iMAXALTO) * iA ;    
                iPosX = (getWidth()/ iMAXANCHO) * (iI * 2) ;    
                // se crea el objeto Fantasmita
                Alacran alaAlacran = new Alacran(iPosX, iPosY, getWidth() / iMAXANCHO,
                    getHeight() / iMAXALTO,
                    Toolkit.getDefaultToolkit().getImage(urlImagenPrincipal));
                //Se agrega el fantasma a la lista
                //lklMalos.add(basPrincipal);
            }
        }
    }
	
    /** 
     * actualiza
     * 
     * Metodo que actualiza la posicion de los objetos 
     * 
     */
    public void actualiza(){
        switch(iDireccion){
            case 1:
                jugJuan.setY(jugJuan.getY()-5);
                break;
            case 2:
                jugJuan.setY(jugJuan.getY()+5);
                break;
            case 3:
                jugJuan.setX(jugJuan.getX()-5);
                break;
            case 4:
                jugJuan.setX(jugJuan.getX()+5);
                break;
        }
        
        /*switch(iDirBala){
            case 1:
                objBala.setX(objBala.getX()-3);
                break;
            case 2:
                objBala.setX(objBala.getX()+3);
                break;
        } */ 
    }
    
    /**
     * checaColision
     * 
     * Metodo usado para checar la colision entre objetos
     * 
     */
    public void checaColision(){
        //Checa que el paddle no se salga del frame
        if(jugJuan.getX()<0){
            jugJuan.setX(0);
        }
        if(jugJuan.getX() + jugJuan.getAncho() > getWidth()) { 
            // se fija la posicion en limite
            jugJuan.setX(getWidth() - jugJuan.getAncho());
        }
        
        if(iVidas == 0){
            
            bPausa = true;
        }            
    }
    
    public void leeArchivo() throws IOException {
                                                          
                BufferedReader fileIn;
                try {
                        fileIn = new BufferedReader(new FileReader(nombreArchivo));
                } catch (FileNotFoundException e){
                        File puntos = new File(nombreArchivo);
                        PrintWriter fileOut = new PrintWriter(puntos);
                        fileOut.println("100,demo");
                        fileOut.close();
                        fileIn = new BufferedReader(new FileReader(nombreArchivo));
                }
                String dato = fileIn.readLine();
                jugJuan.setX(Integer.parseInt(dato));
                dato = fileIn.readLine();
                jugJuan.setY(Integer.parseInt(dato));
                dato = fileIn.readLine();
                for(int i=0; i<lklAlacran.size(); i++){
                    lklAlacran.get(i).setX(Integer.parseInt(dato));
                    dato = fileIn.readLine();
                    lklAlacran.get(i).setY(Integer.parseInt(dato));
                    dato = fileIn.readLine();
                }
                for(int i=0; i<lklMalos2.size();i++){
                    lklMalos2.get(i).setX(Integer.parseInt(dato));
                    dato = fileIn.readLine();
                    lklMalos2.get(i).setY(Integer.parseInt(dato));
                    dato = fileIn.readLine();
                }
                fileIn.close();
    }
    
     public void grabaArchivo() throws IOException {
                                                          
                PrintWriter fileOut = new PrintWriter(new FileWriter(nombreArchivo));
                fileOut.println(jugJuan.getX());
                fileOut.println(jugJuan.getY());
                for(int i=0; i<lklAlacran.size();i++){
                    fileOut.println(lklAlacran.get(i).getX());
                    fileOut.println(lklAlacran.get(i).getY());
                }
                for(int i=0; i<lklMalos2.size();i++){
                    fileOut.println(lklMalos2.get(i).getX());
                    fileOut.println(lklMalos2.get(i).getY());
                }

                fileOut.close();
        }
	
    /**
     * update
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
        URL urlImagenFondo = this.getClass().getResource("BB_background2.png");
        Image imaImagenFondo = Toolkit.getDefaultToolkit().getImage(urlImagenFondo);
         graGraficaApplet.drawImage(imaImagenFondo, 0, 0, getWidth(), getHeight(), this);

        // Actualiza el Foreground.
        graGraficaApplet.setColor (getForeground());
        paint1(graGraficaApplet);

        // Dibuja la imagen actualizada
        graGrafico.drawImage (imaImagenApplet, 0, 0, this);
    }
    
    /**
     * paint
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
        //if(true){
            // si la imagen ya se cargo
            if (jugJuan != null) {
                if(!bFin){
                    //Dibuja la imagen de principal en el Applet
                    for (Alacran alaAlacran : lklAlacran) {
                        //Dibuja la imagen de dumbo en el Applet
                        alaAlacran.paint(graDibujo, this);
                    }
                    //Pinta malo
                    jugJuan.paint(graDibujo, this);
                    
                    graDibujo.setColor(Color.red);
                    graDibujo.setFont(new Font("Serif", Font.BOLD, 25));
                    graDibujo.drawString("Puntos: "+ iPuntos, 400 , 100);
                }else {
                    graDibujo.drawImage(imagameover, 150, 150, this);
                    graDibujo.setFont(new Font("Serif", Font.BOLD, 25));
                    graDibujo.drawString("Si deseas volver a jugar oprime tecla Y", 200 , 100);
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

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        // si presiono flecha a la izquierda
        if(keyEvent.getKeyCode() == KeyEvent.VK_A) {    
                iDireccion = 3;   // cambio la direccion a la izquierda
        }
        // si presiono flecha a la derecha
        else if(keyEvent.getKeyCode() == KeyEvent.VK_D){    
                iDireccion = 4;   // cambio la direccion a la derecha
        }
        
        if(keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE){
            bFin=true;
        }
        else if(keyEvent.getKeyCode() == KeyEvent.VK_W) {
            iDireccion = 1; //cambia la direccion hacia arriba
        }
        
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_P){
            if(!bPausa){
                bPausa=true;
            }
            else{
                bPausa=false;
            }
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_G){
            try{
                grabaArchivo();    //Graba el vector en el archivo.
            }catch(IOException e){
                System.out.println("Error en " + e.toString());
            }  
        }
        
        if(keyEvent.getKeyCode() == KeyEvent.VK_C){
            try{
                leeArchivo();    //lee el contenido del archivo
            }catch(IOException e){
                System.out.println("Error en " + e.toString());
            }  
        }
        
        if(keyEvent.getKeyCode() == KeyEvent.VK_A){
            iDireccion = 0;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_D){
            iDireccion = 0;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_W) {
            iDireccion = 0;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_Y){
            
                reinicia();
                bFin = false;
                      
            
        }
        
    }
}