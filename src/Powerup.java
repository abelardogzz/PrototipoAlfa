/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lalo Serna
 */
public class Powerup extends Object {
    private boolean bPWChile;
    private boolean bPWEscopeta;
    private boolean bPWRifle;
    
     /** 
     * Powerup
     * 
     * Metodo constructor de la clase <code>Powerup</code>.<P>
     * 
     */
    public Powerup(){
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
