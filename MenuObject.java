
/**
 * Enumeration class MainMenum - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum MenuObject {
    LOADGAME("loadGameUnselected.png","loadGameSelected.png",250,220),
    NEWGAME("newGameUnselected.png","newGameSelected.png",250,280),
    EXITGAME("exitGameUnselected.png","exitGameSelected.png",250,340),
    ATTACK("attackUnselected.png","attackSelected.png",20,90),
    GUARD("guardUnselected.png","guardSelected.png",20,140),
    ELEMENTALHIT("elementalHitUnselected.png","elementalHitSelected.png",20,190),
    ELEMENTALEFFECT("elementalEffectUnselected.png","elementalEffectSelected.png",20,240),
    ITEMS("itemsUnselected.png","itemsSelected.png",20,290),
    SMALLHP("smallHPUnselected.png","smallHPSelected.png",20,90),
    LARGEHP("largeHPUnselected.png","largeHPSelected.png",20,140),
    SMALLMP("smallMPUnselected.png","smallMPSelected.png",20,190),
    LARGEMP("largeMPUnselected.png","largeMPSelected.png",20,240),
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
