package patika.factory;

import patika.armor.base.BaseArmor;
import patika.weapon.base.BaseWeapon;

import java.util.HashMap;
import java.util.Map;

import static patika.armor.base.BaseArmor.baseArmors;
import static patika.weapon.base.BaseWeapon.baseWeapons;

public class EquipmentFactory {

    private static final Map<String, BaseWeapon> weaponsMap = new HashMap<>();

    static {
        for (BaseWeapon weapon : baseWeapons()) {
            weaponsMap.put(weapon.getGunName(), weapon);
        }
    }

    private static final Map<String, BaseArmor> armorsMap = new HashMap<>();

    static {
        for (BaseArmor armor : baseArmors()) {
            armorsMap.put(armor.getArmorName(), armor);
        }
    }

    public static BaseWeapon getWeaponByName(String name) {
        return weaponsMap.get(name);
    }

    public static BaseArmor getArmorByName(String name) {
        return armorsMap.get(name);
    }
}
