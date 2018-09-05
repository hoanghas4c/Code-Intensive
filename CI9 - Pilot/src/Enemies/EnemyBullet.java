package Enemies;

import Bases.ImageRenderer;
import Bases.GameObject;

public class EnemyBullet extends GameObject{

    public EnemyBullet(int x, int y){
        super(x, y);
        imageRenderer = new ImageRenderer("images\\bullet\\enemy\\enemy2_bullet1.png");
    }

    public void run(){
        super.run();
        this.position.addUp(0, 5);
    }
}
