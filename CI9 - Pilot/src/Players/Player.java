package players;

import bases.*;
import enemies.Enemy;

public class Player extends GameObject {
    private PlayerMove playerMove;
    private PLayerShoot pLayerShoot;
    private PlayerAnimator playerAnimator;

    public Player(int x, int y){
        super(x, y);
        this.playerAnimator = new PLayerAnimator();
       this.renderer = this.playerAnimator();
        playerMove = new PlayerMove();
        pLayerShoot = new PLayerShoot();
        this.boxCollider = new BoxCollider(x, y, 25, 80);
    }

    public void run(){
        super.run();
        this.move();
        this.shoot();//shoot
        this.animate();

        hitEnemies();
    }

    private void animate() {
        this.playerAnimator.selectAnimation(this);
    }

    void shoot() {
        pLayerShoot.run(this);
    }

    void move(){
        this.playerMove.run(this.position);
    }

    private void hitEnemies(){
        Enemy enemy = GameObject.checkCollision(this.boxCollider, Enemy.class);
        if(enemy != null){
            System.out.println("Hit!");
            enemy.getHit();
            this.destroy();
        }
    }

    public void getHit() {
        this.death();
    }
}

