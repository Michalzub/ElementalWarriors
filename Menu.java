import java.util.ArrayList;
/**
 * Write a description of class MenuLmao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu {
    private ArrayList<MenuObject> menuObjectList;
    private MenuType menuType;
    public Menu() {
        this.menuType = MenuType.MAINMENU;
        this.menuObjectList = new ArrayList<MenuObject>();
        this.menuBuild();
    }
    
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
                    this.menuObjectList.add(MenuObject.ELEMENTALEFFECT);
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
    
    public void menuHide() {
        if(this.menuType != MenuType.NOMENU) {
            this.menuType.getMenuBackground().skry();
            for(MenuObject object : this.menuObjectList) {
                object.getUnselectedPicture().skry();
                object.getSelectedPicture().skry();
            }
        }
    }
    
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
    
    public void hideRemnants() {
        
    }
}
