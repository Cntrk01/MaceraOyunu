package benimdeneme.base.zirhlar.base;

public class BaseZirh {
    private String id;
    private int engelleme;
    private int para;

    public BaseZirh(String id, int engelleme, int para) {
        this.id = id;
        this.engelleme = engelleme;
        this.para = para;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEngelleme() {
        return engelleme;
    }

    public void setEngelleme(int engelleme) {
        this.engelleme = engelleme;
    }

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }
}
