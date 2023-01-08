
/**
 * Enum módu targetingu (vyberu ciela/targetu). ma obrazok sipky a poziciu Y pre zobrazenie
 * 
 * @author Michal Zúbek
 * @version 0.9
 */
public enum TargetingMode {
    /**
     * mod targeting na nepriatela
     */
    ENEMYTARGETING("files/obrazky/menu/arrow.png", 175),
    
    /**
     * mod targeting na spolubojovnika
     */
    ALLYTARGETING("files/obrazky/menu/arrow.png", 375),
    
    /**
     * mod bez targetingu
     */
    NOTTARGETING("none", 0);
    
    private Obrazok picture;
    private int posY;
    
    TargetingMode(String pictureFilePath, int posY) {
        if (!pictureFilePath.equals("none")) {
            this.picture = new Obrazok(pictureFilePath);
        }
        this.posY = posY;
    }
    
    /**
     * vrati obrazok sipky
     * @return Obrazok picture
     */
    public Obrazok getPicture() {
        return this.picture;
    }
    
    /**
     * vrati poziciu na Y osi
     * @return int posY
     */
    public int getPosY() {
        return this.posY;
    }
}
