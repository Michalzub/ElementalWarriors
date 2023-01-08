import java.util.Random;
/**
 *  Samotný Item ktorý sa bude ukladať do hráčovho inventára.
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public class Item {

    private ItemType itemType;

    /**  
     *   Vytvorí náhodný item a nastaví mu typ.
     */
    public Item() {
        Random r = new Random();
        int cisloItemu = r.nextInt(this.itemType.values().length);
        this.itemType = this.itemType.values()[cisloItemu];
    }

    /**
     *   podla pozadovaneho typu itemu vo forme stringu nastavi typ itemu
     *   @param pozadovanyTyp string s nazvom itemu
     */
    public void setTyp(String pozadovanyTyp) {
        switch (pozadovanyTyp) {
            case "SMALLHP":
                this.itemType = ItemType.SMALLHEALTHPOTION;
                break;
            case "LARGEHP":
                this.itemType = ItemType.LARGEHEALTHPOTION;
                break;
            case "SMALLMP":
                this.itemType = ItemType.SMALLMANAPOTION;
                break;
            case "LARGEMP":
                this.itemType = ItemType.LARGEMANAPOTION;
                break;
            default:
                return;
        }
    }
    
    /**
     * vrati nazov itemu
     * @return String name
     */
    public String getName() {
        return this.itemType.getName();
    }
    
    /**
     * vrati silu itemu
     * @return double strength
     */
    public double getStrength() {
        return this.itemType.getStrength();
    }
    
    /**
     * vrati typ itemu
     * @return ItemType
     */
    public ItemType getType() {
        return this.itemType;
    }
}
