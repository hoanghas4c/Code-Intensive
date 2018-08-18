import java.awt.*;
import java.util.ArrayList;

public class Player {
    int x ;
    int y ;
    Image image;
    InputManager inputManager;

    Player(int x, int y){
        this.x = x;
        this.y = y;
        this.image = ImageUtil.load("images/player/MB-70/player1.png");
    }

    // Method inserted
    void render(Graphics g){
        g.drawImage(this.image, this.x, this.y, null);
    }

    void run(){
        if(inputManager.rightPressed){
            this.x += 5;
        }
        if(inputManager.leftPressed){
            this.x -= 5;
        }
        if(inputManager.upPressed){
            this.y -= 5;
        }
        if(inputManager.downPressed){
            this.y += 5;
        }
    }

    boolean shootLock = false;
    int count ;
    ArrayList<PlayerBullet> bullets;

    void shoot(){

        if(inputManager.xPressed && !shootLock){
            PlayerBullet newB = new PlayerBullet(this.x, this.y);
            bullets.add(newB);
            shootLock = true;
        }

        for(PlayerBullet b: bullets)
        {
            b.run();
        }

        if(shootLock){
            count++;
            if(count > 20)
            {
                shootLock = false;
                count = 0;
            }
        }

    }
}

