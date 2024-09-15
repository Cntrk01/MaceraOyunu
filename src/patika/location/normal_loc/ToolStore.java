package patika.location.normal_loc;

import patika.armor.HeavyArmor;
import patika.armor.LightArmor;
import patika.armor.MediumArmor;
import patika.armor.base.BaseArmor;
import patika.location.base.Location;
import patika.player.Player;
import patika.weapon.base.BaseWeapon;
import patika.weapon.Pistol;
import patika.weapon.Rifle;
import patika.weapon.Sword;

import static patika.armor.base.BaseArmor.baseArmors;
import static patika.weapon.base.BaseWeapon.baseWeapons;

public class ToolStore extends Location {
    public ToolStore(Player player) {
        super(player, "Eşya Dükkanı","2");
    }

    @Override
    public void onLocation() {
        super.setLocationStatus(true);
        System.out.println("\n----------------Mağazaya Hoşgeldiniz----------------\n");

        boolean showMenu = true;
        while (showMenu){
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış Yap");
            System.out.println("Seçiminiz : ");

            int selectCase = Location.input.nextInt();

            while (selectCase<1 || selectCase>3){
                System.out.println("Geçersiz değer, tekrar giriniz : ");
                selectCase = Location.input.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon(baseWeapons());
                    break;
                case 2:
                    printArmor();
                    buyArmor(baseArmors());
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz !");
                    showMenu = false;

                    super.setLocationStatus(true); // True döndüğüm için bu methoddan çıkış yapıyor. Break de kullanabilirim
            }
        }
    }

    //Solid prensibine göre her methodun 1 işi olmalıdır bundan dolayı buyWeapon fonksiyonunu ayrıca yazdık.Bundan dolayı da baseWeapons methodunu yazdım
    private void printWeapon() {
        System.out.println("\n---------------- Silahlar ----------------\n");

        for (BaseWeapon baseWeapon : baseWeapons()){
            System.out.println(
                    "ID : " + baseWeapon.getGunId() +
                    "\tİsim : " + baseWeapon.getGunName() +
                    "\tHasar : " + baseWeapon.getGunDamage() +
                    "\tPara : " + baseWeapon.getGunMoney()
            );
        }
        System.out.println("0 - Çıkış Yap");
    }

    private void buyWeapon(BaseWeapon[] baseWeapons){
        System.out.println("Bir silah seçin : ");
        int selectCase = Location.input.nextInt();

        //selectCase>baseWeapons.length şeklinde yaptım her silah eklediğimde > den sonraki sayıyı güncellemek zorudna kalıcaktım.
        while (selectCase<0 || selectCase>baseWeapons.length){
            System.out.println("Geçersiz değer, tekrar giriniz : ");
            selectCase = input.nextInt();
        }

        if (selectCase != 0){
            if (baseWeapons[selectCase-1].getGunMoney() > this.getPlayer().getMoney()){
                System.out.println("Yeterli paranız bulunmamaktadır !!");
            }else{
                //Satın alma işleminin gerçekleştiği yer
                baseWeapons[selectCase-1].setPlayerWeaponValue(this.getPlayer());
            }
        }
    }

    private void buyArmor(BaseArmor[] baseArmors) {
        System.out.println("Bir zırh seçin : ");
        int selectCase = Location.input.nextInt();

        while (selectCase<0 || selectCase>baseArmors.length){
            System.out.println("Geçersiz değer, tekrar giriniz : ");
            selectCase = input.nextInt();
        }

        if (selectCase != 0){
            if (baseArmors[selectCase-1].getArmorPrice() > this.getPlayer().getMoney()){
                System.out.println("Zırh Almak İçin Yeterli paranız bulunmamaktadır !!");
            }else{
                baseArmors[selectCase-1].setPlayerArmorValue(this.getPlayer());
            }
        }
    }

    private void printArmor() {
        System.out.println("\n---------------- Zırh ----------------\n");
        for (BaseArmor baseArmor : baseArmors()){
            System.out.println(
                    "ID : " + baseArmor.getArmorId() +
                    "\tİsim : " + baseArmor.getArmorName() +
                    "\tBlok : " + baseArmor.getArmorBlock() +
                    "\tPara : " + baseArmor.getArmorPrice());
        }
    }
}
