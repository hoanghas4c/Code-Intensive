package Enemies;

import Bases.GameObject;
import Bases.ImageRenderer;
import java.util.ArrayList;

public class Enemy extends GameObject {
    public ArrayList<EnemyBullet>enemyBullets;
    EnemyShoot enemyShoot;
    public Enemy(int x, int y){
        super(x, y);
        enemyBullets = new ArrayList<>();
        imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
    }

    public void shoot() {
        enemyShoot.run(this);
    }

    public void run(){
       this.position.addUp(0, 3);

    }
}
