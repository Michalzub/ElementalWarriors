
/**
 * Enum uschováva každý typ tlačítka ktorý sa nachádza v hre pre použitie v menu
 * obsahuje dva obrazky jeden ked tlacitko nieje vybrate a druhy ked je vybrate
 * 
 * @author MichalZúbek
 * @version 0.9
 */
public enum MenuObject {
    /**
     * tlacitko nacitat hru
     */
    LOADGAME("loadGameUnselected.png","loadGameSelected.png",250,220),
    
    /**
     * tlacitko nova hra
     */
    NEWGAME("newGameUnselected.png","newGameSelected.png",250,280),
    
    /**
     * tlacitko vypnut hru
     */
    EXITGAME("exitGameUnselected.png","exitGameSelected.png",250,340),
    
    /**
     * tlacitko utok
     */
    ATTACK("attackUnselected.png","attackSelected.png",410,90),
    
    /**
     * tlacitko obrana
     */
    GUARD("guardUnselected.png","guardSelected.png",410,140),
    
    /**
     * tlacitko elemental hit
     */
    ELEMENTALHIT("elementalHitUnselected.png","elementalHitSelected.png",410,190),
    
    /**
     * tlacitko items
     */
    ITEMS("itemsUnselected.png","itemsSelected.png",410,290),
    
    /**
     * tlacitko maly health potion
     */
    SMALLHP("smallHPUnselected.png","smallHPSelected.png",410,90),
    
    /**
     * tlacitko velky health potion
     */
    LARGEHP("largeHPUnselected.png","largeHPSelected.png",410,140),
    
    /**
     * tlacitko maly mana potion
     */
    SMALLMP("smallMPUnselected.png","smallMPSelected.png",410,190),
    
    /**
     * tlacitko velky mana potion
     */
    LARGEMP("largeMPUnselected.png","largeMPSelected.png",410,240),
    
    /**
     * tlacitko pokracovat
     */
    CONTINUE("continueUnselected.png","continueSelected.png",250,220),
    
    /**
     * tlacitko ulozit hru
     */
    SAVEGAME("saveGameUnselected.png","saveGameSelected.png",250,280),
    
    /**
     * tlacitko naspat do menu
     */
    BACKTOMAINMENU("backToMainMenuUnselected.png","backToMainMenuSelected.png",250,340);
    
    private Obrazok unselectedPicture;
    private Obrazok selectedPicture;
    
    MenuObject(String unselected, String selected, int posX, int posY) {
        String filePath = "files/obrazky/menu/";
        this.unselectedPicture = new Obrazok(filePath + unselected);
        this.unselectedPicture.zmenPolohu(posX, posY);
        this.selectedPicture = new Obrazok(filePath + selected);
        this.selectedPicture.zmenPolohu(posX, posY);
    }
    
    /**
     * vrati obrazok unselectedPicture
     * @return Obrazok unselectedPicture
     */
    public Obrazok getUnselectedPicture() {
        return this.unselectedPicture;
    }
    
    /**
     * vrati obrazok selectedPicture
     * @return Obrazok selectedPicture
     */
    public Obrazok getSelectedPicture() {
        return this.selectedPicture;
    }
}
