
/**
 * Uschováva rôzne typy menu ktore mozno zobrazit a navigovat v hre.
 * Má jeho obrázok a súradnice.
 * 
 * @author MichalZúbek
 * @version 0.9
 */
public enum MenuType {
    /**
     * ked nechceme zobrazit ziadne menu
     */
    NOMENU("none", 0, 0),
    
    /**
     * hlavne menu
     */
    MAINMENU("files/obrazky/menu/mainMenu.png", 250, 250),
    
    /**
     * menu na pouzitie pri boji
     */
    COMBATMENU("files/obrazky/menu/combatMenu.png", 405, 250),
    
    /**
     * menu na pouzitie v boji po rozkliknuty kolonky items
     */
    ITEMMENU("files/obrazky/menu/combatMenu.png", 405, 250),
    
    /**
     * menu na pozastevenie hry
     */
    PAUSEMENU("files/obrazky/menu/mainMenu.png", 250, 250);
    
    private Obrazok menuBackground;
    
    MenuType(String menuBackgroundFile, int posX, int posY) {
        if (!menuBackgroundFile.equals("none")) {
            this.menuBackground = new Obrazok(menuBackgroundFile);
            this.menuBackground.zmenPolohu(posX, posY);
        }
    }
    
    /**
     * vrati pozadie menu
     * @return Obrazok menuBackground
     */
    public Obrazok getMenuBackground() {
        return this.menuBackground;
    }
}