
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
    private boolean isPlayerCharacter;
    
    public CharacterTurn(PlayerCharacter playerCharacter, EnemyCharacter enemyCharacter, boolean isPlayerCharacter) {
        // initialise instance variables
        this.playerCharacter = playerCharacter;
        this.enemyCharacter = enemyCharacter;
        this.isPlayerCharacter = isPlayerCharacter;
        this.distance = 0;
        if(isPlayerCharacter()) {
            this.speed = this.playerCharacter.getPlayerSpeed();
        } else {
            this.speed = this.enemyCharacter.getEnemySpeed();
        }
    }
    
    public boolean isPlayerCharacter() {
        return this.isPlayerCharacter;
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
    public PlayerCharacter getPlayerCharacter() {
        return this.playerCharacter;
    }
    public EnemyCharacter getEnemyCharacter() {
        return this.enemyCharacter;
    }
    
    public void hideCharacter() {
        if(isPlayerCharacter()) {
            this.getPlayerCharacter().getPicture().skry();
        } else {
            this.getEnemyCharacter().getPicture().skry();
        }
    }
}
