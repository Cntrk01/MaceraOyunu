package patika.weapon;

import patika.weapon.base.BaseWeapon;

public class Rifle extends BaseWeapon {
    public Rifle(int gunDamage, int gunMoney, String gunName) {
        super("3", gunDamage, gunMoney, gunName);
    }
}
