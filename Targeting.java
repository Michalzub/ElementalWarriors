import java.util.ArrayList;
/**
 * Stará sa o výber ciela/targetu
 * 
 * @author MichalZúbek 
 * @version 0.9
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
    
    /**
     * roztriedi postavy v boji na postavy hraca a nepriatela
     * nastavi targeting mod a vybere pociatocny target
     * @param allCombattants list so všetkými bojovníkmi
     * @param mode mode v ktorom chceme vyberať ciel/target
     */
    public Targeting(ArrayList<CharacterTurn> allCombattants, TargetingMode mode) {
        this.player = player;
        this.playerCharacters = new ArrayList<CharacterTurn>();
        this.enemyCharacters = new ArrayList<CharacterTurn>();
        this.allCombattants = allCombattants;
        for (CharacterTurn character : this.allCombattants) {
            if (character.isPlayerCharacter()) {
                this.playerCharacters.add(character);
            } else {
                this.enemyCharacters.add(character);
            }
        }
        
        this.mode = mode;
        this.initialTargetSelect();
    }
    
    /**
     * vybere prvy target z listu targetov a oznaci ho
     */
    public void initialTargetSelect() {
        this.objectSelector = 0;
        switch (this.mode) {
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
    
    /**
     * podla vlozeneho smeru cykluje cez mozne targety a zobrazi jeho oznacenie
     * @param direction smer do ktoreho chceme ist bud 1 alebo -1
     */
    public void changeTarget(int direction) {
        this.objectSelector += direction;
        switch (this.mode) {
            case ALLYTARGETING:
                if (this.objectSelector < 0) {
                    this.objectSelector = this.playerCharacters.size() - 1;
                } else if (this.objectSelector >= this.playerCharacters.size()) {
                    this.objectSelector = 0;
                }
                this.allyTarget = this.playerCharacters.get(this.objectSelector);
                this.mode.getPicture().zmenPolohu(50 + 100 * this.objectSelector, this.mode.getPosY());
                this.mode.getPicture().zobraz();
                break;
            case ENEMYTARGETING:
                if (this.objectSelector < 0) {
                    this.objectSelector = this.enemyCharacters.size() - 1;
                } else if (this.objectSelector >= this.enemyCharacters.size()) {
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
    
    /**
     * skryje oznacenie targetu
     */
    public void hideTargeting() {
        this.mode.getPicture().skry();
    }
    
    /**
     * nastavi mod targetingu a vybere prvy target
     */
    public void setTargettingMode(TargetingMode mode) {
        this.mode = mode;
        this.initialTargetSelect();
    }
    
    /**
     * vrati vybrateho spolubojovnika
     * @return CharacterTurn allyTarget
     */
    public CharacterTurn getAllyTarget() {
        return this.allyTarget;
    }
    
    /**
     * vrati vybrateho nepriatela
     * @return CharacterTurn enemyTarget
     */
    public CharacterTurn getEnemyTarget() {
        return this.enemyTarget;
    }
}
