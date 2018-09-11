package Players;

import Bases.*;
import Enemies.Enemy;

public class PlayerBullet extends GameObject{
    public PlayerBullet(int x, int y){
        super(x, y);
        renderer = new Animations(ImageUtil.load("images/bullet/player/mb70bullet1.png"),
                ImageUtil.load("images/bullet/player/mb70bullet2.png"),
                ImageUtil.load("images/bullet/player/mb70bullet3.png"),
                ImageUtil.load("images/bullet/player/mb70bullet4.png"));
        this.boxCollider = new BoxCollider(x, y , 10 , 20);
    }

    public void run(){
        super.run();
        this.move();
        hitEnemies();
        deactivateIfNeeded();
    }

    private void deactivateIfNeeded() {
        if(this.position.y < 0){
            this.isActive = false;
        }
    }

    private void move() {
        this.position.addUp(0, -5);
    }

    private void hitEnemies() {
        Enemy enemy = GameObject.checkCollision(this.boxCollider, Enemy.class);
        if ( enemy != null){
            System.out.println("HIT");
            enemy.getHit();
            this.destroy();
        }
    }
}
