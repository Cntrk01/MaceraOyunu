package patika.location.base;

import patika.player.Player;

import java.util.Scanner;

public abstract class Location {
    private String id;
    private Player player;
    private String locationName;
    private boolean locationStatus = true;
    public static Scanner input = new Scanner(System.in);

    public Location(Player player, String locationName) {
        this.player = player;
        this.locationName = locationName;
    }

    public Location(Player player, String locationName, String id) {
        this.player = player;
        this.locationName = locationName;
        this.id = id;
    }

    public abstract void onLocation();

    public boolean isLocationStatus() {
        return locationStatus;
    }

    public void setLocationStatus(boolean locationStatus) {
        this.locationStatus = locationStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
