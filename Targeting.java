
/**
 * Write a description of class Targeting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Targeting {
    private EnemyParty enemyParty;
    private PlayerParty playerParty;
    private PlayerCharacter[] combattants;
    private String targetingMode;
    private PlayerCharacter allyTarget;
    private EnemyCharacter enemyTarget;
    
    public Targeting(EnemyParty enemyParty, PlayerParty playerParty) {
        this.enemyParty = enemyParty;
        this.playerParty = playerParty;
        this.combattants = this.playerParty.getCombattants();
        this.targetingMode = "enemy";
    }
    
    public void changeTargettingMode(String mode){
        this.targetingMode = mode;
    }
    
    public void changeTarget(String direction){
        
    }
}
