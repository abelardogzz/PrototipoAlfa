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
     * Metodo que modifica el valor de moneda <code>moneda</code>.<P>
     * 
     */
    public void setPWChile(boolean bValor){
        this.bPWChile=bValor; //Si es verdadero, entonces el Powerup es un chile
    }
      
}
