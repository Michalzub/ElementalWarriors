
/**
 * Enum uschováva každý typ tlačítka ktorý sa nachádza v hre pre použitie v menu
 * obsahuje dva obrazky jeden ked tlacitko nieje vybrate a druhy ked je vybrate
 * 
 * @author MichalZúbek
 * @version 0.9
 */
public enum MenuObject {
    LOADGAME("loadGameUnselected.png","loadGameSelected.png",250,220),
    NEWGAME("newGameUnselected.png","newGameSelected.png",250,280),
    EXITGAME("exitGameUnselected.png","exitGameSelected.png",250,340),
    ATTACK("attackUnselected.png","attackSelected.png",410,90),
    GUARD("guardUnselected.png","guardSelected.png",410,140),
    ELEMENTALHIT("elementalHitUnselected.png","elementalHitSelected.png",410,190),
    ELEMENTALEFFECT("elementalEffectUnselected.png","elementalEffectSelected.png",410,240),
    ITEMS("itemsUnselected.png","itemsSelected.png",410,290),
    SMALLHP("smallHPUnselected.png","smallHPSelected.png",410,90),
    LARGEHP("largeHPUnselected.png","largeHPSelected.png",410,140),
    SMALLMP("smallMPUnselected.png","smallMPSelected.png",410,190),
    LARGEMP("largeMPUnselected.png","largeMPSelected.png",410,240),
    CONTINUE("continueUnselected.png","continueSelected.png",250,220),
    SAVEGAME("saveGameUnselected.png","saveGameSelected.png",250,280),
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
    
    public Obrazok getUnselectedPicture() {
        return this.unselectedPicture;
    }
    public Obrazok getSelectedPicture() {
        return this.selectedPicture;
    }
}
