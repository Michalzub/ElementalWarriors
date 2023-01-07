import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Zostaví mapu z políčiek podla textového dokumentu.
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public class Map {
    private File txtMapa;
    private Space[][] spaceGrid;
    private int spaceSideLength;
    private Player player;

    public Map(String suborMapa) throws FileNotFoundException {
        //initialise instance variables
        this.txtMapa = new File(suborMapa);
        Scanner citac = new Scanner(this.txtMapa);

        this.spaceSideLength = 10;

        this.spaceGrid = new Space[this.spaceSideLength][this.spaceSideLength];
        for (int i = 0; i < (this.spaceSideLength); i++) {
            for (int j = 0; j < (this.spaceSideLength); j++) {
                int pozX = 50 * j;
                int pozY = 50 * i;
                int poletype = citac.nextInt();
                switch (poletype) {
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
                        break;
                    default:
                        System.out.println("checkni cisla v mape");
                        break;
                }
            }
        }
        citac.close();
    }
    
    public void hideMap() {
        for (int i = 0; i < (this.spaceSideLength); i++) {
            for (int j = 0; j < (this.spaceSideLength); j++) {
                this.spaceGrid[i][j].getPicture().skry();
            }
        }
    }
    public void showMap() {
        for (int i = 0; i < (this.spaceSideLength); i++) {
            for (int j = 0; j < (this.spaceSideLength); j++) {
                this.spaceGrid[i][j].getPicture().zobraz();
            }
        }
    }
    
    public void changeToGrass(int posX, int posY) {
        this.spaceGrid[posY][posX].changeToGrass();
    }
    
    public SpaceType getSpaceType(int posX, int posY) {
        return this.spaceGrid[posY][posX].getType();
    }

    public Space[][] getSpaceGrid() {
        return this.spaceGrid;
    }
}
