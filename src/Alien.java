
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author http://zetcode.com/
 */
public class Alien extends Sprite {

    private Bomb bomb;
    //private final String shot = "alien.png";
    private String sptAlien;
    //se crea la animacion para los aliens
        Image imgAlien1 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("alien.png"));
        Image imgAlien2 = Toolkit.getDefaultToolkit().getImage(
                            this.getClass().getResource("alien2.png"));
        
        /*sptAlien = new Sprite();
        sptAlien.sumaCuadro(imgAlien1, 100);
        sptAlien.sumaCuadro(imgAlien2, 100);*/

    public Alien(int x, int y) {
        this.x = x;
        this.y = y;

        bomb = new Bomb(x, y);
        ImageIcon ii = new ImageIcon(this.getClass().getResource(sptAlien));
        setImage(ii.getImage());

    }
    public int getX(){
        return this.getX();
    }
    public int getY(){
        return this.getY();
    }

    public void act(int direction) {
        this.x += direction;
    }

    public Bomb getBomb() {
        return bomb;
    }

    public class Bomb extends Sprite {

        private final String bomb = "bomb.png";
        private boolean destroyed;

        public Bomb(int x, int y) {
            setDestroyed(true);
            this.x = x;
            this.y = y;
            ImageIcon ii = new ImageIcon(this.getClass().getResource(bomb));
            setImage(ii.getImage());
        }

        public void setDestroyed(boolean destroyed) {
            this.destroyed = destroyed;
        }

        public boolean isDestroyed() {
            return destroyed;
        }
    }
}
