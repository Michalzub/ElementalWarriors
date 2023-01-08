import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.lang.InterruptedException;

/**
 * Vytvorí mapu, hráča a manažera, ktorý ich bude spravovať.
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public class Game {
    private Map map;
    private Player player;
    private GameMode mode;
    private String filePath;
    private MenuNavigator menuNavigator;
    private CombatSupervisor combatSupervisor;
    
    /**
     * Konštruktor dostane miesto úložiska, podľa ktorého vybere súbor z kadiaľ má brať dáta.
     */
    public Game(String filePath, MenuNavigator menuNavigator) throws FileNotFoundException {
        this.filePath = filePath;
        this.mode = GameMode.EXPLORATION;
        this.map = new Map(this.filePath + "mapa.txt");
        this.player = new Player(this.filePath + "playerData.txt");
        this.menuNavigator = menuNavigator;
    }
    
    public void changeMode() throws InterruptedException {
        if (this.mode == GameMode.EXPLORATION) {
            this.mode = GameMode.COMBAT;
            this.player.hidePlayer();
            this.map.hideMap();
            Random r = new Random();
            int randomNumber = r.nextInt(EnemyGroups.values().length);
            EnemyParty tempEnemyParty = new EnemyParty(EnemyGroups.values()[randomNumber]);
            this.combatSupervisor = new CombatSupervisor(this.player, tempEnemyParty, this.menuNavigator);
        } else if (this.mode == GameMode.COMBAT) {
            this.mode = GameMode.EXPLORATION;
            this.map.showMap();
            this.player.showPlayer();
        }
    }
    
    /**
     * Uloží hrú, ešte nieje dokončené
     */
    public void saveGame() throws IOException {
        for (Space[] row : this.map.getSpaceGrid()) {
            for (Space space : row) {
                int cislo = space.getType().getType();
                FileWriter pisac = new FileWriter("files/saves/mapa.txt");
                // pisac.write(_cbuf_)
                pisac.close();
            }
        } 
    }
    
    public Player getPlayer() {
        return this.player;
    }
    
    public SpaceType checkAndMove(int distanceX, int distanceY) throws InterruptedException{
        int nextX = this.player.getPlayerX() + distanceX;
        int nextY = this.player.getPlayerY() + distanceY;
        SpaceType nextType = this.map.getSpaceType(nextX, nextY);
        switch (this.map.getSpaceType(nextX, nextY)) {
            case ROCK:
                break;
            case CHEST:
                this.player.playerMove(nextX, nextY);
                this.player.addItem();
                this.map.changeToGrass(this.player.getPlayerX(), this.player.getPlayerY());
                this.player.getplayerPicture().zobraz();
                break;
            case ENEMY:
                 this.changeMode();
                 this.player.playerMove(nextX, nextY);
                 this.map.changeToGrass(this.player.getPlayerX(), this.player.getPlayerY());
                 break;
            default:
                 this.player.playerMove(nextX, nextY);
                 break;
        }
        return nextType;
    }
    
    public GameMode getMode() {
        return this.mode;
    }
    
    public void hideRemnants() {
        this.player.hidePlayer();
        this.map.hideMap();
    }
    
    public void showExploration() {
        this.player.showPlayer();
        this.map.showMap();
    }
    
    public CombatSupervisor getCombatSupervisor() {
        return this.combatSupervisor;
    }
}
