import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Rozsiahla classa hráč ktorá zatiaľ spája dokopy pohyb po mape a inventár hráča.
 * 
 * @author Michal Zúbek
 * @version 0.2
 */
public class Player {

    private int posX;
    private int posY;

    private ArrayList<Item> itemList;
    PlayerCharacter[] playerParty;
    PlayerCharacter[] combattants;

    private Obrazok playerPicture;

    /**
     * Vytvorí hráča s pozíciou a itemami podľa textového súboru.
     */
    public Player(String file) throws FileNotFoundException {
        // initialise instance variables

        File playerData = new File(file);
        Scanner reader = new Scanner(playerData);

        this.posX = reader.nextInt();
        this.posY = reader.nextInt();
        reader.nextLine();

        this.itemList = new ArrayList<Item>();
        while (reader.hasNextLine()) {
            Item item = new Item();
            String nextLine = reader.nextLine();
            if(nextLine.equals("-")) {
                break;
            } else {
                item.setTyp(nextLine);
                this.itemList.add(item);
            }
        }
        
        this.playerParty = new PlayerCharacter[4];
        this.combattants = new PlayerCharacter[2];
        for(Element element : Element.values()) {
            if (element != Element.NONE) {
                this.playerParty[element.ordinal()] = new PlayerCharacter(element);
            }
        }
        this.combattants[0] = this.playerParty[0];
        this.combattants[1] = this.playerParty[1];
        if(file.equals("files/saves/playerData.txt")) {
            for(int i = 0; i < this.playerParty.length; i++) {
                this.playerParty[i].setPlayerHealth(reader.nextInt());
                this.playerParty[i].setPlayerMana(reader.nextInt());
            }
            this.combattants[0] = this.playerParty[reader.nextInt()];
            this.combattants[1] = this.playerParty[reader.nextInt()];
        }
        
        reader.close();
        this.getItemList();

        this.playerPicture = new Obrazok("files/obrazky/player.png");
        this.playerPicture.zmenPolohu(50 * this.posX + 25, 50 * this.posY + 25);
        this.playerPicture.zobraz();
    }
    
    public void hidePlayer() {
        this.playerPicture.skry();
    } 
    
    public void showPlayer() {
        this.playerPicture.zobraz();
    }
    
    public void playerMove(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.playerPicture.zmenPolohu(50 * this.posX + 25, 50 * this.posY + 25);
        this.playerPicture.zobraz();
    }

    public void addItem() {
        this.itemList.add(new Item());
        int pos = this.itemList.size() - 1;
        System.out.println("Získal/a si " + this.itemList.get(pos).getName() + " so silou " + this.itemList.get(pos).getStrength() + ".");
    }

    public void getItemList() {
        for (Item item : this.itemList) {
            System.out.println(item.getName() + ", Strength: " + item.getStrength());
        }
    }

    public Obrazok getplayerPicture() {
        return this.playerPicture;
    }

    public int getPlayerX() {
        return this.posX;
    }

    public int getPlayerY() {
        return this.posY;
    }
    
    public PlayerCharacter[] getCombattants() {
        return this.combattants;
    }
}
