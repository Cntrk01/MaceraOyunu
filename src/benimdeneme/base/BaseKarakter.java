package benimdeneme.base;

public abstract class BaseKarakter {
    private String id;
    private int hasar;
    private String saglik;
    private int para;
    private String isim;

    public BaseKarakter(String isim,String id, int hasar, String saglik, int para) {
        this.isim = isim;
        this.id = id;
        this.hasar = hasar;
        this.saglik = saglik;
        this.para = para;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHasar() {
        return hasar;
    }

    public void setHasar(int hasar) {
        this.hasar = hasar;
    }

    public String getSaglik() {
        return saglik;
    }

    public void setSaglik(String saglik) {
        this.saglik = saglik;
    }

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }
}
