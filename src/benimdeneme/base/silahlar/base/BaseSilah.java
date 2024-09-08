package benimdeneme.base.silahlar.base;

public abstract class BaseSilah {
    private String id;
    private int hasar;
    private int para;

    public BaseSilah(String id, int hasar, int para) {
        this.id = id;
        this.hasar = hasar;
        this.para = para;
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

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }
}
