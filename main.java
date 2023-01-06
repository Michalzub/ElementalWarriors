
/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main {
    /**
     * Constructor for objects of class main
     */
    private PlayerControls playerControls;
    private MenuNavigator menuNavigator;
    private Menu menu;
    private Manazer manazer;
    public main(){
        this.menu = new Menu();
        this.menuNavigator = new MenuNavigator(this.menu);
        this.playerControls = new PlayerControls(this.menuNavigator);
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this.playerControls);
        
    }
}
