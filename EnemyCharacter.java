
/**
 * Write a description of class PlayerCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyCharacter {
    private double health;
    private double mana;
    private double speed;
    private Element element;
    private EnemyStatBlock statBlock;
    public EnemyCharacter(EnemyStatBlock statBlock, Element element) {
        this.statBlock = statBlock;
        this.element = element;
        this.health = this.statBlock.getHeath() * this.element.getHealthMultiplier();
        this.mana = this.statBlock.getMana() * this.element.getManaMultiplier();
        this.speed = this.statBlock.getSpeed() * this.element.getSpeedMultiplier();
    }
}