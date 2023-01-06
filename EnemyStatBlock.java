
/**
 * Enumeration class Enemy - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum EnemyStatBlock {
    RAT(20,0,10),
    BANDIT(70,50,10),
    WOLF(40,0,12),
    BANDITBOSS(150,100,10),
    NONE(0,0,0);
    
    private double health;
    private double mana;
    private double speed;
    
    EnemyStatBlock(double health, double mana, double speed) {
        this.health = health;
        this.mana = mana;
        this.speed = speed;
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
}
