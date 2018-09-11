package Players;

import Bases.*;
import Enemies.Enemy;

public class Player extends GameObject {
    PlayerMove playerMove;
    PLayerShoot pLayerShoot;

    public Player(int x, int y){
        super(x, y);
        renderer = new Animations(ImageUtil.load("images/player/MB-70/player1.png"),
                ImageUtil.load("images/player/MB-70/player2.png"),
                ImageUtil.load("images/player/MB-70/player3.png"),
                ImageUtil.load("images/player/MB-70/player4.png"));
        playerMove = new PlayerMove();
        pLayerShoot = new PLayerShoot();
        this.boxCollider = new BoxCollider(x, y, 25, 80);
    }

    public void run(){
        super.run();
        this.move();
        this.shoot();//shoot
        hitEnemies();
    }

    void shoot() {
        pLayerShoot.run(this);
    }

    void move(){
        this.playerMove.run(this.position);
    }

    private void hitEnemies(){
        Enemy enemy = GameObject.checkCollision(this.boxCollider, Enemy.class);
        if(enemy != null){
            System.out.println("Hit!");
            enemy.getHit();
            this.destroy();
        }
    }

    public void getHit() {
        this.death();
    }
}

