/**
 * Enum element uschováva multipliere(nasobky) statov, obrazok a postavenie voči ostatným elementom
 * 
 * @author Michal Zúbek
 * @version 0.9
 */
public enum Element {
    /**
     * element ohen
     */
    FIRE(0.7, 0.9, 1.3, 1.1, "firedude.png", 0.7, 0.5, 1.3, 1),
    
    /**
     * element voda
     */
    WATER(0.85, 1.3, 0.9, 1, "waterdude.png", 1.3, 0.7, 0.5, 1),
    
    /**
     * element zem
     */
    EARTH(1.5, 1, 0.5, 1, "earthdude.png", 1, 1.3, 0.7, 1),
    
    /**
     * element vzduch
     */
    AIR(1, 0.9, 1, 1.6, "airdude.png", 1.3, 1, 1, 0.7),
    
    /**
     * ziadny element
     */
    NONE(1, 1, 1, 1, "none", 1, 1, 1, 1);
    
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
        if (!pictureFilePath.equals("none")) {
            this.picture = new Obrazok("files/obrazky/" + pictureFilePath);
        }
    }
    
    /**
     * vrati vypocitany damage na zaklade elementu
     * @return double damage
     */
    public double calculate(Double damage, Element targetElement) {
        switch (targetElement) {
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
    
    /**
     * vrati multiplier healthu
     * @return double 
     */
    public double getHealthMultiplier() {
        return this.healthMultiplier;
    }
    
    /**
     * vrati multiplier many
     * @return double 
     */
    public double getManaMultiplier() {
        return this.manaMultiplier;
    }
    
    /**
     * vrati multiplier damagu
     * @return double 
     */
    public double getDamageMultiplier() {
        return this.damageMultiplier;
    }
    
    /**
     * vrati multiplier speedu
     * @return double 
     */
    public double getSpeedMultiplier() {
        return this.speedMultiplier;
    }
    
    /**
     * vrati obrazok element postavy
     * @return Obrazok
     */
    public Obrazok getPicture() {
        return this.picture;
    }
}
