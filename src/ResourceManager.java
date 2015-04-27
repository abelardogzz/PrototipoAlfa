

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;


/**
    La clase ResourceManager carga y mnaneja todos los cuadritos
    * y utiliza las animaciones del juego.
*/
public class ResourceManager {

    private ArrayList tiles;
    private int currentMap;
    private GraphicsConfiguration gc;

    // Estos sprites son usados para clonacion
    private Sprite jugSprite;
    private Sprite monSprite;
    private Sprite pwrSprite;
    private Sprite lobSprite;
    private Sprite serpSprite;

    /**
        Creates a new ResourceManager with the specified
        GraphicsConfiguration.
    */
    public ResourceManager(GraphicsConfiguration gc) {
        this.gc = gc;
        cargaAnimaciones();
        loadTileImages();

    }


    /**
     * loadImage
     * 
     * Metodo que regresa una imagen de la carpeta de recursos

     * 
     * @param sName es el nombre del archivo que se solicita
     * @return ImageIcon la imagen que se solicita
     */
    public Image loadImage(String sName) {
        String filename = "recursos/" + sName;
        return new ImageIcon(filename).getImage();
    }

    /**
     * getMirrorImage
     * 
     * Metodo que regresa la imagen espejo
     * 
     * 
     * 
     * @param image la imagen que se quiere hacer espejo
     * @return Imagen Espejo
     */
    public Image getMirrorImage(Image image) {
        return getScaledImage(image, -1, 1);
    }

        /**
     * getFlippedImage
     * 
     * Metodo que regresa la imagen volteada 180 grados
     * 
     * 
     * 
     * @param image la imagen que se quiere voltear

     */
    public Image getFlippedImage(Image image) {
        return getScaledImage(image, 1, -1);
    }


    private Image getScaledImage(Image image, float x, float y) {

        // set up the transform
        AffineTransform transform = new AffineTransform();
        transform.scale(x, y);
        transform.translate(
            (x-1) * image.getWidth(null) / 2,
            (y-1) * image.getHeight(null) / 2);

        // create a transparent (not translucent) image
        Image newImage = gc.createCompatibleImage(
            image.getWidth(null),
            image.getHeight(null),
            Transparency.BITMASK);

        // draw the transformed image
        Graphics2D g = (Graphics2D)newImage.getGraphics();
        g.drawImage(image, transform, null);
        g.dispose();

        return newImage;
    }


    public TileMap loadNextMap() {
        TileMap map = null;
        while (map == null) {
            currentMap++;
            try {
                map = loadMap(
                    "maps/map" + currentMap + ".txt");
            }
            catch (IOException ex) {
                if (currentMap == 1) {
                    // no maps to load!
                    return null;
                }
                currentMap = 0;
                map = null;
            }
        }

        return map;
    }


    public TileMap reloadMap() {
        try {
            return loadMap(
                "maps/map" + currentMap + ".txt");
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    private TileMap loadMap(String filename)
        throws IOException
    {
        ArrayList lines = new ArrayList();
        int width = 0;
        int height = 0;
        
        
        // read every line in the text file into the list
        BufferedReader reader = new BufferedReader(
            new FileReader(filename));
        File file=new File(filename);
        System.out.println("Parent "+file.getAbsolutePath());
        while (true) {
            String line = reader.readLine();
            
            System.out.println(line);

            
            // no more lines to read
            if (line == null) {
                reader.close();
                break;
            }

            // add every line except for comments
            if (!line.startsWith("#")) {
                lines.add(line);
                width = Math.max(width, line.length());
            }
        }

        // parse the lines to create a TileEngine
        height = lines.size();
        TileMap newMap = new TileMap(width, height);
        for (int y=0; y<height; y++) {
            String line = (String)lines.get(y);
            System.out.println(line);
            for (int x=0; x<line.length(); x++) {
                char ch = line.charAt(x);

                // check if the char represents tile A, B, C etc.
                int tile = ch - 'A';
                if (tile >= 0 && tile < tiles.size()) {
                    newMap.setTile(x, y, (Image)tiles.get(tile));
                }

                // check if the char represents a sprite
                else if (ch == 'o') {
                    addSprite(newMap, monSprite, x, y);
                }
                else if (ch == '!') {
                    addSprite(newMap, pwrSprite, x, y);
                }
         
                else if (ch == '1') {
                    addSprite(newMap, serpSprite, x, y);
                }
                else if (ch == '2') {
                    addSprite(newMap, serpSprite, x, y);
                }
            }
        }

        // add the player to the map
        Sprite player = (Sprite)jugSprite.clone();
        player.setX(TileMapRenderer.tilesToPixels(3));
        player.setY(0);
        newMap.setPlayer(player);

        return newMap;
    }


    private void addSprite(TileMap map,
        Sprite hostSprite, int tileX, int tileY)
    {
        if (hostSprite != null) {
            // clone the sprite from the "host"
            Sprite sprite = (Sprite)hostSprite.clone();

            // center the sprite
            sprite.setX(
                TileMapRenderer.tilesToPixels(tileX) +
                (TileMapRenderer.tilesToPixels(1) -
                sprite.getAncho()) / 2);

            // bottom-justify the sprite
            sprite.setY(
                TileMapRenderer.tilesToPixels(tileY + 1) -
                sprite.getAlto());

            // add it to the map
            map.addSprite(sprite);
        }
    }


    // -----------------------------------------------------------
    // code for loading sprites and images
    // -----------------------------------------------------------


    public void loadTileImages() {
        // keep looking for tile A,B,C, etc. this makes it
        // easy to drop new tiles in the images/ directory
        tiles = new ArrayList();
        char ch = 'A';
        while (true) {
            String name = "tile_" + ch + ".png";
            File file = new File("recursos/tiles/" + name);
            if (!file.exists()) {
                break;
            }
            tiles.add(loadImage(name));
            ch++;
        }
    }
    
    
    public void cargaAnimaciones() {

        
        // create creature animations
        Animacion animJug = new Animacion();
        Animacion animMon = new Animacion();
        Animacion animChile = new Animacion();
        Animacion animSerpiente = new Animacion();
        
        // defino las imagenes que usare
	URL urlImagenJuanLado = this.getClass().getResource("recursos/juanito.gif");
        URL urlImagenJuanArriba = this.getClass().getResource("recursos/Juan_arriba.png");
        URL urlImagenAlacranLado = this.getClass().getResource("recursos/alacran_lado.gif");
        URL urlImagenAlacranArriba = this.getClass().getResource("recursos/alacran_arriba.gif");
        URL urlImagenSerpiente = this.getClass().getResource("recursos/vibora.gif");
        URL urlImagenSerpienteAtk = this.getClass().getResource("recursos/vibora_atk.gif");
        URL urlImagenCactus = this.getClass().getResource("recursos/Cactus.png");
        URL urlImagenCactusVis = this.getClass().getResource("recursos/Visnaga.png");
        URL urlImagenVida = this.getClass().getResource("recursos/heart.png");
        URL urlImagenChile = this.getClass().getResource("recursos/Chile.png");
        URL urlImagenRevolver = this.getClass().getResource("recursos/Revolver6.png");
        
    
        
        animJug.sumaCuadro(loadImage("recursos/juanito.gif"),100);
        animMon.sumaCuadro(loadImage("recursos/Moneda1.png"),100);
        animChile.sumaCuadro(loadImage("recursos/vibora.gif"),100);
        animSerpiente.sumaCuadro(loadImage("recursos/vibora.gif"),100);
        
    }


  


}
