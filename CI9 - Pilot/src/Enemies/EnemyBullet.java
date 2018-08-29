package Enemies;

import Bases.ImageUtil;
import Bases.Vector2D;

import java.awt.*;

public class EnemyBullet {
    Vector2D position;
    Image image;

    public EnemyBullet(int x, int y){
        this.position = new Vector2D(x, y);
        this.image = ImageUtil.load("images\\bullet\\enemy\\enemy2_bullet1.png");
    }

    public void render(Graphics g){
        g.drawImage(this.image, (int)position.x, (int)position.y, null);
    }

    void run(){
        Vector2D velocity = new Vector2D();
        velocity.y += 5;
        this.position.addUp(velocity);
    }
}
