package Players;

import Bases.BoxCollider;
import Bases.ImageRenderer;
import Bases.GameObject;
import Enemies.Enemy;

public class PlayerBullet extends GameObject{
    public PlayerBullet(int x, int y){
        super(x, y);
        imageRenderer = new ImageRenderer("images/bullet/player/mb69bullet1.png");
        this.boxCollider = new BoxCollider(x, y , 10 , 20);
    }

    public void run(){
        super.run();
        this.move();
        hitEnemies();
    }

    private void move() {
        this.position.addUp(0, -5);
    }

    private void hitEnemies() {
        Enemy enemy = GameObject.checkCollision(this.boxCollider);
        if ( enemy != null){
            System.out.println("HIT");
            enemy.getHit();
            this.destroy();
        }
    }
}
