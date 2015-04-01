/**
 * Objeto
 *
 * Modela la definición de todos los objetos de tipo
 * <code>Objeto</code>
 *
 * @author Abelardo Roman Gzz, Eduardo Serna, Luis Carlos Flores
 * @version 1.0 
 * @date 31/marzo/2015
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

/**
     * Objeto
     * 
     * Metodo constructor usado para crear el objeto animal
     * creando el icono a partir de una imagen
     * 
     * @param iPosX es la <code>posicion en x</code> del objeto.
     * @param iPosY es la <code>posicion en y</code> del objeto.
     * @param iAncho es el <code>ancho</code> del objeto.
     * @param iAlto es el <code>Largo</code> del objeto.
     //////////////// @param imaImagen es la <code>imagen</code> del objeto.
     * 
     */
public class Objeto {
    //imagen(animacion)
    //nombre del objeto///////
    //colisiones/////
    //posiciones xy
    
    private String sTipo;   //string del tipo de objeto
    private int iPosX;  //posicion X del objeto
    private int iPosY;  //posicion Y del objeto
    private int iAncho; //ancho del objeto
    private int iAlto; //largo del objeto
    private Animacion AniObjeto; //animacion del objeto
    
    
    public Objeto(String sTipo, int iPosX, int iPosY , int iAncho, int iAlto) {
        this.sTipo = sTipo;
        this.iPosX = iPosX;
        this.iPosY = iPosY;
        this.iAncho = iAncho;
        this.iAlto = iAlto;
    }
    
    /**
     * setX
     * 
     * Metodo modificador usado para cambiar la posicion en x del objeto
     * 
     * @param iPosX es la <code>posicion en x</code> del objeto.
     * 
     */
    public void setX(int iPosX) {
        this.iPosX = iPosX;
    }
    
    /**
     * getX
     * 
     * Metodo de acceso que regresa la posicion en x del objeto 
     * 
     * @return iPosX es la <code>posicion en x</code> del objeto.
     * 
     */
    public int getX() {
            return iPosX;
    }
    
    /**
     * setY
     * 
     * Metodo modificador usado para cambiar la posicion en y del objeto 
     * 
     * @param iPosY es la <code>posicion en y</code> del objeto.
     * 
     */
    public void setY(int iPosY) {
            this.iPosY = iPosY;
    }

    /**
     * getY
     * 
     * Metodo de acceso que regresa la posicion en y del objeto 
     * 
     * @return iPosY es la <code>posicion en y</code> del objeto.
     * 
     */
    public int getY() {
        return iPosY;
    }
    
    /**
     * getAncho
     * 
     * Metodo de acceso que regresa el ancho del icono 
     * 
     * @return un <code>entero</code> que es el ancho de la imagen.
     * 
     */
    public int getAncho() {
        return iAncho;
    }

    /**
     * getAlto
     * 
     * Metodo que  da el alto del icono 
     * 
     * @return un <code>entero</code> que es el alto de la imagen.
     * 
     */
    public int getAlto() {
        return iAlto;
    }
    
    /**
     * setTipo
     * 
     * Metodo modificador usado para cambiar el tipo del objeto
     * 
     * @param sTipo es el <code>tipo</code> del objeto.
     * 
     */
    public void setTipo(String sTipo) {
        this.sTipo = sTipo;
    }
    
    /**
     * getTipo
     * 
     * Metodo de acceso que regresa el tipo del objeto 
     * 
     * @return sTipo es el <code>tipo</code> del objeto.
     * 
     */
    public String getTipo() {
            return sTipo;
    }
    
    /**
     * equals
     * 
     * Metodo para checar igualdad con otro objeto
     * 
     * @param objObjeto    objeto de la clase <code>Object</code> para comparar
     * @return un valor <code>boleano</code> que sera verdadero si el objeto
     *   que invoca es igual al objeto recibido como parámetro
     * 
     */
    public boolean equals(Object objObjeto) {
        // si el objeto parametro es una instancia de la clase Objeto
        if (objObjeto instanceof Objeto) {
            // se regresa la comparación entre este objeto que invoca y el
            // objeto recibido como parametro
            Objeto ObjParam = (Objeto) objObjeto;
            return this.getTipo() == ObjParam.getTipo() &&
                    this.getX() ==  ObjParam.getX() && 
                    this.getY() == ObjParam.getY() &&
                    this.getAncho() == ObjParam.getAncho() &&
                    this.getAlto() == ObjParam.getAlto(); //&&
                    //this.getImagen() == ObjParam.getImagen();
        }
        else {
            // se regresa un falso porque el objeto recibido no es tipo Objeto
            return false;
        }
    }
    
    /**
     * toString
     * 
     * Metodo para obtener la interfaz del objeto
     * 
      * @return un valor <code>String</code> que representa al objeto
     * 
     */
    public String toString() {
        return "Nombre: " + this.getTipo() + " x: " + this.getX() + " y: "+ this.getY() +
                " ancho: " + this.getAncho() + " alto: " + this.getAlto();
    }
    
    public boolean intersecta(Object objObjeto) {
        if (objObjeto instanceof Objeto) {
            Rectangle rctEsteObjeto = new Rectangle(this.getX(), this.getY(),
                    this.getAncho(), this.getAlto());
            Objeto aniObjeto = (Objeto) objObjeto;
            Rectangle rctObjetoParam = new Rectangle(aniObjeto.getX(),
                    aniObjeto.getY(), aniObjeto.getAncho(), aniObjeto.getAlto());
            return rctEsteObjeto.intersects(rctObjetoParam);
        } 
        else {
            return false;
        }
    }
}
