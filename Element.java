import java.util.ArrayList;
/**
 * Enumeration class element - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Element {
    FIRE(0.7,0.9,1.3,1),
    WATER(0.85,1.3,0.9,1),
    EARTH(1.5,1,0.5,0.7),
    AIR(1,0.9,1.3,1),
    NONE(1,1,1,1);
    
    private double healthMultiplier;
    private double manaMultiplier;
    private double damageMultiplier;
    private double speedMultiplier;
    
    Element(double healthMultiplier, double manaMultiplier, double damageMultiplier, double speedMultiplier) {
        this.healthMultiplier = healthMultiplier;
        this.manaMultiplier = manaMultiplier;
        this.damageMultiplier = damageMultiplier;
        this.speedMultiplier = speedMultiplier;
    }
    public double getHealthMultiplier() {
        return this.healthMultiplier;
    }
    public double getManaMultiplier() {
        return this.manaMultiplier;
    }
    public double getDamageMultiplier() {
        return this.damageMultiplier;
    }
    public double getSpeedMultiplier() {
        return this.speedMultiplier;
    }
}
