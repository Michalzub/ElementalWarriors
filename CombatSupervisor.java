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
            this.turnReadyCharacters = this.getSortedList(this.turnReadyCharacters);
            for(CharacterTurn character : this.turnReadyCharacters) {
                if(character.isPlayerCharacter()){
                    this.playerTurn(character.getPlayerCharacter());
                } else {
                    this.enemyTurn(character.getEnemyCharacter());
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
    
    public void playerTurn(PlayerCharacter character) {
        
    }
    
    public void enemyTurn(EnemyCharacter character) {
        
    }
}
