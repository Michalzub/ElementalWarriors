
/**
 * Trieda s main metódou
 * 
 * @author Michal Zúbek
 * @version 0.9
 */
public class ElementalWarriors { 
    public static void main(String[] args) {
        Menu menu = new Menu();
        MenuNavigator menuNavigator = new MenuNavigator(menu);
        PlayerControls playerControls = new PlayerControls(menuNavigator);
        Manazer manazer = new Manazer();
        manazer.spravujObjekt(playerControls);
    }
}
