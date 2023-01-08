import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

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
    private int enemyTotal;
    
    /**
     * Konštruktor dostane miesto úložiska, podľa ktorého vybere súbor z kadiaľ má brať dáta.
     * @param filePath cesta k zloske so suborom
     * @param menuNavigator potrebny pre ziskanie zvoleneho objektu pri combate
     */
    public Game(String filePath, MenuNavigator menuNavigator) throws FileNotFoundException {
        this.filePath = filePath;
        this.mode = GameMode.EXPLORATION;
        this.map = new Map(this.filePath + "mapa.txt");
        this.player = new Player(this.filePath + "playerData.txt");
        this.menuNavigator = menuNavigator;
        
        this.enemyTotal = this.map.getEnemyTotal();
    }
    
    /**
     * zmení mod, skryje hraca, mapu vytvorí nepriatela a zapne combat
     * alebo ked sa skonci combat ukaze mapu a hraca
     */
    public void changeMode()  {
        if (this.mode == GameMode.EXPLORATION) {
            
            this.mode = GameMode.COMBAT;
            this.player.hidePlayer();
            this.map.hideMap();
            
            Random r = new Random();
            int randomNumber = r.nextInt(EnemyGroups.values().length);
            EnemyParty tempEnemyParty = new EnemyParty(EnemyGroups.values()[randomNumber]);
            
            this.player.hidePlayer();
            
            this.combatSupervisor = new CombatSupervisor(this.player, tempEnemyParty, this.menuNavigator);

            
            
        } else if (this.mode == GameMode.COMBAT) {
            this.enemyTotal -= 1;
            if (this.enemyTotal <= 0) {
                System.exit(0);
            }
            this.mode = GameMode.EXPLORATION;
            this.menuNavigator.setMenuType(MenuType.NOMENU);
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
    
    /**
     * vrati hraca
     * @return Player
     */
    public Player getPlayer() {
        return this.player;
    }
    
    /**
     * Metoda zisti co sa nachadza na dalsej pozicii podla smeru hraca
     * pri rock sa hrac nepohne
     * pri chest hrac sa posunie, premeni policko na grass a dostane nahodny item,
     * 
     * @param distanceX posun po X osi bud 1, -1 alebo 0
     * @param distanceY posun po Y osi bud 1, -1 alebo 0
     * 
     * @return SpaceType vrati typ policka na ktore sa chce posunut
     */
    public SpaceType checkAndMove(int distanceX, int distanceY) {
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
    
    /**
     * vrati mod hry
     * @return GameMode mode
     */
    public GameMode getMode() {
        return this.mode;
    }
    
    /**
     * skryje pozostatky obrazkov z mapy a hraca
     */
    public void hideRemnants() {
        this.player.hidePlayer();
        this.map.hideMap();
    }
    
    /**
     * zobrazi mapu a hraca
     */
    public void showExploration() {
        this.map.showMap();
        this.player.showPlayer();
    }
    
    /**
     * vrati spravcu combatu
     * @return CombatSupervisor
     */
    public CombatSupervisor getCombatSupervisor() {
        return this.combatSupervisor;
    }
}
