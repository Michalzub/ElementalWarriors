
/**
 * Enumeration class Enemy - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum EnemyStatBlock {
    RAT(20, 0, 15, "files/obrazky/rat.png"),
    BANDIT(50, 50, 13, "files/obrazky/bandit.png"),
    WOLF(30, 0, 14, "files/obrazky/wolf.png"),
    BANDITBOSS(150, 100, 11, "files/obrazky/banditboss.png"),
    NONE(0, 0, 0, "none");
    
    private double health;
    private double mana;
    private double speed;
    private String pictureFilePath;
    
    EnemyStatBlock(double health, double mana, double speed, String pictureFilePath) {
        this.health = health;
        this.mana = mana;
        this.speed = speed;
        if(!pictureFilePath.equals("none")){
            this.pictureFilePath = pictureFilePath;
        }
    }
    
    public double getHeath() {
        return this.health;
    }
    public double getMana() {
        return this.mana;
    }
    public double getSpeed() {
        return this.speed;
    }
    
    public String getPictureFilePath() {
        return this.pictureFilePath;
    }
}
