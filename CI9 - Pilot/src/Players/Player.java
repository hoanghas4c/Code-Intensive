package Players;

import java.awt.*;
import java.util.ArrayList;
import Bases.ImageRenderer;
import Bases.Vector2D;


public class Player {
    Vector2D position;

    ImageRenderer imageRenderer;
    PlayerMove playerMove;
    PLayerShoot pLayerShoot;

    public ArrayList<PlayerBullet> bullets;

    public Player(int x, int y){
        this.position = new Vector2D(x, y);
        imageRenderer = new ImageRenderer("images/player/MB-70/player1.png");
        playerMove = new PlayerMove();
        pLayerShoot = new PLayerShoot();
    }


    // Method inserted
    public void render(Graphics g){
            imageRenderer.render(g, this.position);
    }

    public void run(){
        this.move();
        this.shoot();//shoot
    }

    void shoot() {
        pLayerShoot.run(this);
        for(PlayerBullet b: bullets)
        {
            b.run();
        }

    }

    void move(){
        this.playerMove.run(position);
    }

}

