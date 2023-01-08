import java.util.ArrayList;
/**
 * Enumeration class element - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Element {
    FIRE(0.7,0.9,1.3,1.1,"firedude.png",0.7,0.5,1.3,1),
    WATER(0.85,1.3,0.9,1,"waterdude.png",1.3,0.7,0.5,1),
    EARTH(1.5,1,0.5,1,"earthdude.png",1,1.3,0.7,1),
    AIR(1,0.9,1,1.6,"airdude.png",1.3,1,1,0.7),
    NONE(1,1,1,1,"none", 1,1,1,1);
    
    private double healthMultiplier;
    private double manaMultiplier;
    private double damageMultiplier;
    private double speedMultiplier;
    private Obrazok picture;
    private double fireMatchup;
    private double waterMatchup;
    private double earthMatchup;
    private double airMatchup;
    
    Element(double healthMultiplier, double manaMultiplier, double damageMultiplier, double speedMultiplier, String pictureFilePath, double fireMatchup, double waterMatchup, double earthMatchup, double airMatchup) {
        this.healthMultiplier = healthMultiplier;
        this.manaMultiplier = manaMultiplier;
        this.damageMultiplier = damageMultiplier;
        this.speedMultiplier = speedMultiplier;
        this.fireMatchup = fireMatchup;
        this.waterMatchup = waterMatchup;
        this.earthMatchup = earthMatchup;
        this.airMatchup = airMatchup;
        if(!pictureFilePath.equals("none")){
            this.picture = new Obrazok("files/obrazky/" + pictureFilePath);
        }
    }
    
    public double calculate(Double damage, Element targetElement) {
        switch(targetElement) {
            case FIRE:
                return damage * fireMatchup;
            case WATER:
                return damage * waterMatchup;
            case EARTH:
                return damage * earthMatchup;
            case AIR:
                return damage * airMatchup;
            default:
                return damage;
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
