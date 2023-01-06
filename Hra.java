import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Vytvorí mapu, hráča a manažera, ktorý ich bude spravovať.
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public class Hra {
    private Mapa mapa;
    private Player player;
    private Manazer manazer;
    private String mode;
    private String miesto;
    
    /**
     * Konštruktor dostane miesto úložiska, podľa ktorého vybere súbor z kadiaľ má brať dáta.
     */
    public Hra(String miesto) throws FileNotFoundException {
        // initialise instance variables
        this.miesto = miesto;
        this.mode = "explore";
        this.mapa = new Mapa(this.miesto + "mapa.txt");
        this.player = new Player(this.miesto + "playerData.txt");
        this.mapa.pridajPlayer(this.player);
        this.player.pridajMapu(this.mapa);
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this.player);
        this.manazer.spravujObjekt(this);
    }
    
    public void changeMode() {
        if (this.mode.equals("explore")) {
            this.mode = "combat";
        } else if (this.mode.equals("combat")) {
            this.mode = "explore";
        }
        this.mapa.nastavMode(this.mode);
        this.player.nastavMode(this.mode);
    }
    /**
     * Uloží hrú, ešte nieje dokončené
     */
    public void saveGame() throws IOException {
        for (Policko[] riadok : this.mapa.getPole()) {
            for (Policko policko : riadok) {
                int cislo = policko.getTyp().getType();
                FileWriter pisac = new FileWriter("files/saves/mapa.txt");
                // pisac.write(_cbuf_)
                pisac.close();
            }
        } 
    }
}
