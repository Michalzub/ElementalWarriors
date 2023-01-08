import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.IOException;  // Import this class to handle errors
import java.util.Scanner;
import java.lang.InterruptedException;
/**
 * Manažuje ovládanie hráča vytvára hru,
 * @param menuNavigator menuNavigator aby hrac mohol pouzivat menu
 * 
 * @author Michal Zúbek 
 * @version 0.9
 */
public class PlayerControls {
    private MenuNavigator menuNavigator;
    private MenuType menuType;
    private Game game;
    private Player player;
    private CombatSupervisor combatSupervisor;
    private Targeting targeting;
    private TargetingMode targetingMode;
    private String selectedMove;
    
    public PlayerControls(MenuNavigator menuNavigator) {
        this.menuNavigator = menuNavigator;
        this.targetingMode = TargetingMode.NOTTARGETING;
    }
    
    /**
    * Akcie ktoré sa vykonajú pri stlačený tlačítka X.
    * Ak je v targeting mode vrati sa z neho von.
    * Dokáže otvorit pause menu a vratit sa z items naspat do combat menu
    */
    public void xKey(){
        this.menuNavigator.getSelectedMenuObject().getUnselectedPicture().skry();
        if (this.targetingMode != TargetingMode.NOTTARGETING) { // ak je v targeting mode zruši targeting
            this.targeting.hideTargeting();
            this.targetingMode = TargetingMode.NOTTARGETING;
            this.targeting.setTargettingMode(this.targetingMode);
        } else {
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
    }
    
    public void space() throws FileNotFoundException, IOException {
        if (this.targetingMode != TargetingMode.NOTTARGETING) {
            System.out.println("before Action");
            this.combatSupervisor.action(this.targeting.getAllyTarget(), this.targeting.getEnemyTarget(), this.selectedMove, this.targetingMode);
            
            this.targetingMode = TargetingMode.NOTTARGETING;
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
                    this.selectedMove = "attack";
                    this.combatSupervisor.roundStart();
                    this.targetingMode = TargetingMode.ENEMYTARGETING;
                    this.combatSupervisor.startTargetting(this.targetingMode);
                    this.targeting = this.combatSupervisor.getTargeting();
                    
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
            this.targeting.changeTarget(-1);
        } else if(this.game.getMode() == GameMode.EXPLORATION) {
            if(this.game.checkAndMove(-1, 0) == SpaceType.ENEMY) {
                this.combatSupervisor = this.game.getCombatSupervisor();
            }
        }
    }
    
    public void upArrow() {
        if(this.targetingMode != TargetingMode.NOTTARGETING){
            return;
        } else if(this.menuNavigator.getMenuType() != MenuType.NOMENU) {
            this.menuNavigator.changeSelectedMenuObject(-1);
        } else if(this.game.getMode() == GameMode.EXPLORATION) {
            if(this.game.checkAndMove(0, -1) == SpaceType.ENEMY) {
                this.combatSupervisor = this.game.getCombatSupervisor();
            }
        }
    }
    
    public void rightArrow() {
        if(this.targetingMode != TargetingMode.NOTTARGETING){
            this.targeting.changeTarget(1);
        } else if(this.game.getMode() == GameMode.EXPLORATION) {
            if(this.game.checkAndMove(1, 0) == SpaceType.ENEMY) {
                this.combatSupervisor = this.game.getCombatSupervisor();
            }
        }
    }
    
    public void downArrow() {
        if(this.targetingMode != TargetingMode.NOTTARGETING){
            return;
        } else if(this.menuNavigator.getMenuType() != MenuType.NOMENU){
            this.menuNavigator.changeSelectedMenuObject(1);
        } else if(this.game.getMode() == GameMode.EXPLORATION) {
            if(this.game.checkAndMove(0, 1) == SpaceType.ENEMY) {;
                this.combatSupervisor = this.game.getCombatSupervisor();
            }
       }
    }
}
