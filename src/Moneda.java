
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
public class Moneda extends Objeto {
    private int valorMoneda;
    
    /**
     * Moneda
     * 
     * Metodo constructor usado para crear el objeto de tipo moneda
     * creando la animacion a partir de una imagen
     * 
     * @param iPosX es la <code>posicion en x</code> de la moneda.
     * @param iPosY es la <code>posicion en y</code> de la moneda.
     * @param iAncho es el <code>ancho</code> de la moneda.
     * @param iAlto es el <code>Largo</code> de la moneda.
     * @param imaImagen es la <code>animacion</code> de la moneda.
     * @param iValor es el <code>valor</code> de la moneda.
     * 
     */
    public Moneda(int iPosX, int iPosY , int iAncho, int iAlto, Image imaImagen,
            int iValor) {
        this.sTipo = "powerup";
        this.iPosX = iPosX;
        this.iPosY = iPosY;
        this.iAncho = iAncho;
        this.iAlto = iAlto;
        aniAnimacion=new Animacion();
        aniAnimacion.sumaCuadro(imaImagen,100);
        valorMoneda=iValor;
    }
    
     /** 
     * setValorMoneda
     * 
     * Metodo que modifica el valor de moneda <code>moneda</code>.<P>
     * 
     * @param iValorMoneda es el valor de la<code>moneda</code> .
     * 
     */
    public void setValorMoneda(int ivalorMoneda){
        this.valorMoneda=ivalorMoneda;
    }
      
}
