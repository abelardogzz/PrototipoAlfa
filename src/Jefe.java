
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
public class Jefe extends Monstruo {
    
     /** 
     * Jefe
     * 
     * Metodo constructor de la clase <code>Jefe</code>.<P>
     * En este metodo se inicializan las variables de monstruo
     * 
     * @param iX es la <code>posicion en x</code> de la Jefe.
     * @param iY es la <code>posicion en y</code> de la Jefe.
     * @param imaImagen es la <code>imagen</code> de la Jefe.
     * @param iAncho es el <code>ancho</code> de la Jefe.
     * @param iAlto es la <code>alto</code> de la Jefe.
     * @param bVisible es la <code>visibilidad</code> de la Jefe.
     */
    public Jefe(int iX, int iY,int iAncho, int iAlto, Image imaImagen,
            int iDano) {
        super(imaImagen);
        this.iX=iX;
        this.iY=iY;
        this.iAncho=iAncho;
        this.iAlto=iAlto;
        this.iDaño=iDano;

    }

}
