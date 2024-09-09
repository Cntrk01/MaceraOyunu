package patika.armor.base;

import patika.player.Player;

public abstract class BaseArmor {
    private String armorId;
    private String armorName;
    private int armorBlock;
    private int armorPrice;

    public BaseArmor(String armorId, String armorName, int armorBlock, int armorPrice) {
        this.armorId = armorId;
        this.armorName = armorName;
        this.armorBlock = armorBlock;
        this.armorPrice = armorPrice;
    }

    public void setPlayerArmorValue(Player player){
        player.setArmor(this.armorBlock);
        player.setMoney(player.getMoney() - this.getArmorPrice());
        System.out.println(
                this.armorName + " Zırhını Satın Aldınız." +
                "\nKalan Paranız : " + player.getMoney()
        );
        System.out.println("Önceki Zırhınız : " + player.getInventory().getArmor().getArmorName());
        player.getInventory().setArmor(this);
        System.out.println("Yeni Silahınız : " + player.getInventory().getArmor().getArmorName());
    }

    public String getArmorId() {
        return armorId;
    }

    public void setArmorId(String armorId) {
        this.armorId = armorId;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorBlock() {
        return armorBlock;
    }

    public void setArmorBlock(int armorBlock) {
        this.armorBlock = armorBlock;
    }

    public int getArmorPrice() {
        return armorPrice;
    }

    public void setArmorPrice(int armorPrice) {
        this.armorPrice = armorPrice;
    }
}
