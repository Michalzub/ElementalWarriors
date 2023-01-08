/**
 * Postava nepriatela ktora ma vlastne zivoty, manu, rychlost, damage a element
 * 
 * @author Michal Zúbek 
 * @version 0.9
 */
public class EnemyCharacter {
    private double health;
    private double mana;
    private double damage;
    private double speed;
    private Element element;
    private EnemyStatBlock statBlock;
    private Obrazok picture;
    public EnemyCharacter(EnemyStatBlock statBlock, Element element) {
        this.statBlock = statBlock;
        this.element = element;
        this.health = this.statBlock.getHeath() * this.element.getHealthMultiplier();
        this.mana = this.statBlock.getMana() * this.element.getManaMultiplier();
        this.damage = this.statBlock.getDamage() * this.element.getDamageMultiplier();
        this.speed = this.statBlock.getSpeed() * this.element.getSpeedMultiplier();
        this.picture = new Obrazok(this.statBlock.getPictureFilePath());
    }
    
    /**
     * pouzije utok na target a ak nepriatel zomrie vrati true
     * @return boolean true ak targetu padnu zivoty pod 1 a false naopak
     */
    public void attack(PlayerCharacter target){
        target.takeDamage(this.damage);
    }
    
    /**
     * pouzije elementany utok na target, vypocita jeho damage a ak nepriatel zomrie vrati true
     * @return boolean true ak targetu padnu zivoty pod 1 a false naopak
     */
    public boolean elementalHit(PlayerCharacter target){
        Double elementalDamage = element.calculate(this.damage, target.getElement());
        return target.takeDamage(this.damage);
    }
    
    public boolean takeDamage(double damage){
        this.health -= damage;
        if(this.health <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * vrati zivoty postavy
     * @return double health
     */
    public double getEnemyHealth() {
        return this.health;
    }
    
    /**
     * vrati manu postavy
     * @return double mana
     */
    public double getEnemyMana() {
        return this.mana;
    }
    
    /**
     * vrati speed postavy
     * @return double speed
     */
    public double getEnemySpeed() {
        return this.speed;
    }
    
    /**
     * vrati element postavy
     * @return Element
     */
    public Element getEnemyElement() {
        return this.element;
    }
    
    /**
     * vrati statBlock postavy
     * @return EnemyStatBlock
     */
    public EnemyStatBlock getStatBlock() {
        return this.statBlock;
    }
    
    /**
     * vrati obrazok postavy
     * @return Obrazok picture
     */
    public Obrazok getPicture() {
        return this.picture;
    }
}