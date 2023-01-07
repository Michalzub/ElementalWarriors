
/**
 * Enumeration class MainMenum - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum MenuObjectType {
    LOADGAME("loadGameUnselected.png","loadGameSelected.png"),
    NEWGAME("newGameUnselected.png","newGameSelected.png"),
    EXITGAME("exitGameUnselected.png","exitGameSelected.png"),
    ATTACK("attackUnselected.png","attackSelected.png"),
    GUARD("guardUnselected.png","guardSelected.png"),
    ELEMENTALHIT("elementalHitUnselected.png","elementalHitSelected.png"),
    ELEMENTALEFFECT("elementalEffectUnselected.png","elementalEffectSelected.png"),
    ITEMS("itemsUnselected.png","itemsSelected.png"),
    SMALLHP("smallHPUnselected.png","smallHPSelected.png"),
    LARGEHP("largeHPUnselected.png","largeHPSelected.png"),
    SMALLMP("smallMPUnselected.png","smallMPSelected.png"),
    LARGEMP("largeMPUnselected.png","largeMPSelected.png"),
    CONTINUE("continueUnselected.png","continueSelected.png"),
    SAVEGAME("saveGameUnselected.png","saveGameSelected.png"),
    BACKTOMAINMENU("backToMainMenuUnselected.png","backToMainMenuSelected.png");
    
    private Obrazok unselectedPicture;
    private Obrazok selectedPicture;
    
    MenuObjectType(String unselected, String selected) {
        String filePath = 
        this.unselectedPicture = new Obrazok(unselected);
        this.selectedPicture = new Obrazok(selected);fffi
    }
    
    public Obrazok getUnselectedPicture() {
        return this.unselectedPicture;
    }
}
