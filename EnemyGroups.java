
/**
 * Enum s typami rôznych nepriatelskych skupin proti ktorym možno bojovať
 * 
 * @author Michal Zúbek
 * @version 0.9
 */
public enum EnemyGroups {
    /**
     * skupina 3 potkanov
     */
    RATS(3,0,0,0),
    
    /**
     * skupina 2 banditov
     */
    SCOUTS(0,0,2,0),
    
    /**
     * skupina 2 banditov a 2 vlkov
     */
    BANDITCAMP(0,2,2,0),
    
    /**
     * jeden bandit boss
     */
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
    
    /**
     * vrati pocet potkanov
     * @return int ratCount
     */
    public int getRatCount() {
        return this.ratCount;
    }
    
    /**
     * vrati pocet vlkov
     * @return int wolfCount
     */
    public int getWolfCount() {
        return this.wolfCount;
    }
    
    /**
     * vrati pocet banditov
     * @return int banditCount
     */
    public int getBanditCount() {
        return this.banditCount;
    }
    
    /**
     * vrati pocet bandit bossov
     * @return int banditBossCount
     */
    public int getBanditBossCount() {
        return this.banditBossCount;
    }
}
