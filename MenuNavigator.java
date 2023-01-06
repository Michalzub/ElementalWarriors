import java.util.ArrayList;
/**
 * Write a description of class MenuNavigator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuNavigator {
    private ArrayList<MenuObjectType> menuObjectList;
    private MenuObjectType selectedMenuObject;
    private Menu menu;
    private int objectSelector;
    public MenuNavigator(Menu menu) {
        this.objectSelector = 0;
        this.menu = menu;
        this.menuObjectList = this.menu.getMenuObjectList();
        this.selectedMenuObject = this.menuObjectList.get(this.objectSelector);
        System.out.println(this.selectedMenuObject);
    }
    
    public void changeSelectedMenuObject(int direction) {
        this.objectSelector += direction;
        if(this.objectSelector < 0) {
            this.objectSelector = this.menuObjectList.size() - 1;
        } else if(this.objectSelector >= this.menuObjectList.size()) {
            this.objectSelector = 0;
        }
        this.selectedMenuObject = this.menuObjectList.get(this.objectSelector);
        System.out.println(this.selectedMenuObject);
    }
    
    public MenuObjectType getSelectedMenuObject() {
        return this.selectedMenuObject;
    }
    
    public void setMenuType(MenuType menuType){
        this.menu.setMenuType(menuType);
    }
    
    public MenuType getMenuType(){
        return this.menu.getMenuType();
    }
}
