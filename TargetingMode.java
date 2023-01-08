
/**
 * Enumeration class TargetingMode - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum TargetingMode {
    ENEMYTARGETING("files/obrazky/menu/arrow.png", 175),
    ALLYTARGETING("files/obrazky/menu/arrow.png", 375),
    NOTTARGETING("none", 0);
    
    private Obrazok picture;
    private int posY;
    
    TargetingMode(String pictureFilePath, int posY) {
        this.picture = new Obrazok(pictureFilePath);
        this.posY = posY;
    }
    
    public Obrazok getPicture() {
        return this.picture;
    }
    
    public int getPosY() {
        return this.posY;
    }
}
