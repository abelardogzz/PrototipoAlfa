
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
public class Oso extends Monstruo {
    
     /** 
     * Oso
     * 
     * Metodo constructor de la clase <code>Oso</code>.<P>
     * En este metodo se inicializan las variables de monstruo
     * 
     * @param iX es la <code>posicion en x</code> de el oso.
     * @param iY es la <code>posicion en y</code> de el oso.
     * @param imaImagen es la <code>imagen</code> de el oso.
     * @param iAncho es el <code>ancho</code> de el oso.
     * @param iAlto es la <code>alto</code> de el oso.
     * @param bVisible es la <code>visibilidad</code> de el oso.
     */
    public Oso(int iX, int iY,int iAncho, int iAlto, Image imaImagen) {
        super(imaImagen);
        this.iX=iX;
        this.iY=iY;
        this.iAncho=iAncho;
        this.iAlto=iAlto;
        this.iDaño=2;

    }

}
