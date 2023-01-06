
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
    HEALTHSMALL("Small Health Potion", 50),
    /**
     * Velký potion doplňujúci život Sila (Sila 100).
     */
    HEALTHLARGE("Large Health Potion", 100),
    /**
     * Malý potion doplňujúci manu Sila (Sila 50).
     */
    MANASMALL("Small Mana Potion", 50),
    /**
     * Malý potion doplňujúci manu (Sila 100).
     */
    MANALARGE("Large Mana Potion", 100);

    private String name;
    private int sila;

    ItemType (String name, int sila) {
        this.name = name;
        this.sila = sila;
    }

    public String getName() {
        return this.name;
    }

    public int getSila() {
        return this.sila;
    }
}
