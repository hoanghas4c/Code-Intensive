import java.awt.*;

public class PlayerBullet {
    int x;
    int y;
    Image image;

    PlayerBullet(int x, int y){
        this.x = x;
        this.y = y;
        this.image = ImageUtil.load("images/bullet/player/mb69bullet1.png");
    }

    void render(Graphics g){
        g.drawImage(this.image, this.x, this.y, null);
    }


    //logic thuần
    void run(){
        this.y -= 10;
    }
}
