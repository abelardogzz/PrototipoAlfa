
import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lalo Serna
 */
public class Cactus extends Monstruo {
    
     /** 
     * Cactus
     * 
     * Metodo constructor de la clase <code>Cactus</code>.<P>
     * En este metodo se inicializan las variables de monstruo
     * 
     * @param iX es la <code>posicion en x</code> de la cactus.
     * @param iY es la <code>posicion en y</code> de la cactus.
     * @param imaImagen es la <code>imagen</code> de la cactus.
     * @param iAncho es el <code>ancho</code> de la cactus.
     * @param iAlto es la <code>alto</code> de la cactus.
     * @param bVisible es la <code>visibilidad</code> de la cactus.
     */
    public Cactus(int iX, int iY,int iAncho, int iAlto, Image imaImagen) {
        super(imaImagen);
        this.iX=iX;
        this.iY=iY;
        this.iAncho=iAncho;
        this.iAlto=iAlto;
        this.iDaño=1;

    }

}
