import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Zostaví mapu ako pole polí z políčiek podla textového dokumentu.
 * Uschováva taktiež počet nepriatelov na mape.
 * 
 * @param suborMapa string úložného miesta
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public class Map {
    private File txtMapa;
    private Space[][] spaceGrid;
    private int spaceSideLength;
    private Player player;
    private int enemyTotal;
    
    public Map(String suborMapa) throws FileNotFoundException {
        this.enemyTotal = 0;
        this.txtMapa = new File(suborMapa);
        Scanner reader = new Scanner(this.txtMapa);

        this.spaceSideLength = 10;

        this.spaceGrid = new Space[this.spaceSideLength][this.spaceSideLength];
        for (int i = 0; i < (this.spaceSideLength); i++) {
            for (int j = 0; j < (this.spaceSideLength); j++) {
                int pozX = 50 * j;
                int pozY = 50 * i;
                int spaceType = reader.nextInt();
                switch (spaceType) {
                    case 0:
                        this.spaceGrid[i][j] = new Space(pozX, pozY, SpaceType.ROCK);
                        break;
                    case 1:
                        this.spaceGrid[i][j] = new Space(pozX, pozY, SpaceType.GRASS);
                        break;
                    case 2:
                        this.spaceGrid[i][j] = new Space(pozX, pozY, SpaceType.CHEST);
                        break;
                    case 3:
                        this.spaceGrid[i][j] = new Space(pozX, pozY, SpaceType.ENEMY);
                        this.enemyTotal += 1;
                        break;
                    default:
                        System.out.println("checkni cisla v mape");
                        break;
                }
            }
        }
        reader.close();
    }
    
    /**
     * skryje pozostávajúce prvky mapy
     */
    public void hideMap() {
        for (int i = 0; i < (this.spaceSideLength); i++) {
            for (int j = 0; j < (this.spaceSideLength); j++) {
                this.spaceGrid[i][j].getPicture().skry();
            }
        }
    }
    
    /**
     * ukáže prvkz mapy
     */
    public void showMap() {
        for (int i = 0; i < (this.spaceSideLength); i++) {
            for (int j = 0; j < (this.spaceSideLength); j++) {
                this.spaceGrid[i][j].getPicture().zobraz();
            }
        }
    }
    
    /**
     * Zavolá metodu daného políčka changeToGrass
     */
    public void changeToGrass(int posX, int posY) {
        this.spaceGrid[posY][posX].changeToGrass();
    }
    
    public SpaceType getSpaceType(int posX, int posY) {
        return this.spaceGrid[posY][posX].getType();
    }

    public Space[][] getSpaceGrid() {
        return this.spaceGrid;
    }
    
    public int getEnemyTotal() {
        return this.enemyTotal;
    }
}
