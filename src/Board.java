/**
 * Juego SpaceInvaders
 *
 * Destruye a los arrAlien con una nave que dispara una bomba
 * y evita ser golpeado por las bombas de los arrAlien. 
 * 
 *
 * 
 * @author Abelardo Gzz A01195884 y Luis Carlos F. A01196081
 * @version 2.0
 * @date 4/Marzo/15
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

    /** 
     * Board
     * 
     * En este metodo se inizializan las variables o se crean los objetos
     * a usarse en el <code>Applet</code> ,se definen funcionalidades y 
     * se especifican las implementaciones de las variables.
     * 
     */
public class Board extends JPanel implements Runnable, Commons { 

    private Dimension dDimension;   //objeto Dimension
    private ArrayList arrAlien;     //arreglo de arrAlien
    private Player plyPlayer;       //objeto Player
    private Shot shtShot;           //objeto Shot

    //se inicaliza la posicion de los aliens
    private int iAlienX = 150;
    private int iAlienY = 5;
    //se inicializa la direccion de los aliens
    private int iDirection = -1;
    //se inicializa los aliens destruidos
    private int iDeaths = 0;

    //se inicializa a boleana para cuando el juego este activo
    private boolean bIngame = false;
    //se inicializa las imagenes de los objetos
    private final String sExplosion = "explosion.png";    
    private final String sAlien = "alien.png";
    private String sMessage = "Game Over";
    private String nombreArchivo; //Nombre del archivo
    
    //se incializan variabes para la clase Animacion
    private Animacion aniExplosion;
    private Animacion aniAlien;
    private long tiempoActual;
    private long tiempoInicial;

    private Thread animator;
    
    //se inicializan variable para manejar la pausa, los creditos y las
    //instrucciones del juego
    private boolean bPausa;
    private boolean bCreditos;
    private boolean bInstru;
    
    //se inicializan las instrucciones y los creditos del juego
    private String sMenInstrucciones = "Te mueves con la flechas direccionales, disparas con ALT";
    private String sMenCreditos = "Autores: Abelardo Gzz y Luis Carlos F.";
    
    
    
    public Board() 
    {

        addKeyListener(new TAdapter());
        setFocusable(true);
        //inicializa las dimensiones del Applet
        dDimension = new Dimension(BOARD_WIDTH, BOARD_HEIGTH);
        setBackground(Color.black); //pone el fondo de color negro

        gameInit();
        setDoubleBuffered(true);
    }

    public void actualiza(){
        //Determina el tiempo que ha transcurrido desde que el Applet 
        //inicio su ejecución
        long tiempoTranscurrido=System.currentTimeMillis() - tiempoActual;
        //Guarda el tiempo actual
        tiempoActual += tiempoTranscurrido;
        //Actualiza la animación en base al tiempo transcurrido
        aniExplosion.actualiza(tiempoTranscurrido);
        aniAlien.actualiza(tiempoTranscurrido);
    }
    
    public void addNotify() {
        super.addNotify();
        gameInit();
    }

