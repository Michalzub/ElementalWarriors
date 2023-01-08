
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
    private Obrazok picture;
    public EnemyCharacter(EnemyStatBlock statBlock, Element element) {
        this.statBlock = statBlock;
        this.element = element;
        this.health = this.statBlock.getHeath() * this.element.getHealthMultiplier();
        this.mana = this.statBlock.getMana() * this.element.getManaMultiplier();
        this.speed = this.statBlock.getSpeed() * this.element.getSpeedMultiplier();
        this.picture = new Obrazok(this.statBlock.getPictureFilePath());
    }
    
    public double getEnemyHealth() {
        return this.health;
    }
    public double getEnemyMana() {
        return this.mana;
    }
    public double getEnemySpeed() {
        return this.speed;
    }
    public Element getEnemyElement() {
        return this.element;
    }
    public EnemyStatBlock getStatBlock() {
        return this.statBlock;
    }
    
    public Obrazok getPicture() {
        return this.picture;
    }
}