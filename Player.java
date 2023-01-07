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
            item.setTyp(reader.nextLine());
            this.itemList.add(item);
        }

        this.getItemList();

        this.playerPicture = new Obrazok("files/obrazky/player.png");
        this.playerPicture.zmenPolohu(50 * this.posX + 25, 50 * this.posY + 25);
        this.playerPicture.zobraz();
        reader.close();
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
}
