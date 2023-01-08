import java.util.ArrayList;
/**
 * Trieda menu sa stará o jeho stavbu a zmeny.
 * Na začiatku hry je vždy jeho typ MainMenu
 * 
 * @author MichalZúbek
 * @version 0.9
 */
public class Menu {
    private ArrayList<MenuObject> menuObjectList;
    private MenuType menuType;
    public Menu() {
        this.menuType = MenuType.MAINMENU;
        this.menuObjectList = new ArrayList<MenuObject>();
        this.menuBuild();
    }
    
    /**
    * Metoda menuBuild postavá menu podla jeho typu tak že do neho pridá tlačítkové objekty
    * ak už menu predtým existovalo vymení jeho tlačítkove objekty
    */
    public void menuBuild() {
        if(this.menuType != MenuType.NOMENU) {
            switch(this.menuType) {
                case MAINMENU:
                    this.menuObjectList.clear();
                    this.menuObjectList.add(MenuObject.LOADGAME);
                    this.menuObjectList.add(MenuObject.NEWGAME);
                    this.menuObjectList.add(MenuObject.EXITGAME);
                    break;
                case COMBATMENU:
                    this.menuObjectList.clear();
                    this.menuObjectList.add(MenuObject.ATTACK);
                    this.menuObjectList.add(MenuObject.GUARD);
                    this.menuObjectList.add(MenuObject.ELEMENTALHIT);
                    this.menuObjectList.add(MenuObject.ITEMS);
                    break;
                case ITEMMENU:
                    this.menuObjectList.clear();
                    this.menuObjectList.add(MenuObject.SMALLHP);
                    this.menuObjectList.add(MenuObject.LARGEHP);
                    this.menuObjectList.add(MenuObject.SMALLMP);
                    this.menuObjectList.add(MenuObject.LARGEMP);
                    break;
                case PAUSEMENU:
                    this.menuObjectList.clear();
                    this.menuObjectList.add(MenuObject.CONTINUE);
                    this.menuObjectList.add(MenuObject.SAVEGAME);
                    this.menuObjectList.add(MenuObject.BACKTOMAINMENU);
                    break;
            }
            this.menuType.getMenuBackground().zobraz();
            for(MenuObject object : this.menuObjectList) {
                object.getUnselectedPicture().zobraz();
            }
        }
        
    }
    
    /**
    * Skryje menu
    */
    public void menuHide() {
        if(this.menuType != MenuType.NOMENU) {
            this.menuType.getMenuBackground().skry();
            for(MenuObject object : this.menuObjectList) {
                object.getUnselectedPicture().skry();
                object.getSelectedPicture().skry();
            }
        }
    }
    
    /**
    * zmení typ menu a postavá ho
    */
    public void setMenuType(MenuType menuType) {
        this.menuHide();
        this.menuType = menuType;
        this.menuBuild();
    }
    
    public ArrayList<MenuObject> getMenuObjectList() {
        return this.menuObjectList;
    }
    
    public MenuType getMenuType() {
        return this.menuType;
    }
}
