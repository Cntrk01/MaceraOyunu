package benimdeneme.oyuncu;

import benimdeneme.base.BaseKarakter;
import benimdeneme.base.karakter.envanter.Envanter;

public class Oyuncu extends BaseKarakter {
    private Envanter envanter;

    public Oyuncu(String isim, String id, int hasar, String saglik, int para,Envanter envanter) {
        super(isim, id, hasar, saglik, para);
        this.envanter=envanter;
    }

    public void setEnvanter(Envanter envanter) {
        this.envanter = envanter;
    }

    public Envanter getEnvanter() {
        return envanter;
    }

    public void karakterSec() {
        System.out.println("Karakter Sec");
        System.out.println("1) Samuray");
        System.out.println("2) Okçu");
        System.out.println("3) Şövalye");
    }
}