    public void gameInit() {
        //inicializa la lista de aliens
        arrAlien = new ArrayList();
        //inicializa la imagen a los aliens
        ImageIcon ii = new ImageIcon(this.getClass().getResource(sAlien));

        for (int i=0; i < 4; i++) {
            for (int j=0; j < 6; j++) {
                Alien aliAlien = new Alien(iAlienX + 18*j, iAlienY + 18*i);
                aliAlien.setImage(ii.getImage());
                arrAlien.add(aliAlien);
            }
        }
        
        //se da el nombre del archivo donde se guardaran y leeran los datos
        nombreArchivo = "DatosJuego.txt";

        plyPlayer = new Player();
        shtShot = new Shot();

        if (animator == null || !bIngame) {
            animator = new Thread(this);
            animator.start();
        }
        
        //se dan valores a las variables de pausa, creditos e instrucciones
        bPausa = false;
        bCreditos = false;
        bInstru = false;
        
        //se crea la animacion para la explosion
        Image imgExplosion1 = Toolkit.getDefaultToolkit().getImage(
                        this.getClass().getResource("explosion1.png"));
        Image imgExplosion2 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("explosion2.png"));
        Image imgExplosion3 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("explosion3.png"));
        Image imgExplosion4 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("explosion4.png"));
        Image imgExplosion5 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("explosion5.png"));
        Image imgExplosion6 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("explosion6.png"));
        Image imgExplosion7 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("explosion7.png"));
        Image imgExplosion8 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("explosion8.png"));
        Image imgExplosion9 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("explosion9.png"));
        Image imgExplosion10 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("explosion10.png"));
        Image imgExplosion11 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("explosion11.png"));
        Image imgExplosion12 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("explosion12.png"));
        Image imgExplosion13 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("explosion13.png"));

        aniExplosion = new Animacion();
        aniExplosion.sumaCuadro(imgExplosion1, 100);
        aniExplosion.sumaCuadro(imgExplosion2, 100);
        aniExplosion.sumaCuadro(imgExplosion3, 100);
        aniExplosion.sumaCuadro(imgExplosion4, 100);
        aniExplosion.sumaCuadro(imgExplosion5, 100);
        aniExplosion.sumaCuadro(imgExplosion6, 100);
        aniExplosion.sumaCuadro(imgExplosion7, 100);
        aniExplosion.sumaCuadro(imgExplosion8, 100);
        aniExplosion.sumaCuadro(imgExplosion9, 100);
        aniExplosion.sumaCuadro(imgExplosion10, 100);
        aniExplosion.sumaCuadro(imgExplosion11, 100);
        aniExplosion.sumaCuadro(imgExplosion12, 100);
        aniExplosion.sumaCuadro(imgExplosion13, 100);
        
        /*//se crea la animacion para los aliens
        Image imgAlien1 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("alien.png"));
        Image imgAlien2 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("alien2.png"));
        
        aliAlien = new Animacion();
        aliAlien.sumaCuadro(imgAlien1, 100);
        aliAlien.sumaCuadro(imgAlien2, 100);*/
        
        
    }
    //se dibujan los aliens
    public void drawAliens(Graphics graDibujo) 
    {
        Iterator it = arrAlien.iterator();

        while (it.hasNext()) {
            Alien aliAlien = (Alien) it.next();

            if (aliAlien.isVisible()) {
                graDibujo.drawImage(aliAlien.getImage(), aliAlien.getX(), aliAlien.getY(), this);
            }

            if (aliAlien.isDying()) {
                aliAlien.die();
            }
        }
    }
    //se dibuja a la nave del jugador
    public void drawPlayer(Graphics graDibujo) {

        if (plyPlayer.isVisible()) {
            graDibujo.drawImage(plyPlayer.getImage(), plyPlayer.getX(), plyPlayer.getY(), this);
        }

        if (plyPlayer.isDying()) {
            plyPlayer.die();
            bIngame = false;
        }
    }
    //se dibuja el proyectil de la nave
    public void drawShot(Graphics graDibujo) {
        if (shtShot.isVisible())
            graDibujo.drawImage(shtShot.getImage(), shtShot.getX(), shtShot.getY(), this);
    }
    //se dibujan las bombas de los aliens
    public void drawBombing(Graphics graDibujo) {

        Iterator i3 = arrAlien.iterator();

        while (i3.hasNext()) {
            Alien aliA = (Alien) i3.next();

            Alien.Bomb bmbB = aliA.getBomb();

            if (!bmbB.isDestroyed()) {
                graDibujo.drawImage(bmbB.getImage(), bmbB.getX(), bmbB.getY(), this); 
            }
        }
    }

    public void paint(Graphics graG)
    {
      super.paint(graG);

      //dibuja el fondo del juego en color negro
      graG.setColor(Color.black);
      //dibuja una linea recta de color verde
      graG.fillRect(0, 0, dDimension.width, dDimension.height);
      graG.setColor(Color.green);   

      //mientras estas en el juego
      if (bIngame) {

        //dibuja la linea en el suelo de la Applet
        graG.drawLine(0, GROUND, BOARD_WIDTH, GROUND);
        drawAliens(graG);
        drawPlayer(graG);
        drawShot(graG);
        drawBombing(graG);
      }

      Toolkit.getDefaultToolkit().sync();
      graG.dispose();
    }
    //metodo que cambia el fondo cuando se termina el juego
    public void gameOver()
    {

        Graphics g = this.getGraphics();

        //cambia el fondo del juego a negro
        g.setColor(Color.black);
        g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGTH);

        //dibuja un cuadro en donde se desplegara un mensaje
        g.setColor(new Color(0, 32, 48));
        g.fillRect(50, BOARD_WIDTH/2 - 30, BOARD_WIDTH-100, 50);
        g.setColor(Color.white);
        g.drawRect(50, BOARD_WIDTH/2 - 30, BOARD_WIDTH-100, 50);

        //establece el estilo de letra en Helvetica Bold
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);
        
        //despliega el mensaje "Game Over" en el centro de la pantalla
        //en color blanco
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(sMessage, (BOARD_WIDTH - metr.stringWidth(sMessage))/2, 
            BOARD_WIDTH/2);
    }

    //metodo que despliega los creditos del juego
    public void Creditos()
    {
        Graphics g = this.getGraphics();

        g.setColor(Color.gray); //Pone color blanco de fondo
        g.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGTH);//Rellena el cuadro
        
        g.setColor(new Color(11, 2, 94));//Pone color azul obsucro
        Font small = new Font("Helvetica", Font.BOLD, 14);//establece tipo de font
        FontMetrics metr = this.getFontMetrics(small); //Tipo tamaño del font

        g.setFont(small);
        g.drawString(sMenCreditos, (BOARD_WIDTH - metr.stringWidth(sMenCreditos))/2, 
            BOARD_WIDTH/2);
    }
    
    //metodo que despliega las instrucciones del juego
    public void Instrucciones()
    {
        Graphics graGraphic = this.getGraphics();

        graGraphic.setColor(Color.black); //Pone color blanco de fondo
        graGraphic.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGTH);//Rellena el cuadro
        
        graGraphic.setColor(new Color(211, 233, 244));//Pone color azul obsucro
        Font small = new Font("Helvetica", Font.BOLD, 14);//establece tipo de font
        FontMetrics metr = this.getFontMetrics(small); //Tipo tamaño del font

        graGraphic.setFont(small);
        graGraphic.drawString(sMenInstrucciones, (BOARD_WIDTH - metr.stringWidth(sMenInstrucciones))/2, 
            BOARD_WIDTH/2);
    }
    
    public void animationCycle()  { //actualiza

        //si se destruyeron todos los aliens
        if (iDeaths == NUMBER_OF_ALIENS_TO_DESTROY) {
            bIngame = false;
            sMessage = "Game won!";
        }

        plyPlayer.act();

        // shtShot
        if (shtShot.isVisible()) {
            Iterator it = arrAlien.iterator();
            int shtShotX = shtShot.getX();
            int shtShotY = shtShot.getY();

            while (it.hasNext()) {
                Alien aliAlien = (Alien) it.next();
                int iAlienX = aliAlien.getX();
                int iAlienY = aliAlien.getY();

                if (aliAlien.isVisible() && shtShot.isVisible()) {
                    if (shtShotX >= (iAlienX) && 
                        shtShotX <= (iAlienX + ALIEN_WIDTH) &&
                        shtShotY >= (iAlienY) &&
                        shtShotY <= (iAlienY+ALIEN_HEIGHT) ) {
                            ImageIcon ii = 
                                new ImageIcon(getClass().getResource(sExplosion));
                            aliAlien.setImage(ii.getImage());
                            aliAlien.setDying(true);
                            iDeaths++;
                            shtShot.die();
                        }
                }
            }

            int y = shtShot.getY();
            y -= 4;
            if (y < 0)
                shtShot.die();
            else shtShot.setY(y);
        }

        //arrAliens
         Iterator it1 = arrAlien.iterator();

         while (it1.hasNext()) {
             Alien a1 = (Alien) it1.next();
             int x = a1.getX();

             if (x  >= BOARD_WIDTH - BORDER_RIGHT && iDirection != -1) {
                 iDirection = -1;
                 Iterator i1 = arrAlien.iterator();
                 while (i1.hasNext()) {
                     Alien a2 = (Alien) i1.next();
                     a2.setY(a2.getY() + GO_DOWN);
                 }
             }

            if (x <= BORDER_LEFT && iDirection != 1) {
                iDirection = 1;

                Iterator i2 = arrAlien.iterator();
                while (i2.hasNext()) {
                    Alien a = (Alien)i2.next();
                    a.setY(a.getY() + GO_DOWN);
                }
            }
        }


        Iterator it = arrAlien.iterator();

        while (it.hasNext()) {
            Alien alien = (Alien) it.next();
            if (alien.isVisible()) {

                int y = alien.getY();

                //si los aliens alcanzan el suelo
                if (y > GROUND - ALIEN_HEIGHT) {
                    bIngame = false;
                    sMessage = "Invasion!";
                }

                alien.act(iDirection);
            }
        }

        //se asignan posiciones a los proyectiles de los aliens
        Iterator i3 = arrAlien.iterator();
        Random generator = new Random();

        while (i3.hasNext()) {
            int shtShot = generator.nextInt(15);
            Alien a = (Alien) i3.next();
            Alien.Bomb b = a.getBomb();
            if (shtShot == CHANCE && a.isVisible() && b.isDestroyed()) {

                b.setDestroyed(false);
                b.setX(a.getX());
                b.setY(a.getY());   
            }

            int bombX = b.getX();
            int bombY = b.getY();
            int plyPlayerX = plyPlayer.getX();
            int plyPlayerY = plyPlayer.getY();

            if (plyPlayer.isVisible() && !b.isDestroyed()) {
                if ( bombX >= (plyPlayerX) && 
                    bombX <= (plyPlayerX+PLAYER_WIDTH) &&
                    bombY >= (plyPlayerY) && 
                    bombY <= (plyPlayerY+PLAYER_HEIGHT) ) {
                        ImageIcon ii = 
                            new ImageIcon(this.getClass().getResource(sExplosion));
                        plyPlayer.setImage(ii.getImage());
                        plyPlayer.setDying(true);
                        b.setDestroyed(true);;
                    }
            }

            if (!b.isDestroyed()) {
                b.setY(b.getY() + 1);   
                if (b.getY() >= GROUND - BOMB_HEIGHT) {
                    b.setDestroyed(true);
                }
            }
        }
    }

    public void run() {
        tiempoActual = System.currentTimeMillis();

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (bIngame) {
            //si se apaga la boleana
            if (!bPausa) {
                animationCycle();
            }
            //si se prende la boleana
            if (bCreditos) {
                Creditos();
            }
            //si se prende la boleana
            else if (bInstru) {
                Instrucciones();
            }
            else {
                repaint();
            }

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0) 
                sleep = 2;
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
            beforeTime = System.currentTimeMillis();
        }
        gameOver();
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent keyEvent) {
            plyPlayer.keyReleased(keyEvent);
        }

        public void keyPressed(KeyEvent keyEvent) {

          plyPlayer.keyPressed(keyEvent);

          int x = plyPlayer.getX();
          int y = plyPlayer.getY();

          if (bIngame)
          {
            //si la tecla ALT es oprimida  
            if (keyEvent.isAltDown()) {
                //se genera un proyectil
                if (!shtShot.isVisible())
                    shtShot = new Shot(x, y);
            }
          }
          
          //si se oprime la tecla P
          if(keyEvent.getKeyCode() == KeyEvent.VK_P){
                if(!bPausa){
                    bPausa=true;
                }
                else{
                    bPausa=false;
                }
            }
            //si se oprime la tecla R
            if(keyEvent.getKeyCode() == KeyEvent.VK_R){
                if(!bCreditos){
                    bPausa=true;
                    bCreditos = true;
                }
                else{
                    bPausa=false;
                    bCreditos = false;
                }
            }
            //si se oprime la tecla I
            if(keyEvent.getKeyCode() == KeyEvent.VK_I){
                if(!bInstru){
                    bPausa=true;
                    bInstru = true;
                }
                else{
                    bPausa=false;
                    bInstru = false;
                }
            }
            //si se oprime la tecla G
            if(keyEvent.getKeyCode() == KeyEvent.VK_G){
                try{
                    grabaArchivo();    //Graba el vector en el archivo.
                }catch(IOException e){
                    System.out.println("Error en " + e.toString());
                }
            }
            //si se orpime a tecla C
            if(keyEvent.getKeyCode() == KeyEvent.VK_C){
                try{
                    leeArchivo();    //lee el contenido del archivo
                }catch(IOException e){
                    System.out.println("Error en " + e.toString());
                }
            }
        }
    }
    
    //metodo que lee las posiciones de los objetos de un archivo de texto
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
                plyPlayer.setX(Integer.parseInt(dato));
                dato = fileIn.readLine();
                plyPlayer.setY(Integer.parseInt(dato));
                dato = fileIn.readLine();
                
                Alien aleAlien = new Alien(0,0);
                
                for(int i=0; i < arrAlien.size() ; i++ ) {
                   
                    
                    aleAlien.setX(Integer.parseInt(dato));
                    dato = fileIn.readLine();
                    aleAlien.setY(Integer.parseInt(dato));
                    dato = fileIn.readLine();
                    
                    
                    arrAlien.set(i,aleAlien) ;
                }
                
                fileIn.close();
    }
    
    //metodo que graba las posiciones de los objetos en un archivo de texto
    public void grabaArchivo() throws IOException {
                                                          
                PrintWriter fileOut = new PrintWriter(new FileWriter(nombreArchivo));
                fileOut.println(plyPlayer.getX());
                fileOut.println(plyPlayer.getY());
                
                for(int i=0; i<arrAlien.size();i++){
                    Alien aleAlien;
                    aleAlien = (Alien) arrAlien.get(i);
                    fileOut.println( aleAlien.getX());
                    fileOut.println( aleAlien.getY());
                }
                
                

                fileOut.close();
        }
} 
