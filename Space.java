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
    
    /**
     * Postava a nakresli policko
     * @param posX int - jeho pozicia na X osi
     * @param posX int - jeho pozicia na X osi
     * @param spaceType SpaceType - jeho typ
     */
    public Space(int posX, int posY, SpaceType spaceType) {
        this.spaceType = spaceType;
        this.picture = new Obrazok(this.spaceType.getPictureFilePath());
        this.drawPicture(posX, posY);
    }
    
    /**
    *  Zmení polohu obrázku a zobrazí ho.
    *  @param posX int - pozícia X na ktorej sa má zobraziť
    *  @param posY int - pozícia Y na ktorej sa má zobraziť
    */
    public void drawPicture(int posX, int posY) {
        this.picture.zmenPolohu(posX + 25, posY + 25);
        this.picture.zobraz();
    }
    
    /**
    *  Zmení políčko na grass typ.
    */
    public void changeToGrass() {
        this.spaceType = this.spaceType.GRASS;
        this.picture.zmenObrazok(this.spaceType.getPictureFilePath());
    }
    
    /**
     * vrati typ policka
     * @return SpaceType spaceType
     */
    public SpaceType getType() {
        return this.spaceType;
    }
    
    /**
     * Vrati obrazok policka
     * @return Obrazok picture
     */
    public Obrazok getPicture() {
        return this.picture;
    }
}
