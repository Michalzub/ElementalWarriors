/**
 *  Jednotlivé políčko na mape. 
 *  Obsahuje obrázok a jeho typ.
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public class Space {
    private SpaceType spaceType;
    private Obrazok picture;
    
    public Space(int posX, int posY, SpaceType spaceType) {
        this.spaceType = spaceType;
        this.picture = new Obrazok(this.spaceType.getPictureFilePath());
        this.drawPicture(posX, posY);
    }
    
    /**
    *  Zmení polohu obrázku a zobrazí ho.
    *  @param posX pozícia X na ktorej sa má zobraziť
    *  @param posZ pozícia Z na ktorej sa má zobraziť
    */
    public void drawPicture(int posX, int posY) {
        this.picture.zmenPolohu(posX + 25, posY + 25);
        this.picture.zobraz();
    }
    
    public Obrazok getPicture() {
        return this.picture;
    }
    
    /**
    *  Zmení políčko na grass typ.
    */
    public void changeToGrass() {
        this.spaceType = this.spaceType.GRASS;
        this.picture.zmenObrazok(this.spaceType.getPictureFilePath());
    }
    
    public SpaceType getType() {
        return this.spaceType;
    }
}
