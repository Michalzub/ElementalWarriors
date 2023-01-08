
/**
 * Enum typov políčka obsahuje ich osobitné číslo a obrázok.
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public enum SpaceType {
    /**
     * Rock jeho typ ako číslo a obrázok.
     */
    ROCK(0, "files/obrazky/rock.png"),
    
    /**
     * Grass jeho typ ako číslo a obrázok.
     */
    GRASS(1, "files/obrazky/grass.png"),
    
    /**
     * Chest jeho typ ako číslo a obrázok.
     */
    CHEST(2, "files/obrazky/chest.png"),
    
    /**
     * Enemy jeho typ ako číslo a obrázok.
     */
    ENEMY(3, "files/obrazky/enemy.png");
    
    private int type;
    private String pictureFilePath;
    
    SpaceType (int type, String pictureFilePath) {
        this.type = type;
        this.pictureFilePath = pictureFilePath;
    }
    
    public int getType() {
        return this.type;
    }
    
    public String getPictureFilePath() {
        return this.pictureFilePath;
    }
}
