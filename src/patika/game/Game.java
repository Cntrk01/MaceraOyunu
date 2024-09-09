package patika.game;

import patika.player.Player;

import static patika.location.base.Location.input;

public class Game {

    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.println("Lütfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " Hoşgeldiniz !");
        System.out.println("Lütfen bir karakter seçiniz : ");
        player.selectChar();
        player.selectLoc();
    }
}
