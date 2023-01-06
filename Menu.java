import java.util.ArrayList;
/**
 * Write a description of class MenuLmao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu {
    private ArrayList<MenuObjectType> menuObjectList;
    private MenuType menuType;
    public Menu() {
        this.menuType = MenuType.MAINMENU;
        this.menuObjectList = new ArrayList<MenuObjectType>();
        this.menuBuild();
    }
    
    public void menuBuild() {
        switch(this.menuType) {
            case MAINMENU:
                this.menuObjectList.clear();
                this.menuObjectList.add(MenuObjectType.LOADGAME);
                this.menuObjectList.add(MenuObjectType.NEWGAME);
                this.menuObjectList.add(MenuObjectType.EXITGAME);
                
                break;
            case COMBATMENU:
                this.menuObjectList.clear();
                this.menuObjectList.add(MenuObjectType.ATTACK);
                this.menuObjectList.add(MenuObjectType.GUARD);
                this.menuObjectList.add(MenuObjectType.ELEMENTALHIT);
                this.menuObjectList.add(MenuObjectType.ELEMENTALEFFECT);
                this.menuObjectList.add(MenuObjectType.ITEMS);
                break;
            case ITEMMENU:
                this.menuObjectList.clear();
                this.menuObjectList.add(MenuObjectType.SMALLHP);
                this.menuObjectList.add(MenuObjectType.LARGEHP);
                this.menuObjectList.add(MenuObjectType.SMALLMP);
                this.menuObjectList.add(MenuObjectType.LARGEMP);
                break;
            case PAUSEMENU:
                this.menuObjectList.clear();
                this.menuObjectList.add(MenuObjectType.CONTINUE);
                this.menuObjectList.add(MenuObjectType.SAVEGAME);
                this.menuObjectList.add(MenuObjectType.BACKTOMAINMENU);
                break;
        }
    }
    
    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
        this.menuBuild();
    }
    
    public ArrayList<MenuObjectType> getMenuObjectList() {
        return this.menuObjectList;
    }
    
    public MenuType getMenuType() {
        return this.menuType;
    }
    
}
