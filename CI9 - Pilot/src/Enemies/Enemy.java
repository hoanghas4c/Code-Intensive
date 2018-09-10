package Enemies;

import Bases.*;

import java.awt.*;
import java.util.ArrayList;

public class Enemy extends GameObject {
    EnemyShoot enemyShoot;
    public Enemy(int x, int y){
        super(x, y);

        ArrayList<Image> images = new ArrayList<>();
        images.add(ImageUtil.load("images/enemy/bacteria/bacteria1.png"));
        images.add(ImageUtil.load("images/enemy/bacteria/bacteria2.png"));
        images.add(ImageUtil.load("images/enemy/bacteria/bacteria3.png"));
        images.add(ImageUtil.load("images/enemy/bacteria/bacteria4.png"));

        enemyShoot = new EnemyShoot();
        renderer = new Animations(images);
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
