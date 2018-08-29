package Enemies;

import Bases.ImageUtil;
import Bases.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public class Enemy {
    Vector2D position;
    Image image;
    public ArrayList<EnemyBullet>enemyBullets;
    int time; // bullets spawned at the amount of time

    public Enemy(int x, int y){
        enemyBullets = new ArrayList<>();
       this.position = new Vector2D(x, y);
       this.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
    }

    public void render(Graphics g){
        g.drawImage(this.image, (int)position.x, (int)position.y, null);
        for (EnemyBullet e: enemyBullets)
            e.render(g);
    }

    public void shootLock(){
        if(position.y > 780){
            return;
        }
        ++time;
        if(time > 30){
            enemyBullets.add(new EnemyBullet((int)position.x, (int)position.y));
            time = 0;
        }
    }

    //logic thuần
    public void run(){
        Vector2D velocity = new Vector2D();
        velocity.y += 3;
        this.position.addUp(velocity);
        for (EnemyBullet e: enemyBullets){
            e.run();
        }
        shootLock();
    }
}
