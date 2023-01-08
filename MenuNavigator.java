import java.util.ArrayList;
/**
* Stará sa o navigáciu v menu, uschováva práve vybraný objekt
* @param menu menu ktoré má spravovat
* 
* @author MichalZúbek
* @version 0.9
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
    
    /**
    * metoda nastavi pociatocnu hodnotu vybrateho objektu
    */
    public void initialSelectedObject() {
        this.objectSelector = 0;
        this.selectedMenuObject = this.menuObjectList.get(this.objectSelector);
        this.selectedMenuObject.getUnselectedPicture().skry();
        this.selectedMenuObject.getSelectedPicture().zobraz();
    }
    
    /**
    * vysvieti vybratý objekt
    */
    public void highlightSelectedObject() {
        this.selectedMenuObject.getUnselectedPicture().skry();
        this.selectedMenuObject.getSelectedPicture().zobraz();
    }
    
    /**
    * skryje selectedPicture vybratého objektu
    */
    public void hideSelectedObject() {
        this.selectedMenuObject.getSelectedPicture().skry();
    }
    
    /**
    * zmení vybratý objekt cyklením cez menu
    * @param direction smer v tvare cislo do ktoreho sa ma pohnut  1 alebo -1
    */
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
    
    /**
    * nastaví typ menu
    * @param menuType pozadovany MenuType
    */
    public void setMenuType(MenuType menuType){
        this.selectedMenuObject.getSelectedPicture().skry();
        this.menu.menuHide();
        this.menu.setMenuType(menuType);
        this.initialSelectedObject();
        this.highlightSelectedObject();
    }
    
    /**
    * nastaví počiatočný objekte podla typu menu
    */
    public void setSelectedObject(MenuType menuType) {
        switch(menuType) {
            case MAINMENU:
                this.selectedMenuObject = MenuObject.LOADGAME;
                break;
            case PAUSEMENU:
                this.selectedMenuObject = MenuObject.CONTINUE;
                break;
            case ITEMMENU:
                this.selectedMenuObject = MenuObject.SMALLHP;
                break;
            case COMBATMENU:
                this.selectedMenuObject = MenuObject.ATTACK;
                break;
        }
    }
        
    /**
     * vrati typ menu ktore ovlada
     * @return MenuType
     */
    public MenuType getMenuType(){
        return this.menu.getMenuType();
    }
    
    /**
     * vrati typ vybratého tlačítka
     * @return MenuObject
     */
    public MenuObject getSelectedMenuObject() {
        return this.selectedMenuObject;
    }
}
