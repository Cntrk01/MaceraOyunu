package patika.location.normal_loc;

import patika.player.Player;

public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public void onLocation() {
        super.setLocationStatus(true);
        System.out.println("\nGüvenli Evdesiniz !");
        System.out.println("Canınız Yenilendi !");
        System.out.println("Önceki Can : " + this.getPlayer().getHealth());
        this.getPlayer().setHealth(this.getPlayer().getFirstHealth());
        System.out.println("Yeni Can : " + this.getPlayer().getHealth());
    }
}
