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

public class Jugador {
    
    private int iX;     //posicion en x.       
    private int iY;     //posicion en y.
    private int iAncho; //ancho del jugador
    private int iAlto; //largo del jugador
    private Animacion aniAnimacion;	//imagen.
    private int iVidaTotal; //Max vida
    private int iVida; //La vida que tiene actualmente (si le pegan, disminuye)
    private int icantMunicion;
    private int icantMonedas;
    private Arma armActual;
    
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
        this.iX = iX;
        this.iY = iY;
        this.iAncho = iAncho;
        this.iAlto = iAlto;
        aniAnimacion=new Animacion();
        aniAnimacion.sumaCuadro(imaImagen,100);
        this.iVida=iVida;
        this.iVidaTotal=iVidaTotal;
        this.icantMonedas=icantMonedas;
        armActual=new Arma();
        armActual.setArma("revolver");
        
    }
    
    /**
     * setX
     * 
     * Metodo modificador usado para cambiar la posicion en x del jugador
     * 
     * @param iX es la <code>posicion en x</code> del jugador.
     * 
     */
    public void setX(int iX) {
        this.iX = iX;
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
     * getX
     * 
     * Metodo de acceso que regresa la posicion en x del jugador 
     * 
     * @return iX es la <code>posicion en x</code> del jugador.
     * 
     */
    public int getX() {
            return iX;
    }
    
    /**
     * setY
     * 
     * Metodo modificador usado para cambiar la posicion en y del jugador 
     * 
     * @param iY es la <code>posicion en y</code> del jugador.
     * 
     */
    public void setY(int iY) {
            this.iY = iY;
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
     * getY
     * 
     * Metodo de acceso que regresa la posicion en y del jugador 
     * 
     * @return posY es la <code>posicion en y</code> del jugador.
     * 
     */
    public int getY() {
        return iY;
    }
    
   
    /**
     * setImagen
     * 
     * Metodo modificador usado para cambiar el icono de imagen del jugador
     * tomandolo de un jugador imagen
     * 
     * @param imaImagen es la <code>imagen</code> del jugador.
     * 
     */
    public void setImagen(Image imaImagen) {
        aniAnimacion.quitaCuadros();
        aniAnimacion.sumaCuadro(imaImagen,100);
    }

    
    /**
     * getAncho
     * 
     * Metodo de acceso que regresa el ancho del icono 
     * 
     * @return un <code>entero</code> que es el ancho de la imagen.
     * 
     */
    public int getAncho() {
        return iAncho;
    }

    /**
     * getAlto
     * 
     * Metodo que  da el alto del icono 
     * 
     * @return un <code>entero</code> que es el alto de la imagen.
     * 
     */
    public int getAlto() {
        return iAlto;
    }
    
    /**
     * paint
     * 
     * Metodo para pintar el animal
     * 
     * @param graGrafico   jugador de la clase <code>Graphics</code> para graficar
     * @param imoObserver  jugador de la clase <code>ImageObserver</code> es el 
     *    Applet donde se pintara
     * 
     */
    public void paint(Graphics graGrafico, ImageObserver imoObserver) {
        graGrafico.drawImage(aniAnimacion.getImagen(), this.getX(), this.getY(),imoObserver);
    }
    
     /**
     * actualiza
     * 
     * Metodo que actualiza los frames
     * 
     * @param lTiempoTranscurrido es el tiempo transcurrido desde que inicio la ejecucion
     * 
     */
    public void actualiza(long lTiempoTranscurrido) {
      aniAnimacion.actualiza(lTiempoTranscurrido);
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
