
/**
 * Write a description of class PlayerCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerCharacter {
    private double health;
    private double mana;
    private double damage;
    private double speed;
    private Element element;
    public PlayerCharacter(Element element) {
        this.element = element;
        this.health = 100 * this.element.getHealthMultiplier();
        this.mana = 100 * this.element.getManaMultiplier();
        this.damage = 20 * this.element.getDamageMultiplier();
        this.speed = 10 * this.element.getSpeedMultiplier();
    }
    
    public boolean attack(EnemyCharacter target){
        return target.takeDamage(this.damage);
    }
    
    public boolean elementalHit(EnemyCharacter target){
        Double elementalDamage = element.calculate(this.damage, target.getEnemyElement());
        return target.takeDamage(this.damage);
    }
    
    public boolean takeDamage(double damage){
        this.health -= damage;
        if(this.health <= 0) {
            this.health = 1;
            return true;
        } else {
            return false;
        }
    }
    
    public void takeHealing (double healing) {
        this.health += healing;
    }
    
    public void setPlayerHealth(int health) {
        this.health = health;
    }
    public void setPlayerMana(int mana) {
        this.mana = mana;
    }
    public double getPlayerHealth() {
        return this.health;
    }
    public double getPlayerMana() {
        return this.mana;
    }
    public double getPlayerSpeed() {
        return this.speed;
    }
    public Obrazok getPicture() {
        return this.element.getPicture();
    }
}
