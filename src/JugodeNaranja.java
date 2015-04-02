/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lalo Serna
 */
public class JugodeNaranja extends Object {
    private boolean bJugoCuarto;
    private boolean bJugoMitad;
    private boolean bJugoCompleto;
    
     /** 
     * JugodeNaranja
     * 
     * Metodo constructor de la clase <code>JugodeNaranja</code>.<P>
     * 
     */
    public JugodeNaranja(){
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
