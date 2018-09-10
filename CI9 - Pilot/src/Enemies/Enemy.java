package Enemies;

import Bases.BoxCollider;
import Bases.GameObject;
import Bases.ImageRenderer;

public class Enemy extends GameObject {
    EnemyShoot enemyShoot;
    public Enemy(int x, int y){
        super(x, y);
        enemyShoot = new EnemyShoot();
        renderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
        this.boxCollider = new BoxCollider(x, y, 30, 30);
    }

    public void run(){
        this.move();
        this.shoot();
    }
    public void shoot() {
        enemyShoot.run(this);
    }

    public void move(){
        super.run();
       this.position.addUp(0, 3);
    }

    public void getHit(){
        this.destroy();
    }
}
