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
    
    private int iX;     //posicion en x.       
    private int iY;     //posicion en y.
    private int iAncho; //ancho del monstruo
    private int iAlto; //largo del monstruo
    private Animacion aniMonstruo;	//icono.
    private String sTipo;
    
    
     /**
     * Monstruo
     * 
     * Este es el metodo constructor utilizado para crear el monstruo base Monstruo
     * 
     * @param iPosX es la <code>posicion en x</code> del monstruo.
     * @param iPosY es la <code>posicion en y</code> del monstruo.
     * @param aniMonstruo es la <code>animacion</code> del monstruo. Este parametro
     * se utiliza debido a que clase monstruo es la clase padre, y los hijos
     * seran encargados de hacer las animaciones
     * 
     */
    public Monstruo(int iPosX,int iPosY,int iAncho,
            int iAlto, Animacion aniMonstruo){
        this.iX=iPosX;
        this.iY=iPosY;
        this.iAncho=iAncho;
        this.iAlto=iAlto;
        this.aniMonstruo=aniMonstruo;
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
     * getY
     * 
     * Metodo de acceso que regresa la posicion en y del objeto 
     * 
     * @return posY es la <code>posicion en y</code> del objeto.
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
    
    
}
