package patika.location.battle_loc.location;

import patika.armor.base.BaseArmor;
import patika.factory.EquipmentFactory;
import patika.location.battle_loc.BattleLoc;
import patika.location.battle_loc.obstacle.Snake;
import patika.player.Player;
import patika.weapon.base.BaseWeapon;

import java.util.Random;

public class Coal extends BattleLoc {

    private static final Random randomCalculator = new Random();

    public Coal(Player player) {
        super(player, "Maden", new Snake(),"GİZEMLİ", "6", 6);
    }

    @Override
    public void onLocation() {
        super.onLocation();
        if (this.isLocationStatus()){
            calculateReward();
        }
    }

    //Silah kazanma ihtimali %15 Zırh Kazanma ihtimali %15 Para Kazanma İhtimali %25 . Hiçbirşey kazanmama ihtimali de %45 hesaplaması yapılıyor.
    private void calculateReward() {
        int roll = randomCalculator.nextInt(100) + 1; // 1-100 arasında bir sayı

        if (roll <= 15) { // %15 Silah kazanma ihtimali
            String weapon = getWeapon();
            System.out.println("Silah Kazandınız: " + weapon + " Envantere Eklendi...");
        } else if (roll <= 30) { // %15 Zırh kazanma ihtimali
            String armor = getArmor();
            System.out.println("Zırh Kazandınız: " + armor + " Envantere Eklendi...");
        } else if (roll <= 55) { // %25 Para kazanma ihtimali
            int money = getMoney();
            System.out.println("Para Kazandınız: " + money + " Envantere Eklendi...");
        } else { // %45 Hiçbir şey kazanmama ihtimali
            System.out.println("Hiçbir şey kazanmadınız.");
        }
    }

    //Silah kazanırsa eğer Tüfek kazanma ihtimali %20
    //Kılıç %30
    //Tabanca %50 hesaplaması
    private String getWeapon() {
        int weaponRoll = randomCalculator.nextInt(100) + 1;
        String weaponName;

        if (weaponRoll <= 20) { // %20 Tüfek
            weaponName = "Tüfek";
        }
        else if (weaponRoll <= 50) { // %30 Kılıç
            weaponName = "Kılıç";
        }
        else { // %50 Tabanca
            weaponName ="Tabanca";
        }

        BaseWeapon weapon = EquipmentFactory.getWeaponByName(weaponName);
        this.getPlayer().getInventory().setWeapon(weapon);

        return weaponName;
    }
    //Zırh Kazanırsa Ağır Zırh %20
    //Orta Zırh %30
    //Hafif Zırh %50
    private String getArmor() {
        int armorRoll = randomCalculator.nextInt(100) + 1;
        String armorName;

        if (armorRoll <= 20) { // %20 Ağır Zırh
            armorName = "Ağır Zırh";
        } else if (armorRoll <= 50) { // %30 Orta Zırh
            armorName = "Orta Zırh";
        } else { // %50 Hafif Zırh
            armorName = "Hafif Zırh";
        }

        BaseArmor armor = EquipmentFactory.getArmorByName(armorName);
        this.getPlayer().getInventory().setArmor(armor);

        return armorName;
    }

    //Para Kazanırsa 10 Para ihtimali %20
    //5 Para ihtimali %30
    //1 Para ihtimali %50
    private int getMoney() {
        int moneyRoll = randomCalculator.nextInt(100) + 1;
        int money;

        if (moneyRoll <= 20) { // %20 10 Para
            money= 10;
        } else if (moneyRoll <= 50) { // %30 5 Para
            money= 5;
        } else { // %50 1 Para
            money= 1;
        }
        this.getPlayer().setMoney(this.getPlayer().getMoney() + money);

        return money;
    }
}
