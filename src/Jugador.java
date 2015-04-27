/**
 * Jugador
 *
 * Modela la definición de todos los jugadors de tipo
 * <code>Jugador</code>
 *
 * @author Abelardo Gzz, Eduardo S., Luis F.
 * @version 1.0
 * @date 31/Mar/15
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

public class Jugador extends Sprite{
    
    private int iX;     //posicion en x.       
    private int iY;     //posicion en y.
    private int iAncho; //ancho del jugador
    private int iAlto; //largo del jugador
    private Animacion aniAnimacion;	//imagen.
    private int iVidaTotal; //Max vida
    private int iVida; //La vida que tiene actualmente (si le pegan, disminuye)
    private int icantMunicion;
    private int icantMonedas;
    private String sArmActual; //arma actual del jugador
    
    /**
     * Jugador
     * 
     * Metodo constructor usado para crear el jugador animal
     * creando el icono a partir de una imagen
     * 
     * @param iX es la <code>posicion en x</code> del jugador.
     * @param iY es la <code>posicion en y</code> del jugador.
     * @param iAncho es el <code>ancho</code> del jugador.
     * @param iAlto es el <code>Largo</code> del jugador.
     * @param imaImagen es la <code>imagen</code> del jugador.
     * 
     */
    public Jugador(int iX, int iY , int iAncho, int iAlto,Image imaImagen,
            int iVida,int iVidaTotal, int icantMunicion, int icantMonedas) {
        super(imaImagen);
        this.iX = iX;
        this.iY = iY;
        this.iAncho = iAncho;
        this.iAlto = iAlto;
        this.iVida=iVida;
        this.iVidaTotal=iVidaTotal;
        this.icantMonedas=icantMonedas;
        sArmActual="revolver"; //es la arma de default
        
    }
    

    
    /**
     * setVidaTotal
     * 
     * Metodo modificador usado para ponerle mas vida total al jugador
     * 
     * @param iVidaExtra es la <code>vida o vidas extra</code> del jugador.
     * 
     */
    public void setVidaTotal(int iVidaExtra) {
        this.iVidaTotal =this.iVidaTotal+ iVidaExtra;
    }
    /**
     * reducirVida
     * 
     * Metodo modificador usado para cambiar la posicion en x del jugador
     * 
     * @param iX es la <code>posicion en x</code> del jugador.
     * 
     */
    public void reducirVida(int iDa) {
        this.iVida =this.iVida-iDa;
    }
    
    /**
     * cambiarArma
     * 
     * Metodo que cambia el arma del jugador
     * 
     * @param sArma es el tipo de <code>arma</code> que ahora tendra el jugador.
     * 
     */
    public void cambiarArma(String sArma) {
        this.sArmActual=sArma;
    }
    
    /**
     * getArma
     * 
     * Metodo que obtiene el arma actual del jugador
     * 
     * 
     * @return sArmActual es el arma actual del jugador
     * 
     */
    public String cambiarArma() {
        return this.sArmActual;
    }

    
    /**
     * getcantMonedas
     * 
     * Metodo de acceso que regresa la cant monedas de jugador
     * 
     * @return icantMonedas es la <code>cant monedas</code> del jugador.
     * 
     */
    public int getcantMonedas() {
            return icantMonedas;
    }
    
   /**
     * añadircantMonedas
     * 
     * Metodo de modificacion que accede la cant monedas de jugador
     * 
     * @param icantMonedas es la <code>cant monedas</code> que gana el jugador.
     * 
     */
    public void añadircantMonedas(int icantMonedas) {
            this.icantMonedas=this.icantMonedas+icantMonedas;
    }
    
     /**
     * getcantMunicion
     * 
     * Metodo de acceso que regresa la cant municion de jugador
     * 
     * @return icantMunicion es la <code>cant municion</code> del jugador.
     * 
     */
    public int getcantMunicion() {
            return icantMunicion;
    }
    
   /**
     * añadircantMunicion
     * 
     * Metodo de modificacion que accede la cant municion de jugador
     * 
     * @param icantMunicion es la <code>cant municion</code> que gana el jugador.
     * 
     */
    public void añadircantMunicion(int icantMunicion) {
            this.icantMunicion=this.icantMunicion+icantMunicion;
    }

    
    /**
     * intersecta
     *
     * Metodo que checa si un animal intersecta a otro
     *
     * @param objObjeto es un jugador de la clase <code>Object</code>
     * @return un boleano para saber si intersecta o no
     */
    public boolean intersecta(Object objObjeto) {
        if (objObjeto instanceof Jugador) {
            Rectangle rctEsteObjeto = new Rectangle(this.getX(), this.getY(),
                    this.getAncho(), this.getAlto());
            Jugador aniObjeto = (Jugador) objObjeto;
            Rectangle rctObjetoParam = new Rectangle(aniObjeto.getX(),
                    aniObjeto.getY(), aniObjeto.getAncho(), aniObjeto.getAlto());
            return rctEsteObjeto.intersects(rctObjetoParam);
        } 
        else {
            return false;
        }
    }
}
