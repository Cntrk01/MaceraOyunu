package patika.location.battle_loc.location;

import patika.location.battle_loc.BattleLoc;
import patika.location.battle_loc.obstacle.Zombie;
import patika.player.Player;

public class Cave extends BattleLoc {

    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), "Yemek","3",3);
    }

    @Override
    public void onLocation() {
        super.onLocation();
        if (this.isLocationStatus()){
            System.out.println("Yemek kazanıldı . Envantere eklendi...");
            this.getPlayer().getInventory().setFood(true);
        }
    }
}
