
/**
 * Enumeration class MainMenum - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum MenuObjectType {
    LOADGAME("load picture"),
    NEWGAME("new pic"),
    EXITGAME("exit pic"),
    ATTACK("attack picture"),
    GUARD("guard pic"),
    ELEMENTALHIT("elehit pic"),
    ELEMENTALEFFECT("elefect picture"),
    ITEMS("item pic"),
    SMALLHP("smalhp picture"),
    LARGEHP("larhp pic"),
    SMALLMP("smana pic"),
    LARGEMP("lmana picture"),
    CONTINUE("conti pic"),
    SAVEGAME("save pic"),
    BACKTOMAINMENU("backtomm picture");
    
    private String picture;
    
    MenuObjectType(String picture) {
        this.picture = picture;
    }
    
    public String getPicture() {
        return this.picture;
    }
}
