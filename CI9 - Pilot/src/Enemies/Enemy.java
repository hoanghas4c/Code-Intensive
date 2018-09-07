package Enemies;

import Bases.GameObject;
import Bases.ImageRenderer;

public class Enemy extends GameObject {
    EnemyShoot enemyShoot;
    public Enemy(int x, int y){
        super(x, y);
        enemyShoot = new EnemyShoot();
        imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
    }

    public void run(){
        this.move();
        this.shoot();
    }
    public void shoot() {
        enemyShoot.run(this);
    }

    public void move(){
       this.position.addUp(0, 3);

    }
}
