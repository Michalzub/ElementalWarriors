
/**
 * Enum so zákadnými statmi nepriatela a jeho typom
 * 
 * @author Michal Zúbek
 * @version 0.9
 */
public enum EnemyStatBlock {
    /**
     * stat block potkana
     */
    RAT(20, 0, 10, 15, "files/obrazky/rat.png"),
    
    /**
     * stat block banditu
     */
    BANDIT(50, 50, 20, 13, "files/obrazky/bandit.png"),
    
    /**
     * stat block vlka
     */
    WOLF(30, 0, 15, 14, "files/obrazky/wolf.png"),
    
    /**
     * stat block bandit bossa
     */
    BANDITBOSS(150, 100, 20, 11, "files/obrazky/banditboss.png"),
    
    /**
     * prazdny stat block
     */
    NONE(0, 0, 0, 0, "none");
    
    private double health;
    private double mana;
    private double damage;
    private double speed;
    private String pictureFilePath;
    
    EnemyStatBlock(double health, double mana, double damage, double speed, String pictureFilePath) {
        this.health = health;
        this.mana = mana;
        this.damage = damage;
        this.speed = speed;
        if (!pictureFilePath.equals("none")) {
            this.pictureFilePath = pictureFilePath;
        }
    }
    /**
     * vrati zivoty
     * @return double health
     */
    public double getHeath() {
        return this.health;
    }
    
    /**
     * vrati manu
     * @return double mana
     */
    public double getMana() {
        return this.mana;
    }
    
    /**
     * vrati damage
     * @return double damage
     */
    public double getDamage() {
        return this.damage;
    }
    
    /**
     * vrati speed
     * @return double speed
     */
    public double getSpeed() {
        return this.speed;
    }
    
    /**
     * vrati String cesty k obrazku
     * @return String pictureFilePath
     */
    public String getPictureFilePath() {
        return this.pictureFilePath;
    }
}
