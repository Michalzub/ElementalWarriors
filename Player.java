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

    private int pozX;
    private int pozY;

    private String mode;
    private ArrayList<Item> itemList;

    private Obrazok obrazok;
    private Mapa mapa;

    /**
     * Vytvorí hráča s pozíciou a itemami podľa textového súboru.
     */
    public Player(String subor) throws FileNotFoundException {
        // initialise instance variables

        File playerData = new File(subor);
        Scanner citac = new Scanner(playerData);

        this.pozX = citac.nextInt();
        this.pozY = citac.nextInt();
        citac.nextLine();

        this.mode = "explore";
        this.itemList = new ArrayList<Item>();
        while (citac.hasNextLine()) {
            Item item = new Item();
            item.setTyp(citac.nextLine());
            this.itemList.add(item);
        }

        this.getItemList();

        this.obrazok = new Obrazok("files/obrazky/player.png");
        this.obrazok.zmenPolohu(50 * this.pozX + 25, 50 * this.pozY + 25);
        this.obrazok.zobraz();
        citac.close();
    }

    public void pridajMapu(Mapa mapa) {
        this.mapa = mapa;
    }

    public void nastavMode(String mode) {
        this.mode = mode;
        if (this.mode.equals("combat")) {
            this.obrazok.skry();
        } else if (this.mode.equals("explore")) {
            this.obrazok.zobraz();
        }
    }

    public void moveUp() {
        this.checkAndMove(0, -1);
    }

    public void moveDown() {
        this.checkAndMove(0, 1);
    }

    public void moveLeft() {
        this.checkAndMove(-1, 0);
    }

    public void moveRight() {
        this.checkAndMove(1, 0);
    }

    /**
     * Metóda check and move zistí čo sa nachádza na dalšej pozícií podľa zadaného vstupu 
     * a posunie/neposunie hráča, v switchi volá metódu mapy "collider" ktorá vráti typ políčka a vykoná na nej zmeny.
     */
    public void checkAndMove(int posunX, int posunY) {
        if (this.mode.equals("explore")) {
            switch (this.mapa.collider(this.pozX + posunX, this.pozY + posunY)) {
                case ROCK:
                    break;
                case ENEMY:
                    this.nastavMode("combat");
                default:
                    if (posunX != 0) {
                        this.pozX += posunX;
                    } else if (posunY != 0) {
                        this.pozY += posunY;
                    } else {
                        System.out.println("Nieco je spatne, collider.");
                    }
                    this.obrazok.zmenPolohu(50 * this.pozX + 25, 50 * this.pozY + 25);
                    break;
            }
        }
    }

    public void pridajItem() {
        this.itemList.add(new Item());
        int pos = this.itemList.size() - 1;
        System.out.println("Získal/a si " + this.itemList.get(pos).getName() + " so silou " + this.itemList.get(pos).getSila() + ".");
    }

    public void getItemList() {
        for (Item item : this.itemList) {
            System.out.println(item.getName() + ", Strength: " + item.getSila());
        }
    }

    public Obrazok getObrazok() {
        return this.obrazok;
    }

    public int getPlayerX() {
        return this.pozX;
    }

    public int getPlayerY() {
        return this.pozY;
    }
}
