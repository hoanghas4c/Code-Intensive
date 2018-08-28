package Players;

import java.awt.*;

public class PlayerBullet {
    Vector2D position;
    Image image;

    PlayerBullet(int x, int y){
        this.position = new Vector2D(x ,y);
        this.image = ImageUtil.load("images/bullet/player/mb69bullet1.png");
    }

    void render(Graphics g){
        g.drawImage(this.image, (int)position.x, (int)position.y, null);
    }


    //logic thuần
    void run(){
        Vector2D velocity = new Vector2D();
        velocity.y -= 5;
        this.position.addUp(velocity);
    }
}
