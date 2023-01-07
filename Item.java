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
     *   
     *   Vytvorí náhodný item.
     *
     */
    public Item() {
        Random r = new Random();
        int cisloItemu = r.nextInt(this.itemType.values().length);
        this.itemType = this.itemType.values()[cisloItemu];
    }

    /**
     *   Nastaví typ itemu.
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

    public String getName() {
        return this.itemType.getName();
    }

    public double getStrength() {
        return this.itemType.getStrength();
    }

    public ItemType getType() {
        return this.itemType;
    }
}
