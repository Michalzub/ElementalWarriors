import java.util.Random;
/**
 *  Samotný Item ktorý sa bude ukladať do hráčovho inventára.
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public class Item {

    private ItemType typ;

    /**
     *   
     *   Vytvorí náhodný item.
     *
     */
    public Item() {
        Random r = new Random();
        int cisloItemu = r.nextInt(this.typ.values().length);
        this.typ = this.typ.values()[cisloItemu];
    }

    /**
     *   Nastaví typ itemu.
     */
    public void setTyp(String pozadovanyTyp) {
        switch (pozadovanyTyp) {
            case "HEALTHSMALL":
                this.typ = ItemType.HEALTHSMALL;
                break;
            case "HEALTHLARGE":
                this.typ = ItemType.HEALTHLARGE;
                break;
            case "MANASMALL":
                this.typ = ItemType.MANASMALL;
                break;
            case "MANALARGE":
                this.typ = ItemType.MANALARGE;
                break;
            default:
                System.out.println("NO A MAME TU CISLO");
        }
    }

    public String getName() {
        return this.typ.getName();
    }

    public int getSila() {
        return this.typ.getSila();
    }

    public ItemType getType() {
        return this.typ;
    }
}
