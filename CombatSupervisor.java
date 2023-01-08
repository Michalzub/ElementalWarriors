import java.util.ArrayList;
/**
 * Write a description of class CombatSupervisor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CombatSupervisor {
    private EnemyParty enemyParty;
    private Player player;
    private ArrayList<EnemyCharacter> enemyCombattants;
    private PlayerCharacter[] playerCombattants;
    private ArrayList<CharacterTurn> allCombattants;
    private ArrayList<CharacterTurn> turnReadyCharacters;
    private int playerCount;
    private int enemyCount;
    public CombatSupervisor(Player player, EnemyParty enemyParty) {
        this.playerCount = 0;
        this.enemyCount = 0;
        this.enemyParty = enemyParty;
        this.player = player;
        this.playerCombattants = this.player.getCombattants();
        this.enemyCombattants = this.enemyParty.getEnemyParty();
        this.allCombattants = new ArrayList<CharacterTurn>();
        this.turnReadyCharacters = new ArrayList<CharacterTurn>();
        
        for(PlayerCharacter character : this.playerCombattants) {
            this.allCombattants.add(new CharacterTurn(character, null));
            this.playerCount += 1;
        }
        for(EnemyCharacter character : this.enemyCombattants) {
            this.allCombattants.add(new CharacterTurn(null, character));
        }
    }
    
    public void rollInitiative() {
        while(this.playerCombattants.length > 0 || this.enemyCombattants.size() > 0){
            for(CharacterTurn character : this.allCombattants) {
                if(character.addDistance() ) {
                    this.turnReadyCharacters.add(character);
                }
            }
            
            
            for(CharacterTurn character : this.turnReadyCharacters) {
                System.out.println(character.getDistance());
            }
        }
    }
}
