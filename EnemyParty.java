import java.util.ArrayList;
/**
 * Trieda sa stará o poskladanie nepriatelskej skupiny
 * 
 * @author Michal Zúbek
 * @version 0.9
 */
public class EnemyParty {
    
    private ArrayList<EnemyCharacter> enemyParty;
    private EnemyGroups enemyGroup;
    
    /**
     * podla typu postavá nepriatelskú skupinu
     * @param enemyGroup typ nepriatelskej skupiny
     */
    public EnemyParty(EnemyGroups enemyGroup) {
        
        this.enemyGroup = enemyGroup;
        this.enemyParty = new ArrayList<EnemyCharacter>();
        
        for (EnemyStatBlock enemy : EnemyStatBlock.values()) {
            switch (enemy) {
                case RAT:
                    for (int i = 0; i < this.enemyGroup.getRatCount(); i++) {
                        this.enemyParty.add(new EnemyCharacter(enemy, Element.NONE));
                    }
                    break;
                case WOLF:
                    for ( int i = 0; i < this.enemyGroup.getWolfCount(); i++) {
                        this.enemyParty.add(new EnemyCharacter(enemy, Element.NONE));
                    }
                    break;
                case BANDIT:
                    for (int i = 0; i < this.enemyGroup.getBanditCount(); i++) {
                        this.enemyParty.add(new EnemyCharacter(enemy, Element.NONE));
                    }
                    break;
                case BANDITBOSS:
                    for (int i = 0; i < this.enemyGroup.getBanditBossCount(); i++) {
                        this.enemyParty.add(new EnemyCharacter(enemy, Element.NONE));
                    }
                    break;
            }
        }
    }
    
    /**
     * vrati list so všetkými nepriatelmi
     * @return ArrayList<EnemyCharacter>
     */
    public ArrayList<EnemyCharacter> getEnemyParty() {
        return this.enemyParty;
    }
}
