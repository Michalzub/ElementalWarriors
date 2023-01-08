
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
            System.out.println("player charturn has been created");
        } else {
            this.speed = this.enemyCharacter.getEnemySpeed();
            System.out.println("ENEMY charturn has been created");
        }
    }
    
    public boolean isPlayerCharacter() {
        return this.isPlayerCharacter;
    }
    
    public boolean addDistance() {
        this.distance += this.speed;
        if(isPlayerCharacter()) {
            System.out.println("this is a playerCharacter");
        } else {
            System.out.println("this is an enemyCharacter");
        }
        System.out.println("distance after adding " + this.speed + " speed is "+ this.distance);
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
}
