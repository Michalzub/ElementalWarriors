import java.util.ArrayList;
import java.lang.InterruptedException;

/**
 * Write a description of class CombatSupervisor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CombatSupervisor {
    private MenuNavigator menuNavigator;
    private EnemyParty enemyParty;
    private Player player;
    private ArrayList<EnemyCharacter> enemyCombattants;
    private PlayerCharacter[] playerCombattants;
    private ArrayList<CharacterTurn> allCombattants;
    private ArrayList<CharacterTurn> turnReadyCharacters;
    private int playerCount;
    private int enemyCount;
    private boolean turnInProgress;
    public CombatSupervisor(Player player, EnemyParty enemyParty, MenuNavigator menuNavigator) throws InterruptedException{
        this.menuNavigator = menuNavigator;
        this.menuNavigator.hideSelectedObject();
        this.playerCount = 0;
        this.enemyCount = 0;
        this.enemyParty = enemyParty;
        this.player = player;
        this.playerCombattants = this.player.getCombattants();
        this.enemyCombattants = this.enemyParty.getEnemyParty();
        this.allCombattants = new ArrayList<CharacterTurn>();
        this.turnReadyCharacters = new ArrayList<CharacterTurn>();
        for(PlayerCharacter character : this.playerCombattants) {
            CharacterTurn tempCharTurn = new CharacterTurn(character, null, true);
            this.allCombattants.add(tempCharTurn);
            this.playerCount += 1;
        }
        for(EnemyCharacter character : this.enemyCombattants) {
            CharacterTurn tempCharTurn = new CharacterTurn(null, character, false);
            this.allCombattants.add(tempCharTurn);
            this.enemyCount += 1;
        }
        this.rollInitiative();
    }
    
    public void rollInitiative() throws InterruptedException{
        System.out.println("We got to roll initiative");
        while(this.playerCount > 0 || this.enemyCount > 0){
            System.out.println("we are in the while loop!");
            for(CharacterTurn character : this.allCombattants) {
                if(character.addDistance() ) {
                    this.turnReadyCharacters.add(character);
                }
            }
            this.turnReadyCharacters = this.getSortedList(this.turnReadyCharacters);
            for(CharacterTurn character : this.turnReadyCharacters) {
                System.out.println(character);
                System.out.println(character.getDistance());
            }
            for(CharacterTurn character : this.turnReadyCharacters) {
                if(character.isPlayerCharacter()){
                    this.playerTurn(character.getPlayerCharacter());
                    System.out.println("player turn");
                } else {
                    this.enemyTurn(character.getEnemyCharacter());
                    System.out.println("enemy turn");
                }
            }
        }
    }
    
    public ArrayList<CharacterTurn> getSortedList(ArrayList<CharacterTurn> unsortedList) {
        ArrayList<Double> distanceOverList = new ArrayList<Double>();
        ArrayList<CharacterTurn> sortedCharacterList = new ArrayList<CharacterTurn>();
        for(CharacterTurn character : unsortedList){
            if(distanceOverList.isEmpty()) {
                distanceOverList.add(character.getDistance());
                sortedCharacterList.add(character);
            } else {
                for(int i = 0; i < distanceOverList.size(); i++) {
                    if (character.getDistance() >= distanceOverList.get(i)){
                        distanceOverList.add(i, character.getDistance());
                        sortedCharacterList.add(i, character);
                        break;
                    } else if(character.getDistance() < distanceOverList.get(i) && i == distanceOverList.size() - 1) {
                        distanceOverList.add(character.getDistance());
                        sortedCharacterList.add(character);
                    }
                }
            }
        }
        return sortedCharacterList;
    }
    
    public void playerTurn(PlayerCharacter character) throws InterruptedException{
        this.menuNavigator.setMenuType(MenuType.COMBATMENU);
        this.turnInProgress = true;
        
    }
    
    public void enemyTurn(EnemyCharacter character) throws InterruptedException{
        System.out.println("test");
    }
    
    public void notifyWaits() {
        
    }
}
