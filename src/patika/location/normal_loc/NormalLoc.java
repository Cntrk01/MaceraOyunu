package patika.location.normal_loc;

import patika.location.base.Location;
import patika.player.Player;


public class NormalLoc extends Location {

    public NormalLoc(Player player, String locationName) {
        super(player, locationName,"1");
    }

    @Override
    public void onLocation() {
        System.out.println("This is NormalLoc Class");
    }
}
