
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
public class Powerup extends Objeto {
    private boolean bPWChile;
    private boolean bPWEscopeta;
    private boolean bPWRifle;
    
       
    /**
     * Powerup
     * 
     * Metodo constructor usado para crear el objeto de tipo powerup
     * creando la animacion a partir de una imagen
     * 
     * @param iPosX es la <code>posicion en x</code> del powerup.
     * @param iPosY es la <code>posicion en y</code> del powerup.
     * @param iAncho es el <code>ancho</code> del powerup.
     * @param iAlto es el <code>Largo</code> del powerup.
     /*@param imaImagen es la <code>animacion</code> del powerup.
     * 
     */
    public Powerup(int iPosX, int iPosY , int iAncho, int iAlto, Image imaImagen) {
        this.sTipo = "powerup";
        this.iPosX = iPosX;
        this.iPosY = iPosY;
        this.iAncho = iAncho;
        this.iAlto = iAlto;
        aniAnimacion=new Animacion();
        aniAnimacion.sumaCuadro(imaImagen,100);
        bPWChile=false;
        bPWEscopeta=false;
        bPWRifle=false;
    }
    
    
     /** 
     * setPWChile
     * 
     * Metodo que modifica el valor del  <code>powerup</code>.<P>
     * 
     * 
     * @param bValor es el valor booleano que se le quiere dar
     */
    public void setPWChile(boolean bValor){
        this.bPWChile=bValor; //Si es verdadero, entonces el Powerup es un chile
    }
    
    /** 
     * setPWEscopeta
     * 
     * Metodo que modifica el valor del  <code>powerup</code>.<P>
     * 
     * 
     * @param bValor es el valor booleano que se le quiere dar
     */
    public void setPWEscopeta(boolean bValor){
        this.bPWEscopeta=bValor; //Si es verdadero, entonces el Powerup es una escopeta
    }
    
    /** 
     * setPWRifle
     * 
     * Metodo que modifica el valor del  <code>powerup</code>.<P>
     * 
     * 
     * @param bValor es el valor booleano que se le quiere dar
     */
    public void setPWRifle(boolean bValor){
        this.bPWEscopeta=bValor; //Si es verdadero, entonces el Powerup es un rifle
    }
}
