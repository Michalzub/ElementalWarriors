
/**
 * Enum typov políčka obsahuje ich osobitné číslo a obrázok.
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public enum SpaceType {
    ROCK(0, "files/obrazky/rock.png"),
    GRASS(1, "files/obrazky/grass.png"),
    CHEST(2, "files/obrazky/chest.png"),
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
