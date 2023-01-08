import java.util.ArrayList;
/**
 * Write a description of class Targeting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Targeting {
    private Player player;
    private ArrayList<EnemyCharacter> enemyParty;
    private PlayerCharacter[] combattants;
    private PlayerCharacter allyTarget;
    private EnemyCharacter enemyTarget;
    private int objectSelector;
    private TargetingMode mode;
    
    public Targeting(ArrayList<EnemyCharacter> enemyParty, PlayerCharacter[] combattants, TargetingMode mode) {
        this.player = player;
        this.enemyParty = enemyParty;
        this.combattants = combattants;
        System.out.println("Did we create a targeting");
        this.mode = mode;
        this.initialTargetSelect();
        
        
    }
    
    public void initialTargetSelect() {
        this.objectSelector = 0;
        switch(this.mode) {
            case ALLYTARGETING:
                this.allyTarget = this.combattants[this.objectSelector];
                this.mode.getPicture().zmenPolohu(50 + 100 * this.objectSelector, this.mode.getPosY());
                this.mode.getPicture().zobraz();
                break;
            case ENEMYTARGETING:
                this.enemyTarget = this.enemyParty.get(this.objectSelector);
                this.mode.getPicture().zmenPolohu(50 + 100 * this.objectSelector, this.mode.getPosY());
                this.mode.getPicture().zobraz();
                break;
            case NOTTARGETING:
                System.out.println("Somehow we got NOTTARGETING mode");
                break;
        }
    }
    
    public void changeTarget(int direction){
        this.objectSelector += direction;
        switch(this.mode) {
            case ALLYTARGETING:
                if(this.objectSelector < 0) {
                    this.objectSelector = this.combattants.length - 1;
                } else if(this.objectSelector >= this.combattants.length) {
                    this.objectSelector = 0;
                }
                this.allyTarget = this.combattants[this.objectSelector];
                this.mode.getPicture().zmenPolohu(50 + 100 * this.objectSelector, this.mode.getPosY());
                this.mode.getPicture().zobraz();
                break;
            case ENEMYTARGETING:
                if(this.objectSelector < 0) {
                    this.objectSelector = this.enemyParty.size() - 1;
                } else if(this.objectSelector >= this.enemyParty.size()) {
                    this.objectSelector = 0;
                }
                this.enemyTarget = this.enemyParty.get(this.objectSelector);
                this.mode.getPicture().zmenPolohu(50 + 100 * this.objectSelector, this.mode.getPosY());
                this.mode.getPicture().zobraz();
                break;
            case NOTTARGETING:
                System.out.println("Somehow we got NOTTARGETING mode");
                break;
        }
    }
    
    public void hideTargeting() {
        this.mode.getPicture().skry();
    }
    
    public void setTargettingMode(TargetingMode mode) {
        this.mode = mode;
        this.initialTargetSelect();
    }
    public PlayerCharacter getAllyTarget() {
        return this.allyTarget;
    }
    public EnemyCharacter getEnemyTarget() {
        return this.enemyTarget;
    }
}
