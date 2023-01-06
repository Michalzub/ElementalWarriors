
/**
 * Enum typov políčka obsahuje ich osobitné číslo a obrázok.
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public enum TypPolicka {
    ROCK(0, "files/obrazky/rock.png"),
    GRASS(1, "files/obrazky/grass.png"),
    CHEST(2, "files/obrazky/chest.png"),
    ENEMY(3, "files/obrazky/enemy.png");
    
    private int type;
    private String obrazok;
    
    TypPolicka (int type, String obrazok) {
        this.type = type;
        this.obrazok = obrazok;
    }
    
    public int getType() {
        return this.type;
    }
    
    public String getObrazok() {
        return this.obrazok;
    }
}
