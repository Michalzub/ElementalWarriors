
/**
 * Write a description of class PlayerPart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerParty {
    PlayerCharacter[] playerParty;
    PlayerCharacter[] combattants;
    public PlayerParty() {
        this.playerParty = new PlayerCharacter[4];
        this.combattants = new PlayerCharacter[2];
        for(Element element : Element.values()) {
            if (element != Element.NONE) {
                this.playerParty[element.ordinal()] = new PlayerCharacter(element);
            }
        }
        this.combattants[0] = this.playerParty[0];
        this.combattants[1] = this.playerParty[1];
    }
    
    public PlayerCharacter[] getCombattants() {
        return this.combattants;
    }
}
