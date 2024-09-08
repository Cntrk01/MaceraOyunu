package patika.player;

import patika.armor.base.BaseArmor;
import patika.character.base.GameCharacter;
import patika.character.Archer;
import patika.character.Knight;
import patika.character.Samurai;
import patika.inventory.Inventory;
import patika.location.base.Location;
import patika.location.battle_loc.BattleLoc;
import patika.location.battle_loc.location.Cave;
import patika.location.battle_loc.location.Forest;
import patika.location.battle_loc.location.River;
import patika.location.normal_loc.SafeHouse;
import patika.location.normal_loc.ToolStore;
import patika.weapon.base.BaseWeapon;

import java.util.Scanner;

public class Player {
    //Bunlar yerine bir GameCharacterden bir değiken yazıp selectChar içerisinde newleyerek de yapabilirdik yani private GameCharacter gameChar;  fonk içinde gameChar = newSamurai gibi
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    private int armor;
    private final Scanner scanner = new Scanner(System.in);
    private int firstHealth = 0;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        //Polimorfizm destekli bir yapı kurduk.Yeni bir karakter gelmesi durumunda newlenerek buraya eklemek yeterli olcaktır.
        GameCharacter[] charList = {new Samurai(), new Archer(), new Knight()};
        for (GameCharacter character : charList) {
            System.out.println(
                    "ID  : " + character.getId() +
                            "\t Karakter  : " + character.getName() +
                            "\t Hasar     : " + character.getDamage() +
                            "\t Sağlık    : " + character.getHealth() +
                            "\t Para      : " + character.getMoney());
        }
        System.out.println("--------------------------------");

        int selectChar = scanner.nextInt();
        if (selectChar < 1 || selectChar > charList.length) {
            System.out.println("Default Olarak Samuray Seçildi..");
            selectChar = 1;
        }
        initPlayer(charList[selectChar - 1]);
    }

    public void selectLoc() {
        Location[] locations = {new SafeHouse(this), new ToolStore(this),new Cave(this),new Forest(this),new River(this)};

        while (true){
            printInfo();

            System.out.println("\n################ BÖLGELER ###################\n");

            System.out.println("0 : Çıkış Yap -> Oyunu Sonlandır. ");

            for (Location location : locations) {
                if (location instanceof Cave || location instanceof Forest || location instanceof River){
                    System.out.println("ID : " + location.getId() + "\t Lokasyon : " + location.getLocationName() +" \tDikkatli Ol Karşına  " + ((BattleLoc) location).getObstacle().getName() + " \tÇıkabilir" + " \tÖdül : " + ((BattleLoc) location).getAward());
                }else{
                    System.out.println("ID : " + location.getId() + "\t Lokasyon : " + location.getLocationName());
                }
            }

            System.out.println("Gitmek İstediğiniz Bölgeyi Seçiniz : ");

            int selectLoc = scanner.nextInt();

            scanner.nextLine();

            if (selectLoc == 0){
                System.out.println("Oyun Sona Erdi....");
                break;
            }

            //Polimorfizim uygulayarak ilgili nesnenin methodu çalışıyor olacak
            if (selectLoc >= 1 && selectLoc <= locations.length) {
                locations[selectLoc - 1].onLocation();
            }
            else {
                System.out.println("Geçersiz seçim. Güvenli Ev'e yönlendiriliyorsunuz.");
                locations[0].onLocation();
            }
            //Eğer gittiği lokasyonda ölürse method false dönüyor böylelikle oyuncu ölüyor..
            //NOT :  locations[selectLoc - 1].onLocation() ile boolean kontrol sağlamaya çalışıyordum. Fakat bu method if () bloğunda kontrol edilirken tekrar çağırıdığından 2.kez çıktı alıyordum bundan dolayı yeni bir durum geliştirdim. Method bir boolean
            //dönüyor bu doğru fakat polimorfizm uyguladığım için ve ilgili nesnenin bodysi boş olmadığı için 2.kez burada çağırılıyordu.
            //if (selectLoc >= 1 && selectLoc <= locations.length && !locations[selectLoc - 1].isLocationStatus()) {
            //                System.out.println("GAME OVER");
            //                break;
            //            }
        }
    }

    //Seçilen karakterin değerlerini bu sınıftaki değişkenlere setliyoruz.
    public void initPlayer(GameCharacter character) {
        this.setCharName(character.getName());
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setMoney(character.getMoney());
        this.setFirstHealth(character.getHealth());
    }

    public void printInfo(){
        System.out.println(
                "\nSilahınız : " + this.getInventory().getWeapon().getGunName() +
                "\nZırh : " + this.getInventory().getArmor().getArmorName() +
                "\nBloklama : " + this.getInventory().getArmor().getArmorBlock() +
                "\nHasarınız : " + this.getTotalDamage() +
                "\nSağlık : " + this.getHealth() +
                "\nPara : " + this.getMoney()
        );
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDamage() {
        return damage;
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getGunDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health<0){
            health=0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public BaseWeapon weapon(){
        return this.getInventory().getWeapon();
    }

    public BaseArmor armor(){
        return this.getInventory().getArmor();
    }

    public int getFirstHealth() {
        return firstHealth;
    }

    public void setFirstHealth(int firstHealth) {
        this.firstHealth = firstHealth;
    }
}
