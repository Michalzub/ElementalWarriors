import java.util.ArrayList;
/**
 * Write a description of class MenuNavigator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuNavigator {
    private ArrayList<MenuObject> menuObjectList;
    private MenuObject selectedMenuObject;
    private Menu menu;
    private int objectSelector;
    public MenuNavigator(Menu menu) {
        
        this.menu = menu;
        this.menuObjectList = this.menu.getMenuObjectList();
        this.initialSelectedObject();
        System.out.println(this.selectedMenuObject);
    }
    
    public void initialSelectedObject() {
        this.objectSelector = 0;
        this.selectedMenuObject = this.menuObjectList.get(this.objectSelector);
        this.selectedMenuObject.getUnselectedPicture().skry();
        this.selectedMenuObject.getSelectedPicture().zobraz();
    }
    
    public void highlightSelectedObject() {
        this.selectedMenuObject.getUnselectedPicture().skry();
        this.selectedMenuObject.getSelectedPicture().zobraz();
    }
    
    public void hideSelectedObject() {
        this.selectedMenuObject.getSelectedPicture().skry();
    }
    
    public void changeSelectedMenuObject(int direction) {
        this.selectedMenuObject.getUnselectedPicture().zobraz();
        this.selectedMenuObject.getSelectedPicture().skry();
        this.objectSelector += direction;
        if(this.objectSelector < 0) {
            this.objectSelector = this.menuObjectList.size() - 1;
        } else if(this.objectSelector >= this.menuObjectList.size()) {
            this.objectSelector = 0;
        }
        this.selectedMenuObject = this.menuObjectList.get(this.objectSelector);
        this.highlightSelectedObject();
    }
    
    public MenuObject getSelectedMenuObject() {
        return this.selectedMenuObject;
    }
    
    public void setMenuType(MenuType menuType){
        
        System.out.println(this.selectedMenuObject);
        this.selectedMenuObject.getSelectedPicture().skry();
        System.out.println("APPARENTLY IT WAS HIDDEN");
        this.menu.menuHide();
        this.menu.setMenuType(menuType);
        
    }
    
    public MenuType getMenuType(){
        return this.menu.getMenuType();
    }
}
