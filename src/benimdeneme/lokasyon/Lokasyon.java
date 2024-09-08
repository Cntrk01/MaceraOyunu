package benimdeneme.lokasyon;

import benimdeneme.oyuncu.Oyuncu;

public abstract class Lokasyon {
    private Oyuncu oyuncu;
    private String isim;


    public void Lokasyon(){

    }

    abstract boolean onLokasyon();
}
