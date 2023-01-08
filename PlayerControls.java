import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.IOException;  // Import this class to handle errors
import java.util.Scanner;
import java.lang.InterruptedException;
/**
 * Write a description of class PlayerControls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerControls {
    private MenuNavigator menuNavigator;
    private boolean isTargeting;
    private MenuType menuType;
    private Game game;
    private Player player;
    
    public PlayerControls(MenuNavigator menuNavigator) {
        this.menuNavigator = menuNavigator;
    }
    
    public void xKey(){
        this.menuNavigator.getSelectedMenuObject().getUnselectedPicture().skry();
        
        switch(this.menuNavigator.getMenuType()){
            case NOMENU:
                this.menuNavigator.setMenuType(MenuType.PAUSEMENU);
                break;
            case PAUSEMENU:
                this.menuNavigator.setMenuType(MenuType.NOMENU);
                this.menuNavigator.hideSelectedObject();
                break;
            case ITEMMENU:
                this.menuNavigator.setMenuType(MenuType.COMBATMENU);
                break;
            default:
                break;
        }
    }
    
    public void space() throws FileNotFoundException, IOException {
        if(this.menuNavigator.getMenuType() != MenuType.NOMENU){
            switch(this.menuNavigator.getSelectedMenuObject()) {
                case LOADGAME:
                    if(this.game != null){
                        this.game.hideRemnants();
                    }
                    this.menuNavigator.hideSelectedObject();
                    this.menuNavigator.setMenuType(MenuType.NOMENU);
                    File mapa = new File("files/saves/mapa.txt");
                    File playerData = new File("files/saves/playerData.txt");
                    Scanner citacMapa = new Scanner(mapa);
                    Scanner citacPlayer = new Scanner(playerData);
                    if (citacMapa.hasNext() && citacPlayer.hasNext()) {
                        this.game = new Game("files/saves/", this.menuNavigator);
                        return;
                    } else{
                        System.out.println("FILE NOT FOUND");
                    }
                    citacMapa.close();
                    citacPlayer.close();
                    this.player = this.game.getPlayer();
                    break;  
                case NEWGAME:
                    if(this.game != null){
                        this.game.hideRemnants();
                    }
                    this.menuNavigator.hideSelectedObject();
                    this.menuNavigator.setMenuType(MenuType.NOMENU);
                    this.game = new Game("files/newGame/", this.menuNavigator);
                    this.player = this.game.getPlayer();
                    break;
                case EXITGAME:
                    this.game.saveGame();
                    System.exit(0);
                    break;
                case ATTACK:
                    System.out.println("ATTACK PRESSED");
                    
                    this.game.getCombatSupervisor().notifyWaits();
                    break;
                case GUARD:
                    System.out.println("GUARD PRESSED");
                    
                    this.game.getCombatSupervisor().notify();
                    break;
                case ELEMENTALHIT:
                    System.out.println("ELEMENTALHIT PRESSED");
                    
                    this.game.getCombatSupervisor().notify();
                    break;
                case ELEMENTALEFFECT:
                    System.out.println("ELEMENTALEFFECT PRESSED");
                    
                    this.game.getCombatSupervisor().notify();
                    break;
                case ITEMS:
                    System.out.println("ITEMS PRESSED");
                    
                    this.menuNavigator.setMenuType(MenuType.ITEMMENU);
                    break;
                case SMALLHP:
                    System.out.println("SMALLHP PRESSED");
                    
                    this.game.getCombatSupervisor().notify();
                    break;
                case LARGEHP:
                    System.out.println("LARGEHP PRESSED");
                    
                    this.game.getCombatSupervisor().notify();
                    break;
                case SMALLMP:
                    System.out.println("SMALLMP PRESSED");
                    
                    this.game.getCombatSupervisor().notify();
                    break;
                case LARGEMP:
                    System.out.println("LARGEMP PRESSED");
                    
                    this.game.getCombatSupervisor().notify();
                    break;
                case CONTINUE:
                    this.player = this.game.getPlayer();
                    this.game.showExploration();
                    this.menuNavigator.setMenuType(MenuType.NOMENU);
                    this.menuNavigator.hideSelectedObject();
                    break;
                case SAVEGAME:
                    break;
                case BACKTOMAINMENU:
                    this.menuNavigator.setMenuType(MenuType.MAINMENU);
                    break;
            }
        }
    }
    
    public void leftArrow() throws InterruptedException{
        if(isTargeting){
            
        } else if(this.game.getMode() == GameMode.EXPLORATION) {
            this.game.checkAndMove(-1, 0);
        }
    }
    
    public void upArrow() throws InterruptedException{
        if(this.menuNavigator.getMenuType() != MenuType.NOMENU) {
            this.menuNavigator.changeSelectedMenuObject(-1);
        } else if(this.game.getMode() == GameMode.EXPLORATION) {
            this.game.checkAndMove(0, -1);
        }
    }
    
    public void rightArrow() throws InterruptedException{
        if(isTargeting){
            
        } else if(this.game.getMode() == GameMode.EXPLORATION) {
            this.game.checkAndMove(1, 0);
        }
    }
    
    public void downArrow() throws InterruptedException{
       if(this.menuNavigator.getMenuType() != MenuType.NOMENU){
            this.menuNavigator.changeSelectedMenuObject(1);
       } else if(this.game.getMode() == GameMode.EXPLORATION) {
            this.game.checkAndMove(0, 1);
       }
    }
}
