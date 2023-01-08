import java.util.ArrayList;
import java.lang.InterruptedException;

/**
 * Trieda CombatSupervisor sa stará o všetko čo sa deje v combate
 * 
 * @author Michal Zúbek
 * @version 0.9
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
    private CharacterTurn selectedCharacter;
    
    private Targeting targeting;
    
    /**
     * vyberie bojovníkov a zabalí ich do triedy CharacterTurn aby s nimi mohol lahšie pracovať
     * roztriedi ich na 2 typy - postavy hrača a postavy nepriatela
     * nakoniec započne prvé kolo
     * @param player hráč ktorého skupina bude bojovať
     * @param enemyParty nepriatelská skupina
     * @param menuNavigator MenuNavigator ktory umožní rozpoznať input
     */
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
    
    /**
     * spustí kolo ak v hre je aspoň jeden člen z každého týmu živý tak sa pokračuje
     * ak list pripravených postáv je prázdny zavolá metódu rollInitiative
     * ak list nieje prázdny zavolá metódu turnTime
     */
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
        } else {
            
        }
    }
    
    /**
     * metóda vypočítava kto je na rade, pri každom zavolaní sa postavám pridá do distancu ich speed a ak niekto presiahne 100 tak sa pridá do listu pripravených
     * ak náhodou viac hráčou sa dostalo do listu pripravených zavolá metódu getSortedList na určenie ich poradia
     */
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
    
    /**
     * vymaže postavu z listu pripravených a pustí jeho kolo
     */
    public void turnTime() {
        CharacterTurn tempCharacterTurn = this.turnReadyCharacters.remove(0);
        if(tempCharacterTurn.isPlayerCharacter()){
            this.playerTurn(tempCharacterTurn);
        } else {
            this.enemyTurn(tempCharacterTurn);
        }
    }
    
    /**
     * usporiada list pripravených podla ich poradia
     * @param unsortedList vložiť neusporiadaný list
     * @return ArrayList<CharacterTurn> vráti usporiadaný list
     */
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
    
    /**
     * nastaví menu na combat a uloží postavu do vybratej Postavy
     * @param character postava ktorá je na ťahu
     */
    public void playerTurn(CharacterTurn character) {
        System.out.println("Players turn in progress");
        this.menuNavigator.setMenuType(MenuType.COMBATMENU);
        this.selectedCharacter = character;
    }
    
    /**
     * vrati vybratu postavu
     * @return CharacterTurn selectedCharacter
     */
    public CharacterTurn getSelectedCharacter() {
        return this.selectedCharacter;
    }
    
    /**
     * Nepriateľov ťah nepriateľov AI rozhodne čo sa stane a zavolá dalšie kolo
     */
    public void enemyTurn(CharacterTurn character){
        System.out.println("Enemy turn in progress");
        this.roundStart();
    }
    
    /**
     * spustí targetting podla požadovaného módu
     * @param targetingMode požadovaný mód
     */
    public void startTargetting(TargetingMode targetingMode) {
        this.targeting = new Targeting(this.allCombattants, targetingMode);
    }
    
    /**
     * action je metóda ktorá sa zavolá pri hráčovom kole podla toho akú možnosť z menu si zvolí
     * @param allyTarget vybraný priateľský target
     * @param enemyTarget vybraný nepriateľský target
     * @param menuObject typ stlačené tlačítko z combat menu
     * @param targetingMode mód výberu targetu
     * 
     */
    public void action(CharacterTurn allyTarget, CharacterTurn enemyTarget, String selectedMove , TargetingMode targetingMode) {
        String tempSelectedMove = selectedMove;
        PlayerCharacter tempSelectedCharacter = this.selectedCharacter.getPlayerCharacter();
        PlayerCharacter tempAllyTarget = allyTarget.getPlayerCharacter();
        EnemyCharacter tempEnemyTarget = enemyTarget.getEnemyCharacter();
        TargetingMode targetMode = targetingMode;
        switch(tempSelectedMove) {
            case "attack":
                System.out.println("we got into attack switch");
                if(tempSelectedCharacter.attack(tempEnemyTarget)) {
                    this.removeTarget(enemyTarget);
                }
                this.roundStart();
                break;
            case "elementalhit":
                if(tempSelectedCharacter.elementalHit(tempEnemyTarget)) {
                    this.removeTarget(enemyTarget);
                }
                this.roundStart();
                break;
            case "smallhp":
                System.out.println("SMALLHP PRESSED");
                
                break;
            case "largehp":
                System.out.println("LARGEHP PRESSED");
                

                break;
            case "smallmp":
                System.out.println("SMALLMP PRESSED");
                

                break;
            case "lagemp":
                System.out.println("LARGEMP PRESSED");
                

                break;
            default:
                break;
        }
    }
    
    /**
     * odstrani target z listu bojovnikov a odpocita pocet bojovnikov jeho typu
     * @param character CharacterTurn s ktorým budeme pracovať
     */
    public void removeTarget(CharacterTurn character) {
        character.hideCharacter();
        this.allCombattants.remove(character);
        if(character.isPlayerCharacter()) {
            this.playerCount -= 1;
        } else {
            this.enemyCount -= 1;
        }
        
    }
    
    /**
     * vráti targeting ako objekt
     * @return Targeting
     */
    public Targeting getTargeting() {
        return this.targeting;
    }
}
