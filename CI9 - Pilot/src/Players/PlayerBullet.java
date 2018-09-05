package Players;

import Bases.ImageRenderer;
import Bases.GameObject;

public class PlayerBullet extends GameObject{
    public PlayerBullet(int x, int y){
        super(x, y);
        imageRenderer = new ImageRenderer("images/bullet/player/mb69bullet1.png");
    }
    //logic thuần
    public void run(){
        super.run();
        this.position.addUp(0, -5);
    }
}
