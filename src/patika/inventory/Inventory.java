package patika.inventory;

import patika.armor.EmptyArmor;
import patika.armor.base.BaseArmor;
import patika.weapon.base.BaseWeapon;
import patika.weapon.Punch;

public class Inventory {
    private BaseWeapon weapon;
    private BaseArmor armor;

    public Inventory() {
        this.weapon = new Punch("-1",0,0,"Yumruk");
        this.armor = new EmptyArmor("-1","Güçsüz Zırh",0,0);
    }

    public BaseWeapon getWeapon() {
        return weapon;
    }

    public void setWeapon(BaseWeapon weapon) {
        this.weapon = weapon;
    }

    public BaseArmor getArmor() {
        return armor;
    }

    public void setArmor(BaseArmor armor) {
        this.armor = armor;
    }
}
