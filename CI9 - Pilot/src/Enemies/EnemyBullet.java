package Enemies;

import Bases.BoxCollider;
import Bases.ImageRenderer;
import Bases.GameObject;
import Players.Player;

public class EnemyBullet extends GameObject{

    public EnemyBullet(int x, int y){
        super(x, y);
        imageRenderer = new ImageRenderer("images\\bullet\\enemy\\enemy2_bullet1.png");
        this.boxCollider = new BoxCollider(x, y, 20, 20);
    }

    public void run(){
        super.run();
        this.position.addUp(0, 5);
        hitPlayer();
    }

    private void hitPlayer(){
        Player player = GameObject.playerCollision(this.boxCollider);
        if (player != null){
            player.getHit();
            player.destroy();
        }
    }
}
