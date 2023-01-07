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
    */
    public void drawPicture(int posX, int posY) {
        this.picture.zmenPolohu(posX + 25, posY + 25);
        this.picture.zobraz();
    }
    
    public Obrazok getPicture() {
        return this.picture;
    }
    
    public void changeToGrass() {
        /**
         *  Zmení políčko na grass typ.
         */
        this.spaceType = this.spaceType.GRASS;
        this.picture.zmenObrazok(this.spaceType.getPictureFilePath());
    }
    
    public SpaceType getType() {
        return this.spaceType;
    }
}
