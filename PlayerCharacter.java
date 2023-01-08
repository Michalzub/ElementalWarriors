/**
 * Postava hraca ktora ma vlastne zivoty, manu, rychlost, damage a element
 * 
 * @author Michal Zúbek 
 * @version 0.9
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
    
    /**
     * pouzije utok na target a ak nepriatel zomrie vrati true
     * @return boolean true ak targetu padnu zivoty pod 1 a false naopak
     */
    public boolean attack(EnemyCharacter target){
        return target.takeDamage(this.damage);
    }
    
    /**
     * pouzije elementany utok na target, vypocita jeho damage a ak nepriatel zomrie vrati true
     * @return boolean true ak targetu padnu zivoty pod 1 a false naopak
     */
    public boolean elementalHit(EnemyCharacter target){
        Double elementalDamage = element.calculate(this.damage, target.getEnemyElement());
        return target.takeDamage(this.damage);
    }
    
    /**
     * odpocita postave zivoty, ak jej padnu pod 1 nastavi ich na 1 a vrati true
     * @return boolean true ak postave padnu zivoty pod 1 a false naopak
     */
    public boolean takeDamage(double damage){
        this.health -= damage;
        if(this.health <= 0) {
            this.health = 1;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * pripocita postave zivoty
     */
    public void takeHealing (double healing) {
        this.health += healing;
    }
    
    /**
     * odpocita postave manu
     */
    public void takeMana(double manaCost) {
        this.mana -= manaCost;
    }
    
    /**
     * pripocita postave manu
     */
    public void earnMana(double manaGain) {
        this.mana -= manaGain;
    }
    
    /**
     * nastavi postave zivoty
     */
    public void setPlayerHealth(int health) {
        this.health = health;
    }
    
    /**
     * nastavi postave manu
     */
    public void setPlayerMana(int mana) {
        this.mana = mana;
    }
    
    /**
     * vrati zivoty postavy
     * @return double health
     */
    public double getPlayerHealth() {
        return this.health;
    }
    
    /**
     * vrati manu postavy
     * @return double mana
     */
    public double getPlayerMana() {
        return this.mana;
    }
    
    /**
     * vrati speed postavy
     * @return double speed
     */
    public double getPlayerSpeed() {
        return this.speed;
    }
    
    /**
     * vrati obrazok postavy elementu
     * @return Obrazok picture
     */
    public Obrazok getPicture() {
        return this.element.getPicture();
    }
    
    /**
     * vrati element postavy
     * @return Element
     */
    public Element getElement() {
        return this.element;
    }
}
