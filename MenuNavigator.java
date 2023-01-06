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
    public MenuNavigator() {
        this.menu = new Menu();
        this.menuObjectList = this.menu.getMenuObjectList();
        this.selectedMenuObject = this.menuObjectList.get(0); 
    }
}
