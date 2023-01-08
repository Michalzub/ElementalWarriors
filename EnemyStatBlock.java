
/**
 * Enumeration class Enemy - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum EnemyStatBlock {
    RAT(20, 0, 10, 15, "files/obrazky/rat.png"),
    BANDIT(50, 50, 20, 13, "files/obrazky/bandit.png"),
    WOLF(30, 0, 15, 14, "files/obrazky/wolf.png"),
    BANDITBOSS(150, 100, 20, 11, "files/obrazky/banditboss.png"),
    NONE(0, 0, 0, 0, "none");
    
    private double health;
    private double mana;
    private double damage;
    private double speed;
    private String pictureFilePath;
    
    EnemyStatBlock(double health, double mana,double damage, double speed, String pictureFilePath) {
        this.health = health;
        this.mana = mana;
        this.damage = damage;
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
    public double getDamage() {
        return this.damage;
    }
    public double getSpeed() {
        return this.speed;
    }
    
    public String getPictureFilePath() {
        return this.pictureFilePath;
    }
}
