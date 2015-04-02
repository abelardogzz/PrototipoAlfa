/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lalo Serna
 */
public class Arma {
    private String stipoArma;
    
     /** 
     * Arma
     * 
     * Metodo constructor de la clase <code>Arma</code>.<P>
     * s
     */
    public Arma(){
        String stipoArma="revolver";
    }
    
     /**
     * setArma
     * 
     * Metodo modificador usado para cambiar el tipo de arma
     * 
     * @param stipoArma es el <code>tipo de arma</code> .
     * 
     */
    public void setArma(String stipoArma){
        this.stipoArma=stipoArma;
    }
    
}
