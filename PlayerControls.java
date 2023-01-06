import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.IOException;  // Import this class to handle errors
import java.util.Scanner;
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
    private Hra hra;
    private Player player;
    
    public PlayerControls(MenuNavigator menuNavigator) {
        this.menuNavigator = menuNavigator;
    }
    
    public void mouseClick(){
        
    }
    
    public void xKey(){
        switch(this.menuNavigator.getMenuType()){
            case NOMENU:
                this.menuNavigator.setMenuType(MenuType.PAUSEMENU);
                break;
            case PAUSEMENU:
                this.menuNavigator.setMenuType(MenuType.NOMENU);
                break;
            case ITEMMENU:
                this.menuNavigator.setMenuType(MenuType.COMBATMENU);
        }
    }
    
    public void space() throws FileNotFoundException, IOException {
        if(this.menuNavigator.getMenuType() != MenuType.NOMENU){
            switch(this.menuNavigator.getSelectedMenuObject()) {
                case LOADGAME:
                
                    System.out.println("LOADGAME PRESSED");
                    this.menuNavigator.setMenuType(MenuType.NOMENU);
                    File mapa = new File("files/saves/mapa.txt");
                    File playerData = new File("files/saves/playerData.txt");
                    Scanner citacMapa = new Scanner(mapa);
                    Scanner citacPlayer = new Scanner(playerData);
                    if (citacMapa.hasNext() && citacPlayer.hasNext()) {
                        this.hra = new Hra("files/saves/");
                        return;
                    }
                    this.player= this.hra.getPlayer();
                    citacMapa.close();
                    citacPlayer.close();
                    break;
                    
                case NEWGAME:
                    System.out.println("NEWGAME PRESSED");
                    this.menuNavigator.setMenuType(MenuType.NOMENU);
                    this.hra = new Hra("files/newGame/");
                    this.player= this.hra.getPlayer();
                    break;
                case EXITGAME:
                    System.out.println("EXITGAME PRESSED");
                        this.hra.saveGame();
                    System.exit(0);
                    break;
                case ATTACK:
                    System.out.println("ATTACK PRESSED");
                    
                    break;
                case GUARD:
                    System.out.println("GUARD PRESSED");
                    
                    break;
                case ELEMENTALHIT:
                    System.out.println("ELEMENTALHIT PRESSED");
                    
                    break;
                case ELEMENTALEFFECT:
                    System.out.println("ELEMENTALEFFECT PRESSED");
                    
                    break;
                case ITEMS:
                    System.out.println("ITEMS PRESSED");
                    this.menuNavigator.setMenuType(MenuType.ITEMMENU);
                    break;
                case SMALLHP:
                    System.out.println("SMALLHP PRESSED");
                    
                    break;
                case LARGEHP:
                    System.out.println("LARGEHP PRESSED");
                    
                    break;
                case SMALLMP:
                    System.out.println("SMALLMP PRESSED");
                    
                    break;
                case LARGEMP:
                    System.out.println("LARGEMP PRESSED");
                    
                    break;
                case CONTINUE:
                    System.out.println("CONTINUE PRESSED");
                    this.menuNavigator.setMenuType(MenuType.NOMENU);
                    break;
                case SAVEGAME:
                    System.out.println("SAVEGAME PRESSED");
                    
                    break;
                case BACKTOMAINMENU:
                    System.out.println("BACKTOMAINMENU PRESSED");
                    this.menuNavigator.setMenuType(MenuType.MAINMENU);
                    break;
            }
        }
    }
    
    public void leftArrow(){
        if(isTargeting){
            
        } else{
            this.player.checkAndMove(-1, 0);
        }
    }
    
    public void upArrow(){
        if(this.menuNavigator.getMenuType() != MenuType.NOMENU){
            this.menuNavigator.changeSelectedMenuObject(-1);
        } else{
            this.player.checkAndMove(0, -1);
        }
    }
    
    public void rightArrow(){
        if(isTargeting){
            
        } else{
            this.player.checkAndMove(1, 0);
        }
    }
    
    public void downArrow(){
       if(this.menuNavigator.getMenuType() != MenuType.NOMENU){
            this.menuNavigator.changeSelectedMenuObject(1);
        } else{
            this.player.checkAndMove(0, 1);
        }
    }
}
