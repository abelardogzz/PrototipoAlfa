
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
public class Alacran extends Monstruo {
    
     /** 
     * Alacran
     * 
     * Metodo constructor de la clase <code>Alacran</code>.<P>
     * En este metodo se inicializan las variables de monstruo
     * 
     * @param iX es la <code>posicion en x</code> de la alacran.
     * @param iY es la <code>posicion en y</code> de la alacran.
     * @param imaImagen es la <code>imagen</code> de la alacran.
     * @param iAncho es el <code>ancho</code> de la alacran.
     * @param iAlto es la <code>alto</code> de la alacran.
     * @param bVisible es la <code>visibilidad</code> de la alacran.
     */
    public Alacran(int iX, int iY,int iAncho, int iAlto, Image imaImagen) {
        
        this.iX=iX;
        this.iY=iY;
        this.iAncho=iAncho;
        this.iAlto=iAlto;
        this.imaImagen=imaImagen;
        this.iDaño=4;

    }

}
