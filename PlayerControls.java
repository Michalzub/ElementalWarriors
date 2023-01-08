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
    private MenuType menuType;
    private Game game;
    private Player player;
    private CombatSupervisor combatSupervisor;
    private Targeting targeting;
    private TargetingMode targetingMode;
    
    public PlayerControls(MenuNavigator menuNavigator) {
        this.menuNavigator = menuNavigator;
        this.targetingMode = TargetingMode.NOTTARGETING;
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
        if (this.targetingMode != TargetingMode.NOTTARGETING) {
            this.combatSupervisor.action(this.targeting.getAllyTarget(),this.targeting.getEnemyTarget(), this.menuNavigator.getSelectedMenuObject(), this.targetingMode);
            
        }else if(this.menuNavigator.getMenuType() != MenuType.NOMENU){
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
                    //this.game.saveGame();
                    System.exit(0);
                    break;
                case ATTACK:
                    System.out.println("ATTACK PRESSED");
                    
                    System.out.println("before creating there is " + this.targeting);
                    this.combatSupervisor.roundStart();
                    System.out.println(this.targetingMode);
                    this.targetingMode = TargetingMode.ENEMYTARGETING;
                    System.out.println(this.targetingMode);
                    this.combatSupervisor.startTargetting(this.targetingMode);
                    this.targeting = this.combatSupervisor.getTargeting();
                    System.out.println(this.targeting);
                    
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
    
    public void leftArrow() {
        if(this.targetingMode != TargetingMode.NOTTARGETING){
            System.out.println("before changing target");
            this.targeting.changeTarget(-1);
            System.out.println("after changing target");
        } else if(this.game.getMode() == GameMode.EXPLORATION) {
            if(this.game.checkAndMove(-1, 0) == SpaceType.ENEMY) {
                System.out.println("before the supervisor");
                this.combatSupervisor = this.game.getCombatSupervisor();
                System.out.println("after the supervisor");
            }
        }
    }
    
    public void upArrow() {
        if(this.targetingMode != TargetingMode.NOTTARGETING){
            this.targeting.changeTarget(-1);
        } else if(this.menuNavigator.getMenuType() != MenuType.NOMENU) {
            this.menuNavigator.changeSelectedMenuObject(-1);
        } else if(this.game.getMode() == GameMode.EXPLORATION) {
            if(this.game.checkAndMove(0, -1) == SpaceType.ENEMY) {
                System.out.println("before the supervisor");
                this.combatSupervisor = this.game.getCombatSupervisor();
                System.out.println("we got the supervisor");
            }
        }
    }
    
    public void rightArrow() {
        if(this.targetingMode != TargetingMode.NOTTARGETING){
            System.out.println("before changing target");
            this.targeting.changeTarget(1);
            System.out.println("after changing target");
        } else if(this.game.getMode() == GameMode.EXPLORATION) {
            if(this.game.checkAndMove(1, 0) == SpaceType.ENEMY) {
                System.out.println("before the supervisor");
                this.combatSupervisor = this.game.getCombatSupervisor();
                System.out.println("we got the supervisor");
            }
        }
    }
    
    public void downArrow() {
        if(this.targetingMode != TargetingMode.NOTTARGETING){
            this.targeting.changeTarget(-1);
        } else if(this.menuNavigator.getMenuType() != MenuType.NOMENU){
            this.menuNavigator.changeSelectedMenuObject(1);
        } else if(this.game.getMode() == GameMode.EXPLORATION) {
            if(this.game.checkAndMove(0, 1) == SpaceType.ENEMY) {
                System.out.println("before the supervisor");
                this.combatSupervisor = this.game.getCombatSupervisor();
                System.out.println("we got the supervisor");
            }
       }
    }
}
