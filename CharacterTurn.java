
/**
 * Write a description of class CharacterTurn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterTurn {
    private PlayerCharacter playerCharacter;
    private EnemyCharacter enemyCharacter;
    private double speed;
    private double distance;
    
    public CharacterTurn(PlayerCharacter playerCharacter, EnemyCharacter enemyCharacter) {
        // initialise instance variables
        this.playerCharacter = playerCharacter;
        this.enemyCharacter = enemyCharacter;
        this.distance = 0;
        if(this.playerCharacter != null) {
            this.speed = this.playerCharacter.getPlayerSpeed();
        } else if(this.enemyCharacter != null) {
            this.speed = this.playerCharacter.getPlayerSpeed();
        }
    }
    
    public boolean isPlayerCharacter() {
        if(this.playerCharacter != null){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean addDistance() {
        this.distance += this.speed;
        return this.isReady();
    }
    
    public boolean isReady() {
        if(this.distance >= 100) {
            this.distance -= 100;
            return true;
        } else {
            return false;
        }
    }
    
    public double getDistance() {
        return this.distance;
    }
}
