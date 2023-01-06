import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.IOException;  // Import this class to handle errors
import java.util.Scanner;
/**
 * Vytvorí main menu kde hráč dostane možnosť si vybrať medzi "new game" a "load game".
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public class MainMenu {
    private Obrazok obrazok;
    private int menuLevel;
    private boolean menu;
    private Manazer manazer;
    private Hra hra;
    public MainMenu() throws FileNotFoundException {
        // initialise instance variables
        this.menuLevel = 0;
        this.menu = true;
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
        this.obrazok = new Obrazok("files/obrazky/mainMenu.png");
        this.obrazok.zobraz();
    }

    /**
     * Podľa toho kam hráč klikne taká akcia sa vykoná.
     */
    public void vyberSuradnice(int x, int y) throws FileNotFoundException, IOException {
        if ((x > 140 && x < 360) && (y > 260 && y < 290) && this.menu) {
            this.hra = new Hra("files/newGame/");
            this.menu = false;
            this.obrazok.skry();
        } else if ((x > 140 && x < 360) && (y > 300 && y < 330) && this.menu) {
            File mapa = new File("files/saves/mapa.txt");
            File playerData = new File("files/saves/playerData.txt");
            Scanner citacMapa = new Scanner(mapa);
            Scanner citacPlayer = new Scanner(playerData);
            if (citacMapa.hasNext() && citacPlayer.hasNext()) {
                this.hra = new Hra("files/saves/");
                this.menu = false;
                this.obrazok.skry();
                return;
            }
            citacMapa.close();
            citacPlayer.close();
        } else if ((x > 140 && x < 360) && (y > 340 && y < 370) && this.menu) {
            this.hra.saveGame();
            System.exit(0);
        }
    }
    
    public void exitGame() {
        System.exit(0);
    }
}
