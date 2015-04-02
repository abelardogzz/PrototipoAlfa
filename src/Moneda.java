/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lalo Serna
 */
public class Moneda extends Object {
    private int valorMoneda;
    
     /** 
     * Moneda
     * 
     * Metodo constructor de la clase <code>Moneda</code>.<P>
     * 
     */
    public Moneda(){
        valorMoneda=1;
    }
    
     /** 
     * setValorMoneda
     * 
     * Metodo que modifica el valor de moneda <code>moneda</code>.<P>
     * 
     */
    public void setValorMoneda(int ivalorMoneda){
        this.valorMoneda=ivalorMoneda;
    }
      
}
