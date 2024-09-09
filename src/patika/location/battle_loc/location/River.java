package patika.location.battle_loc.location;

import patika.location.battle_loc.BattleLoc;
import patika.location.battle_loc.obstacle.Bear;
import patika.player.Player;

public class River extends BattleLoc {
    public River(Player player) {
        super(player, "Nehir", new Bear(),"Su", "5",2);
    }

    @Override
    public void onLocation() {
        super.onLocation();
        if (this.isLocationStatus()){
            System.out.println("Su kazanıldı . Envantere eklendi...");
            this.getPlayer().getInventory().setWater(true);
        }
    }
}