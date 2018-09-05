package Players;

import Bases.GameObject;
import Bases.ImageRenderer;

public class Player extends GameObject {
    PlayerMove playerMove;
    PLayerShoot pLayerShoot;

    public Player(int x, int y){
        super(x, y);
        imageRenderer = new ImageRenderer("images/player/MB-70/player1.png");
        playerMove = new PlayerMove();
        pLayerShoot = new PLayerShoot();
    }

    public void run(){
        super.run();
        this.move();
        this.shoot();//shoot
    }

    void shoot() {
        pLayerShoot.run(this);
    }

    void move(){
        this.playerMove.run(this.position);
    }

}

