
import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LaloMac
 */
public class VidaExtra extends Objeto {
    
      /**
     * VidaExtra
     * 
     * Metodo constructor usado para crear el objeto de tipo vida extra
     * creando la animacion a partir de una imagen
     * 
     * @param iPosX es la <code>posicion en x</code> de la vida extra.
     * @param iPosY es la <code>posicion en y</code> de la vida extra.
     * @param iAncho es el <code>ancho</code> de la vida extra.
     * @param iAlto es el <code>Largo</code> de la vida extra.
     /*@param imaImagen es la <code>animacion</code> de la vida extra.
     * 
     */
    
     public VidaExtra(int iPosX, int iPosY , int iAncho, int iAlto, Image imaImagen) {
        this.sTipo = "powerup";
        this.iPosX = iPosX;
        this.iPosY = iPosY;
        this.iAncho = iAncho;
        this.iAlto = iAlto;
        aniAnimacion=new Animacion();
        aniAnimacion.sumaCuadro(imaImagen,100);
    }
  
    
}
