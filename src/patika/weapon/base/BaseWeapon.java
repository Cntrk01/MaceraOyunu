package patika.weapon.base;

import patika.player.Player;
import patika.weapon.Pistol;
import patika.weapon.Rifle;
import patika.weapon.Sword;

public abstract class BaseWeapon {
    private String gunId;
    private int gunDamage;
    private int gunMoney;
    private String gunName;

    public BaseWeapon(String gunId, int gunDamage, int gunMoney, String gunName) {
        this.gunId = gunId;
        this.gunDamage = gunDamage;
        this.gunMoney = gunMoney;
        this.gunName = gunName;
    }
    //Yada abstract class değilde normal weapon sınıfı oluşturup şöyle bir içerik yapabilirdim
    //    public BaseWeapon[] weapons(){
    //        Weapon[] weaponList = new Weapon[3];
    //        weaponList[0] = new Weapon("Tabanca",1,2,25) isim id hasar para şekilde burada bütün silahları ekleyip de yapabilirdim ama ben uzun solukta her weaponun kendine has içerik eklenmesi durumunu gözeterek özel özel class açtım
    //    }

    public void setPlayerWeaponValue(Player player){
        player.setDamage(player.getDamage() + this.gunDamage);
        player.setMoney(player.getMoney()-this.getGunMoney());
        System.out.println(
                this.gunName + " Silahını Satın Aldınız." +
                "\nKalan Paranız : " + player.getMoney()
        );
        System.out.println("Önceki Silahınız : " + player.getInventory().getWeapon().getGunName());
        player.getInventory().setWeapon(this);
        System.out.println("Yeni Silahınız : " + player.getInventory().getWeapon().getGunName());
    }

    public String getGunId() {
        return gunId;
    }

    public void setGunId(String gunId) {
        this.gunId = gunId;
    }

    public int getGunDamage() {
        return gunDamage;
    }

    public void setGunDamage(int gunDamage) {
        this.gunDamage = gunDamage;
    }

    public int getGunMoney() {
        return gunMoney;
    }

    public void setGunMoney(int gunMoney) {
        this.gunMoney = gunMoney;
    }

    public String getGunName() {
        return gunName;
    }

    public void setGunName(String gunName) {
        this.gunName = gunName;
    }

    public static BaseWeapon[] baseWeapons(){
        return new BaseWeapon[]{new Pistol(2, 10, "Tabanca"), new Sword(3, 35, "Kılıç"), new Rifle(7, 45, "Tüfek")};
    }
}
