
/**
 * Enumeration class EnemyGroups - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum EnemyGroups {
    RATS(3,0,0,0),
    SCOUTS(0,0,2,0),
    BANDITCAMP(0,2,2,0),
    BANDITLEADER(0,0,0,1);
    
    private int ratCount;
    private int wolfCount;
    private int banditCount;
    private int banditBossCount;
    EnemyGroups(int ratCount, int wolfCountmy2, int banditCount, int banditBossCount){
        this.ratCount = ratCount;
        this.wolfCount = wolfCount;
        this.banditCount = banditCount;
        this.banditBossCount = banditBossCount;
    }
    public int getRatCount() {
        return this.ratCount;
    }
    public int getWolfCount() {
        return this.wolfCount;
    }
    public int getBanditCount() {
        return this.banditCount;
    }
    public int getBanditBossCount() {
        return this.banditBossCount;
    }
}
