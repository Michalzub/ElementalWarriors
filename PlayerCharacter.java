
/**
 * Write a description of class PlayerCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerCharacter {
    private double health;
    private double mana;
    private double speed;
    private Element element;
    public PlayerCharacter(Element element) {
        this.element = element;
        this.health = 100 * this.element.getHealthMultiplier();
        this.mana = 100 * this.element.getManaMultiplier();
        this.speed = 10 * this.element.getSpeedMultiplier();
    }
    
    public void attack(){
        
    }
    public void elementalHit(){
    
    }
    public void elementalEffect(){
        
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
