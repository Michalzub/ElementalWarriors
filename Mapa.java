import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Zostaví mapu z políčiek podla textového dokumentu.
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public class Mapa {
    private File txtMapa;
    private Policko[][] pole;
    private int stranaPoliciek;
    private Player player;
    private String mode;

    public Mapa(String suborMapa) throws FileNotFoundException {
        //initialise instance variables
        this.txtMapa = new File(suborMapa);
        Scanner citac = new Scanner(this.txtMapa);

        this.mode = "explore";

        this.stranaPoliciek = 10;

        this.pole = new Policko[this.stranaPoliciek][this.stranaPoliciek];
        for (int i = 0; i < (this.stranaPoliciek); i++) {
            for (int j = 0; j < (this.stranaPoliciek); j++) {
                int pozX = 50 * j;
                int pozY = 50 * i;
                int poletype = citac.nextInt();
                switch (poletype) {
                    case 0:
                        this.pole[i][j] = new Policko(pozX, pozY, TypPolicka.ROCK);
                        break;
                    case 1:
                        this.pole[i][j] = new Policko(pozX, pozY, TypPolicka.GRASS);
                        break;
                    case 2:
                        this.pole[i][j] = new Policko(pozX, pozY, TypPolicka.CHEST);
                        break;
                    case 3:
                        this.pole[i][j] = new Policko(pozX, pozY, TypPolicka.ENEMY);
                        break;
                    default:
                        System.out.println("checkni cisla v mape");
                        break;
                }
            }
        }
        citac.close();
    }

    public void pridajPlayer(Player player) {
        this.player = player;
    }

    public void nastavMode(String mode) {
        this.mode = mode;
        for (int i = 0; i < (stranaPoliciek); i++) {
            for (int j = 0; j < (stranaPoliciek); j++) {
                if (this.mode.equals("combat")) {
                    this.pole[i][j].getObrazok().skry();
                } else if (this.mode.equals("explore")) {
                    this.pole[i][j].getObrazok().zobraz();
                }
            }
        }
    }

    /**
     * Skontroluje typ políčka a podla neho buď pridá hráčovi item alebo spustí combat a následne zmení políčko na grass.
     */
    public TypPolicka collider(int playerX, int playerY) {
        TypPolicka typ = this.pole[playerY][playerX].getTyp();
        switch (typ) {
            case CHEST:
                this.player.pridajItem();
                this.pole[playerY][playerX].zmenaNaGrass();
                this.player.getObrazok().zobraz();
                break;
            case ENEMY:
                this.nastavMode("combat");
                this.pole[playerY][playerX].zmenaNaGrass();
                break;
        }
        return typ;
    }

    public Policko[][] getPole() {
        return this.pole;
    }
}
