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

public class Monstruo {
    
    protected int iX;     //posicion en x.       
    protected int iY;     //posicion en y.
    protected int iAncho; //ancho del monstruo
    protected int iAlto; //largo del monstruo
    protected Image imaImagen;	//icono.
    protected String sTipo;
    protected boolean visible;
    protected int iDaño;
    
    
     /**
     * Monstruo
     * 
     * Este es el constructor default

     * 
     */
    public Monstruo(){
        this.visible=true;
        
    }
    
     /**
     * setX
     * 
     * Metodo que configura la posicion X del monstruo
     * 
     * @param iPosX es la <code>posicion en x</code> del monstruo.
     * 
     */
    public void setX(int iPosX){
        iX=iPosX;
    }
    
     /**
     * setY
     * 
     * Metodo que configura la posicion Y del monstruo
     * 
     * @param iPosY es la <code>posicion en y</code> del monstruo.
     * 
     */
    public void setY(int iPosY){
        iY=iPosY;
    }
    
     /**
     * getX
     * 
     * Metodo de acceso que regresa la posicion en x del monstruo
     * 
     * @return iX es la <code>posicion en x</code> del monstruo.
     * 
     */
    public int getX() {
            return iX;
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
     * getY
     * 
     * Metodo de acceso que regresa la posicion en y del monstruo 
     * 
     * @return posY es la <code>posicion en y</code> del monstruo.
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
     * @return un <code>entero</code> que es el ancho del icono.
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
     * @return un <code>entero</code> que es el alto del icono.
     * 
     */
    public int getAlto() {
        return iAlto;
    }
    
    /**
     * setImagen
     * 
     * Metodo modificador usado para cambiar el icono de imagen del monstruo
     * tomandolo de un objeto imagen
     * 
     * @param imaImagen es la <code>imagen</code> del monstruo.
     * 
     */
    public void setImagen(Image imaImagen) {
        this.imaImagen = imaImagen;
    }
    
     /**
     * getImagen
     * 
     * Metodo de acceso que regresa la imagen que representa el icono del monstruo
     * 
     * @return la imagen a partide del <code>icono</code> del monstruo.
     * 
     */
    public Image getImagen() {
        return imaImagen;
    }
    
    /**
     * paint
     * 
     * Metodo para pintar el animal
     * 
     * @param graGrafico    objeto de la clase <code>Graphics</code> para graficar
     * @param imoObserver  objeto de la clase <code>ImageObserver</code> es el 
     *    Applet donde se pintara
     * 
     */
    public void paint(Graphics graGrafico, ImageObserver imoObserver) {
        graGrafico.drawImage(getImagen(), getX(), getY(), getAncho(), getAlto(), imoObserver);
    }
    
}
