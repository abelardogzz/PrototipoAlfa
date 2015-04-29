import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class Sprite extends Object {

    protected int iX;     //posicion en iX.       
    protected int iY;     //posicion en iY.
    protected int iAncho; //ancho del jugador
    protected int iAlto; //largo del jugador
    protected Animacion aniAnimacion;	//imagen.
    protected int idX; //diferencial en x
    protected int idY; //diferencial en y
    

    /**
        Creates a new Sprite object with the specified Animation.
    */
    public Sprite(Image imaImagen) {
        this.aniAnimacion = new Animacion();
        aniAnimacion.sumaCuadro(imaImagen,100);
    }

    /**
        Updates this Sprite's Animation and its position based
        on the velocitiY.
        * 
    */
    public void actualiza(long elapsedTime) {
        iX += idX * elapsedTime;
        iY += idY * elapsedTime;
        aniAnimacion.actualiza(elapsedTime);
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
        Gets the horizontal velocitiY of this Sprite in piiXels
        per millisecond.
    */
    public int getVelocidadX() {
        return idX;
    }

    /**
        Gets the vertical velocitiY of this Sprite in piiXels
        per millisecond.
    */
    public int getVelocidadY() {
        return idY;
    }

    /**
        Sets the horizontal velocitiY of this Sprite in piiXels
        per millisecond.
    */
    public void setVelocidadX(int idX) {
        this.idX = idX;
    }

    /**
        Sets the vertical velocitiY of this Sprite in piiXels
        per millisecond.
    */
    public void setVelocidadY(int idY) {
        this.idY = idY;
    }

    /**
        Gets this Sprite's current image.
    */
    public Image getImagen() {
        return aniAnimacion.getImagen();
    }

    /**
        Clones this Sprite. Does not clone position or velocitiY
        info.
    */
    public Object clone() {
        return new Sprite(aniAnimacion.getImagen());
    }
    
        /**
     * paint
     * 
     * Metodo para pintar el jugador
     * 
     * @param graGrafico   objeto de la clase <code>Graphics</code> para graficar
     * @param imoObserver  objeto de la clase <code>ImageObserver</code> es el 
     *    Applet donde se pintara
     * 
     */
    public void paint(Graphics graGrafico, ImageObserver imoObserver) {
        graGrafico.drawImage(aniAnimacion.getImagen(), this.getX(), this.getY(),imoObserver);
    }
    
    
    /**
     * intersecta
     *
     * Metodo que checa si se colisionan sprites
     *
     * @param objObjeto es un jugador de la clase <code>Object</code>
     * @return un boleano para saber si intersecta o no
     */
    public boolean intersecta(Object objObjeto) {
        if (objObjeto instanceof Sprite) {
            Rectangle rctEsteObjeto = new Rectangle(this.getX(), this.getY(),
                    this.getAncho(), this.getAlto());
            Sprite sprObjeto = (Sprite) objObjeto;
            Rectangle rctObjetoParam = new Rectangle(sprObjeto.getX(),
                    sprObjeto.getY(), sprObjeto.getAncho(), sprObjeto.getAlto());
            return rctEsteObjeto.intersects(rctObjetoParam);
        } 
        else {
            return false;
        }
    }
}
