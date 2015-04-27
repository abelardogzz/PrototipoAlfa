/**
 * JuegoApplet
 *
 * Esta clase es la base de monstruo, que incluye cosas basicas como nombre
 * imagen, etc
 *
 * @author Eduardo Serna
 * @version 1.0 2015/03/31
 */

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

 public abstract class Monstruo extends Sprite  {
    

    protected String sTipo;
    protected boolean visible;
    protected int iDaño;
    
    public static final int STATE_NORMAL = 0;
    public static final int STATE_DYING = 1;
    public static final int STATE_DEAD = 2;
    
    private Animacion animIzq;
    private Animacion animDer;
    private Animacion animMuert;
    
    private int state;
    private long stateTime;

    
    public Monstruo(Image imaImagen){
        //Esta imagen es la anim de la derecha
        super(imaImagen);
        state=STATE_NORMAL;
    }
     /**
     * setDaño
     * 
     * Metodo que configura el daño del monstruo
     * 
     * @param iDaño es el <code>daño/code> del monstruo.
     * 
     */
    public void setDaño(int iDaño){
        this.iDaño=iDaño;
    }
    
     /**
     * getX
     * 
    * Metodo que obtiene el daño del monstruo
     * 
     * @return iDaño es el <code>daño/code> del monstruo.
     * 
     * 
     */
    public int getDaño() {
            return iX;
    }
    
        /**
        Gets the maximum speed of this Creature.
    */
    public int getMaxSpeed() {
        return 0;
    }


    /**
        Wakes up the creature when the Creature first appears
        on screen. Normally, the creature starts moving left.
    */
    public void wakeUp() {
        if (getState() == STATE_NORMAL && getVelocidadX() == 0) {
            setVelocidadX(-getMaxSpeed());
        }
    }


    /**
        Gets the state of this Creature. The state is either
        STATE_NORMAL, STATE_DYING, or STATE_DEAD.
    */
    public int getState() {
        return state;
    }


    /**
        Sets the state of this Creature to STATE_NORMAL,
        STATE_DYING, or STATE_DEAD.
    */
    public void setState(int state) {
        if (this.state != state) {
            this.state = state;
            stateTime = 0;
            if (state == STATE_DYING) {
                setVelocidadX(0);
                setVelocidadY(0);
            }
        }
    }


    /**
        Checks if this creature is alive.
    */
    public boolean isAlive() {
        return (state == STATE_NORMAL);
    }


    /**
        Checks if this creature is flying.
    */
    public boolean isFlying() {
        return false;
    }


    /**
        Called before update() if the creature collided with a
        tile horizontally.
    */
    public void collideHorizontal() {
        setVelocidadX(-getVelocidadX());
    }


    /**
        Called before update() if the creature collided with a
        tile vertically.
    */
    public void collideVertical() {
        setVelocidadY(0);
    }
    
      /**
        Updates the animaton for this creature.
     * @param elapsedTime
    */
    @Override
    public void actualiza(long elapsedTime) {
        // select the correct Animation
        Animacion aniAnimacion = this.aniAnimacion;
        if (getVelocidadX() < 0) {
           
        }
      

        // update the Animation
        if (this.aniAnimacion != aniAnimacion) {
            this.aniAnimacion = aniAnimacion;
            this.aniAnimacion.iniciar();
        }
        else {
            this.aniAnimacion.actualiza(elapsedTime);
        }

        // update to "dead" state
        stateTime += elapsedTime;
        if (state == STATE_DYING) {
            setState(STATE_DEAD);
        }
    }





    
}
