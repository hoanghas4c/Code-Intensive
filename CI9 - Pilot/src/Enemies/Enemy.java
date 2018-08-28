package Enemies;

import Bases.ImageUtil;
import Bases.Vector2D;

import java.awt.*;

public class Enemy {
    Vector2D position;
    Image image;

    public Enemy(int x, int y){
       this.position = new Vector2D(x, y);
       this.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
    }

    public void render(Graphics g){
        g.drawImage(this.image, (int)position.x, (int)position.y, null);
    }

    //logic thuần
    public void run(){
        Vector2D velocity = new Vector2D();
        velocity.y += 3;
        this.position.addUp(velocity);
    }
}
