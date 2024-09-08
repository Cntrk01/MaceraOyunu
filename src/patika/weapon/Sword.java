package patika.weapon;

import patika.weapon.base.BaseWeapon;

public class Sword extends BaseWeapon {
    public Sword( int gunDamage, int gunMoney, String gunName) {
        super("2", gunDamage, gunMoney, gunName);
    }
}
