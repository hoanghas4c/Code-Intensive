package Players;

import Bases.BoxCollider;
import Bases.GameObject;
import Bases.ImageRenderer;
import Enemies.Enemy;

public class Player extends GameObject {
    PlayerMove playerMove;
    PLayerShoot pLayerShoot;

    public Player(int x, int y){
        super(x, y);
        renderer = new ImageRenderer("images/player/MB-70/player1.png");
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

