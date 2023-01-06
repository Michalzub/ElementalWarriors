import java.util.ArrayList;
/**
 * Write a description of class EnemyParty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyParty {
    
    private ArrayList<EnemyCharacter> enemyParty;
    private EnemyGroups enemyGroup;
    
    public EnemyParty(EnemyGroups enemyGroup) {
        
        this.enemyGroup = enemyGroup;
        this.enemyParty = new ArrayList<EnemyCharacter>();
        
        for(EnemyStatBlock enemy : EnemyStatBlock.values()) {
            switch(enemy){
                case RAT:
                    for(int i = 0; i < this.enemyGroup.getRatCount(); i++){
                        this.enemyParty.add(new EnemyCharacter(enemy,Element.NONE));
                    }
                    break;
                case WOLF:
                    for(int i = 0; i < this.enemyGroup.getWolfCount(); i++){
                        this.enemyParty.add(new EnemyCharacter(enemy,Element.NONE));
                    }
                    break;
                case BANDIT:
                    for(int i = 0; i < this.enemyGroup.getBanditCount(); i++){
                        this.enemyParty.add(new EnemyCharacter(enemy,Element.NONE));
                    }
                    break;
                case BANDITBOSS:
                    for(int i = 0; i < this.enemyGroup.getBanditBossCount(); i++){
                        this.enemyParty.add(new EnemyCharacter(enemy,Element.NONE));
                    }
                    break;
            }
        }
    }
}
