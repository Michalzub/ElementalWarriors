
/**
 * Trieda na obalenie 2 typov postav do jednej pre lahsiu manipulaciu.
 * 
 * 
 * @author Michal Zúbek 
 * @version 0.9
 */
public class CharacterTurn {
    
    private PlayerCharacter playerCharacter;
    private EnemyCharacter enemyCharacter;
    private double speed;
    private double distance;
    private boolean isPlayerCharacter;
    
    /**
     * konštruktor podla toho ci je to postava hraca alebo nie ulozi potrebné informacie
     * @param playerCharacter vlozit player postavu alebo null
     * @param enemyCharacter vlozit enemy postavu alebo null
     * @param isPlayerCharacter true alebo false podla toho ci to je postava hraca
     */
    public CharacterTurn(PlayerCharacter playerCharacter, EnemyCharacter enemyCharacter, boolean isPlayerCharacter) {
        this.playerCharacter = playerCharacter;
        this.enemyCharacter = enemyCharacter;
        this.isPlayerCharacter = isPlayerCharacter;
        this.distance = 0;
        if (this.isPlayerCharacter()) {
            this.speed = this.playerCharacter.getPlayerSpeed();
        } else {
            this.speed = this.enemyCharacter.getEnemySpeed();
        }
    }
    
    /**
     * vrati ci postava patri hracovi
     * @return boolean
     */
    public boolean isPlayerCharacter() {
        return this.isPlayerCharacter;
    }
    
    /**
     * prida rýchlost k distance a zisti ci je postava na rade
     * @return boolean
     */
    public boolean addDistance() {
        this.distance += this.speed;
        return this.isReady();
    }
    
    /**
     * ak distance je vacsi ako 100 tak postava bude na rade v combate
     * @return boolean
     */
    public boolean isReady() {
        if (this.distance >= 100) {
            this.distance -= 100;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * skryje postavu
     */
    public void hideCharacter() {
        if (this.isPlayerCharacter()) {
            this.getPlayerCharacter().getPicture().skry();
        } else {
            this.getEnemyCharacter().getPicture().skry();
        }
    }
    
    /**
     * vrati distance
     * @return double distance
     */
    public double getDistance() {
        return this.distance;
    }
    
    /**
     * vrati postavu
     * @return PlayerCharacter
     */
    public PlayerCharacter getPlayerCharacter() {
        return this.playerCharacter;
    }
    
    /**
     * vrati postavu
     * @return EnemyCharacter
     */
    public EnemyCharacter getEnemyCharacter() {
        return this.enemyCharacter;
    }
}
