import java.util.ArrayList;
/**
 * Write a description of class Targeting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Targeting {
    private Player player;
    private ArrayList<CharacterTurn> allCombattants;
    private ArrayList<CharacterTurn> playerCharacters;
    private ArrayList<CharacterTurn> enemyCharacters;
    private CharacterTurn allyTarget;
    private CharacterTurn enemyTarget;
    private int objectSelector;
    private TargetingMode mode;
    
    public Targeting(ArrayList<CharacterTurn> allCombattants, TargetingMode mode) {
        this.player = player;
        this.playerCharacters = new ArrayList<CharacterTurn>();
        this.enemyCharacters = new ArrayList<CharacterTurn>();
        this.allCombattants = allCombattants;
        for(CharacterTurn character : this.allCombattants) {
            if(character.isPlayerCharacter()) {
                this.playerCharacters.add(character);
            } else {
                this.enemyCharacters.add(character);
            }
        }
        
        this.mode = mode;
        this.initialTargetSelect();
        
        
    }
    
    public void initialTargetSelect() {
        this.objectSelector = 0;
        switch(this.mode) {
            case ALLYTARGETING:
                this.allyTarget = this.playerCharacters.get(this.objectSelector);
                this.mode.getPicture().zmenPolohu(50 + 100 * this.objectSelector, this.mode.getPosY());
                this.mode.getPicture().zobraz();
                break;
            case ENEMYTARGETING:
                this.enemyTarget = this.enemyCharacters.get(this.objectSelector);
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
                    this.objectSelector = this.playerCharacters.size() - 1;
                } else if(this.objectSelector >= this.playerCharacters.size()) {
                    this.objectSelector = 0;
                }
                this.allyTarget = this.playerCharacters.get(this.objectSelector);
                this.mode.getPicture().zmenPolohu(50 + 100 * this.objectSelector, this.mode.getPosY());
                this.mode.getPicture().zobraz();
                break;
            case ENEMYTARGETING:
                if(this.objectSelector < 0) {
                    this.objectSelector = this.enemyCharacters.size() - 1;
                } else if(this.objectSelector >= this.enemyCharacters.size()) {
                    this.objectSelector = 0;
                }
                this.enemyTarget = this.enemyCharacters.get(this.objectSelector);
                this.mode.getPicture().zmenPolohu(50 + 100 * this.objectSelector, this.mode.getPosY());
                this.mode.getPicture().zobraz();
                break;
            case NOTTARGETING:
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
    public CharacterTurn getAllyTarget() {
        return this.allyTarget;
    }
    public CharacterTurn getEnemyTarget() {
        return this.enemyTarget;
    }
}
