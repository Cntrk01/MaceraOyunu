package patika.location.battle_loc;

import patika.location.base.Location;
import patika.player.Player;

public abstract class BattleLoc  extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player,String locName,Obstacle obstacle,String award, String id,int maxObstacle) {
        super(player,locName,id);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public void onLocation() {
        int obsNumber = this.randomObstacleNumber(this.getMaxObstacle());

        System.out.println("Şuan Buradasınız : " + this.getLocationName());
        System.out.println("Dikkatli Ol Burada  "+ obsNumber + " tane " + this.getObstacle().getName() + " Yaşıyor\n");

        boolean validInput = false;
        String selectCase = "";

        while (!validInput) {
            System.out.print("<S>avaş veya <K>aç : ");
                selectCase = input.nextLine().toUpperCase();
                if (selectCase.equals("S") || selectCase.equals("K")) {
                    validInput = true;
                } else {
                    System.out.println("Hatalı giriş! Lütfen 'S' veya 'K' girin.");
                }
        }

        switch (selectCase) {
            case "S":
                if (combat(this.getMaxObstacle())) {
                    System.out.println(this.getLocationName() + " tüm düşmanları yendiniz !!! ");
                    super.setLocationStatus(true);
                } else {
                    System.out.println(this.getLocationName() + " Lokasyonunda Öldünüz.");
                    super.setLocationStatus(false);
                }
                break;

            case "K":
                System.out.println("Geri dönüldü.");
                super.setLocationStatus(false);
                break;
        }

        if (this.getPlayer().getHealth()<=0){
            super.setLocationStatus(false);
        }
    }

    public boolean combat(int obsNumber){
        boolean status = false;
        int atackCounter = 1;

        do {
            System.out.println("----------"+atackCounter + " .Atak---------------");
            //Bunu yapma sebebimiz 1.canavar öldükten sonra while loop bitiyor ama bizim daha canavarımız olduğu için tekrar can setlemesi yapıyoruz.
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());

            playerStats();
            obstacleStats();

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                String selectCombat = "";
                boolean validInput = false;

                // Geçerli bir giriş alınana kadar döngü devam eder
                while (!validInput) {
                    System.out.print("<V>ur veya <K>aç : ");
                    selectCombat = input.nextLine().toUpperCase();

                    if (selectCombat.equals("V") || selectCombat.equals("K")) {
                        validInput = true;

                        if (Math.random() < 0.5) {
                            System.out.println("İlk vuruş oyuncuda!");
                            playerHit();
                        } else {
                            System.out.println("İlk vuruş canavarda!");
                            obstacleHit();
                        }
                    } else {
                        System.out.println("Hatalı giriş! Lütfen 'V' veya 'K' girin.");
                    }
                }
                switch (selectCombat) {
                    case "V":
                        playerHit();

                        if (this.getObstacle().getHealth() > 0) {
                            obstacleHit();
                        }
                        break;

                    case "K":
                        System.out.println("Geri dönüldü.");
                        return false; // Döngüden çıkış yapar
                }
            }

            if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                if (atackCounter == obsNumber-1){
                    status = true;
                }
                System.out.println("Tebrikler "+ atackCounter +". Düşmanı Yendiniz...");
                System.out.println(this.getObstacle().getAward() + " para kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("Güncel Paranız : " + this.getPlayer().getMoney());
            }else{
                status=false;
            }

            atackCounter++;

        } while (atackCounter <= obsNumber);

        return status;
    }

    private void obstacleHit(){
        System.out.println("Canavar Size Vurdu...");

        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().armor().getArmorBlock();

        if (obstacleDamage < 0) {
            obstacleDamage = 0;
        }
        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
        reportHp();
    }

    private void playerHit(){
        System.out.println("Siz Vurdunuz...");
        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
        reportHp();
    }

    private void reportHp() {
        System.out.println("Canınız : " +this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println();
    }

    private void obstacleStats() {
        System.out.println(this.getObstacle().getName() + " Değerleri :");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getAward());
        System.out.println();
    }

    private void playerStats() {
        System.out.println("Oyuncu Değerleri : ");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println("Silah : " + this.getPlayer().weapon().getGunName());
        System.out.println("Zırh : " + this.getPlayer().armor().getArmorName());
        System.out.println("Bloklama : " + this.getPlayer().armor().getArmorBlock());
        System.out.println();
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
