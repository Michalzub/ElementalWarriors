
/**
 * Enumeration class Menus - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum MenuType {
    NOMENU("none",0,0),
    MAINMENU("files/obrazky/menu/mainMenu.png",250,250),
    COMBATMENU("files/obrazky/menu/combatMenu.png",405,250),
    ITEMMENU("files/obrazky/menu/combatMenu.png",405,250),
    PAUSEMENU("files/obrazky/menu/mainMenu.png",250,250);
    
    private Obrazok menuBackground;
    
    MenuType(String menuBackgroundFile,int posX, int posY) {
        if(!menuBackgroundFile.equals("none")){
            this.menuBackground = new Obrazok(menuBackgroundFile);
            this.menuBackground.zmenPolohu(posX, posY);
        }
    }
    
    public Obrazok getMenuBackground() {
        return this.menuBackground;
    }
}