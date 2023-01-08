import java.util.ArrayList;
import java.lang.InterruptedException;

/**
 * Write a description of class CombatSupervisor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CombatSupervisor {
    private MenuNavigator menuNavigator;
    private EnemyParty enemyParty;
    private Player player;
    private ArrayList<EnemyCharacter> enemyCombattants;
    private PlayerCharacter[] playerCombattants;
    private ArrayList<CharacterTurn> allCombattants;
    private ArrayList<CharacterTurn> turnReadyCharacters;
    private int playerCount;
    private int enemyCount;
    private boolean turnInProgress;
    
    private Targeting targeting;
    
    public CombatSupervisor(Player player, EnemyParty enemyParty, MenuNavigator menuNavigator) {
        // this.menuNavigator = menuNavigator;
        // this.menuNavigator.hideSelectedObject();
        this.playerCount = 0;
        this.enemyCount = 0;
        this.enemyParty = enemyParty;
        this.player = player;
        this.playerCombattants = this.player.getCombattants();
        this.menuNavigator = menuNavigator;
        this.enemyCombattants = this.enemyParty.getEnemyParty();
        this.allCombattants = new ArrayList<CharacterTurn>();
        this.turnReadyCharacters = new ArrayList<CharacterTurn>();
        
        
        for(PlayerCharacter character : this.playerCombattants) {
            character.getPicture().zmenPolohu(50 + 100 * this.playerCount, 300);
            character.getPicture().zobraz();
            CharacterTurn tempCharTurn = new CharacterTurn(character, null, true);
            this.allCombattants.add(tempCharTurn);
            this.playerCount += 1;
        }
        for(EnemyCharacter character : this.enemyCombattants) {
            character.getPicture().zmenPolohu(50 + 100 * this.enemyCount, 100);
            character.getPicture().zobraz();
            CharacterTurn tempCharTurn = new CharacterTurn(null, character, false);
            this.allCombattants.add(tempCharTurn);
            this.enemyCount += 1;
        }
        this.roundStart();
    }
    
    public void roundStart()  {
        System.out.println("the player character count is " + this.playerCount);
        System.out.println("the enemy character count is " + this.enemyCount);
        System.out.println(this.turnReadyCharacters.isEmpty());
        if(this.playerCount > 0 && this.enemyCount > 0) {
            if(this.turnReadyCharacters.isEmpty()) {
                System.out.println("we are about to roll initiative");
                this.rollInitiative();
            } else {
                System.out.println("we are about to turnTime");
                this.turnTime();
            }
        }
    }
    
    public void rollInitiative() {
        while(this.turnReadyCharacters.isEmpty()){
            for(CharacterTurn character : this.allCombattants) {
                if(character.addDistance() ) {
                    this.turnReadyCharacters.add(character);
                }
            }
        }
        this.turnReadyCharacters = this.getSortedList(this.turnReadyCharacters);
        this.roundStart();
    }
    
    public void turnTime() {
        CharacterTurn tempCharacterTurn = this.turnReadyCharacters.remove(0);
        if(tempCharacterTurn.isPlayerCharacter()){
            this.playerTurn(tempCharacterTurn.getPlayerCharacter());
        } else {
            this.enemyTurn(tempCharacterTurn.getEnemyCharacter());
        }
        System.out.println("combattants left in turnReadyChars " + this.turnReadyCharacters.size());
    }
    
    public ArrayList<CharacterTurn> getSortedList(ArrayList<CharacterTurn> unsortedList) {
        ArrayList<Double> distanceOverList = new ArrayList<Double>();
        ArrayList<CharacterTurn> sortedCharacterList = new ArrayList<CharacterTurn>();
        for(CharacterTurn character : unsortedList){
            if(distanceOverList.isEmpty()) {
                distanceOverList.add(character.getDistance());
                sortedCharacterList.add(character);
            } else {
                for(int i = 0; i < distanceOverList.size(); i++) {
                    if (character.getDistance() >= distanceOverList.get(i)){
                        distanceOverList.add(i, character.getDistance());
                        sortedCharacterList.add(i, character);
                        break;
                    } else if(character.getDistance() < distanceOverList.get(i) && i == distanceOverList.size() - 1) {
                        distanceOverList.add(character.getDistance());
                        sortedCharacterList.add(character);
                    }
                }
            }
        }
        return sortedCharacterList;
    }
    
    public void playerTurn(PlayerCharacter character) {
        System.out.println("Players turn in progress");
        this.menuNavigator.setMenuType(MenuType.COMBATMENU);
    }
    
    public void enemyTurn(EnemyCharacter character){
        System.out.println("Enemy turn in progress");
        this.roundStart();
    }
    
    public void startTargetting(TargetingMode targetingMode) {
        System.out.println("Did we atleast get inside");
        this.targeting = new Targeting(this.enemyCombattants, this.playerCombattants, targetingMode);
    }
    
    public void action(PlayerCharacter allyTarget, EnemyCharacter enemyTarget, MenuObject menuObject, TargetingMode targetingMode) {
        PlayerCharacter tempAllyTarget = allyTarget;
        EnemyCharacter tempEnemyTarget = enemyTarget;
        MenuObject objectType = menuObject;
        TargetingMode targetMode = targetingMode;
        //this IS WHERE YOU ENDED
    }
    
    public Targeting getTargeting() {
        return this.targeting;
    }
}
