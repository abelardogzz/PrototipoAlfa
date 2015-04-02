
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
public class Lobo extends Monstruo {
    
     /** 
     * Lobo
     * 
     * Metodo constructor de la clase <code>Lobo</code>.<P>
     * En este metodo se inicializan las variables de monstruo
     * 
     * @param iX es la <code>posicion en x</code> de la lobo.
     * @param iY es la <code>posicion en y</code> de la lobo.
     * @param imaImagen es la <code>imagen</code> de la lobo.
     * @param iAncho es el <code>ancho</code> de la lobo.
     * @param iAlto es la <code>alto</code> de la lobo.
     * @param bVisible es la <code>visibilidad</code> de la lobo.
     */
    public Lobo(int iX, int iY,int iAncho, int iAlto, Image imaImagen) {
        
        this.iX=iX;
        this.iY=iY;
        this.iAncho=iAncho;
        this.iAlto=iAlto;
        this.imaImagen=imaImagen;
        this.iDaño=1;

    }

}
