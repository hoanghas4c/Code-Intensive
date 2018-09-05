package Enemies;

import Bases.GameObject;
import Bases.ImageRenderer;
import java.util.ArrayList;

public class Enemy extends GameObject {
    public ArrayList<EnemyBullet>enemyBullets;
    EnemyShoot enemyShoot;
    int time;
    public Enemy(int x, int y){
        super(x, y);
        enemyBullets = new ArrayList<>();
        imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
    }

    public void shootLock(){
        if(this.position.y > 780){
            return;
        }
        ++time;
        if(time > 30){
            enemyBullets.add(new EnemyBullet((int)position.x, (int)position.y));
            time = 0;
        }
    }

    public void shoot() {
        this.enemyShoot.run(this);
    }

    public void run(){
       this.position.addUp(0, 3);
    }
}
