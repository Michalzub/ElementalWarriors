
/**
 *  Enum obsahuje rôzne typy itemov, ktoré majú rozdielne vlastnosti.
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public enum ItemType {
    /**
     * Malý potion doplňujúci život (Sila 50).
     */
    SMALLHEALTHPOTION("Small Health Potion", 50),
    /**
     * Velký potion doplňujúci život Sila (Sila 100).
     */
    LARGEHEALTHPOTION("Large Health Potion", 100),
    /**
     * Malý potion doplňujúci manu Sila (Sila 50).
     */
    SMALLMANAPOTION("Small Mana Potion", 50),
    /**
     * Velký potion doplňujúci manu (Sila 100).
     */
    LARGEMANAPOTION("Large Mana Potion", 100);

    private String name;
    private double strength;

    ItemType (String name, double strength) {
        this.name = name;
        this.strength = strength;
    }
    
    /**
     * vrati nazov itemu
     * @return String name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * vrati silu itemu
     * @return double strength
     */
    public double getStrength() {
        return this.strength;
    }
}
