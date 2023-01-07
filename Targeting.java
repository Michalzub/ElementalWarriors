
/**
 * Write a description of class Targeting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Targeting {
    private Player player;
    private EnemyParty enemyParty;
    private PlayerCharacter[] combattants;
    private PlayerCharacter allyTarget;
    private EnemyCharacter enemyTarget;
    
    public Targeting(EnemyParty enemyParty, Player player) {
        this.player = player;
        this.enemyParty = enemyParty;
        this.combattants = this.player.getCombattants();
        
    }
    
    public void changeTarget(String direction){
        
    }
}
