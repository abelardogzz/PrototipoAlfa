/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luis
 */
public class Objeto {
    //imagen(animacion)
    //nombre del objeto
    //colisiones
    //posiciones xy
    
    private int iPosX;
    private int iPosY;
    private int iAncho; //ancho del objeto
    private int iAlto; //largo del objeto
    
    
    public Objeto(int iPosX, int iPosY , int iAncho, int iAlto) {
        this.iPosX = iPosX;
        this.iPosY = iPosY;
        this.iAncho = iAncho;
        this.iAlto = iAlto;
    }
}
