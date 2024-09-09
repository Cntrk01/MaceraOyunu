package patika.location.battle_loc.location;

import patika.location.battle_loc.BattleLoc;
import patika.location.battle_loc.obstacle.Vampire;
import patika.player.Player;

public class Forest extends BattleLoc {

    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "Odun", "4",3);
    }

    @Override
    public void onLocation() {
        super.onLocation();
        if (this.isLocationStatus()){
            System.out.println("Odun kazanıldı . Envantere eklendi...");
            this.getPlayer().getInventory().setWood(true);
        }
    }
}
