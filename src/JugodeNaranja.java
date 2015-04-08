
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
public class JugodeNaranja extends Objeto {
    private boolean bJugoCuarto;
    private boolean bJugoMitad;
    private boolean bJugoCompleto;
    
     /**
     * JugodeNaranja
     * 
     * Metodo constructor usado para crear el objeto de tipo jugo de naranja
     * creando la animacion a partir de una imagen
     * 
     * @param iPosX es la <code>posicion en x</code> del jugo de naranja.
     * @param iPosY es la <code>posicion en y</code> del jugo de naranja.
     * @param iAncho es el <code>ancho</code> del jugo de naranja.
     * @param iAlto es el <code>Largo</code> del jugo de naranja.
     /*@param imaImagen es la <code>animacion</code> del jugo de naranja.
     * 
     */
    public JugodeNaranja(int iPosX, int iPosY , int iAncho, int iAlto, Image imaImagen) {
        this.sTipo = "jugo";
        this.iPosX = iPosX;
        this.iPosY = iPosY;
        this.iAncho = iAncho;
        this.iAlto = iAlto;
        aniAnimacion=new Animacion();
        aniAnimacion.sumaCuadro(imaImagen,100);
        bJugoCuarto=false;
        bJugoMitad=false;
        bJugoCompleto=false;
    }
    
     /** 
     * setJugoCuarto
     * 
     * Metodo que modifica el tipo del  <code>JugodeNaranja</code>.<P>
     * 
     * 
     * @param bValor es el tipo booleano que se le quiere dar
     */
    public void setJugoCuarto(boolean bValor){
        this.bJugoCuarto=bValor; //Si es verdadero, entonces es un jugo de naranja
        //1/4
    }
    
    /** 
     * setJugoMitad
     * 
     * Metodo que modifica el tipo del  <code>JugodeNaranja</code>.<P>
     * 
     * 
     * @param bValor es el tipo booleano que se le quiere dar
     */
    public void setJugoMitad(boolean bValor){
        this.bJugoMitad=bValor; //Si es verdadero, entonces es un jugo de naranja
        //a la mitad
    }
    
    /** 
     * setJugoCompleto
     * 
     * Metodo que modifica el tipo del  <code>JugodeNaranja</code>.<P>
     * 
     * 
     * @param bValor es el tipo booleano que se le quiere dar
     */
    public void setJugoCompleto(boolean bValor){
        this.bJugoCompleto=bValor; //Si es verdadero, entonces es un jugo
        //de naranja completo
    }
    
    
    
}
