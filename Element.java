import java.util.ArrayList;
/**
 * Enumeration class element - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Element {
    FIRE(0.7,0.9,1.3,1.1,"firedude.png"),
    WATER(0.85,1.3,0.9,1,"waterdude.png"),
    EARTH(1.5,1,0.5,1,"earthdude.png"),
    AIR(1,0.9,1,1.6,"airdude.png"),
    NONE(1,1,1,1,"none");
    
    private double healthMultiplier;
    private double manaMultiplier;
    private double damageMultiplier;
    private double speedMultiplier;
    private Obrazok picture;
    
    Element(double healthMultiplier, double manaMultiplier, double damageMultiplier, double speedMultiplier, String pictureFilePath) {
        this.healthMultiplier = healthMultiplier;
        this.manaMultiplier = manaMultiplier;
        this.damageMultiplier = damageMultiplier;
        this.speedMultiplier = speedMultiplier;
        if(!pictureFilePath.equals("none")){
            this.picture = new Obrazok("files/obrazky/" + pictureFilePath);
        }
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
    
    public Obrazok getPicture() {
        return this.picture;
    }
}
