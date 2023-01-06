/**
 *  Jednotlivé políčko na mape. 
 *  Obsahuje obrázok a jeho typ.
 * 
 * @author Michal Zúbek
 * @version 0.1
 */
public class Policko {
    private TypPolicka typ;
    private Obrazok policko;
    
    public Policko(int pozX, int pozY, TypPolicka typ) {
        this.typ = typ;
        this.policko = new Obrazok(this.typ.getObrazok());
        this.nakresliObrazok(pozX, pozY);
    }
    
    /**
    *  Zmení polohu obrázku a zobrazí ho.
    */
    public void nakresliObrazok(int pozX, int pozY) {
        this.policko.zmenPolohu(pozX + 25, pozY + 25);
        this.policko.zobraz();
    }
    
    public Obrazok getObrazok() {
        return this.policko;
    }
    
    public void zmenaNaGrass() {
        /**
         *  Zmení políčko na grass typ.
         */
        this.typ = this.typ.GRASS;
        this.policko.zmenObrazok(this.typ.getObrazok());
    }
    
    public TypPolicka getTyp() {
        return this.typ;
    }
}
