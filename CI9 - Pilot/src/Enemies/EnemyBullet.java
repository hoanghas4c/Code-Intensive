package Enemies;

import Bases.*;
import Players.Player;

public class EnemyBullet extends GameObject{

    public EnemyBullet(int x, int y){
        super(x, y);
        renderer = new Animations(ImageUtil.load("images/bullet/enemy/enemy2_bullet1.png"),
                ImageUtil.load("images/bullet/enemy/enemy2_bullet2.png"),
                ImageUtil.load("images/bullet/enemy/enemy2_bullet3.png"));
        this.boxCollider = new BoxCollider(x, y, 20, 20);
    }

    public void run(){
        super.run();
        this.position.addUp(0, 5);
        hitPlayer();
        deactivate();
    }

    private void deactivate(){
        if(this.position.y > 800){
            this.isActive = false;
        }
    }

    private void hitPlayer(){
        Player player = GameObject.checkCollision(this.boxCollider, Player.class);
        if (player != null){
            player.getHit();
            player.destroy();
        }
    }
}
