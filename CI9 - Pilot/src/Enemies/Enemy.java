package enemies;

import bases.*;

public class Enemy extends GameObject {
    EnemyShoot enemyShoot;
    public Enemy(int x, int y){
        super(x, y);

        enemyShoot = new EnemyShoot();
        renderer = new Animations(
                ImageUtil.load("images/enemy/bacteria/bacteria1.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria2.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria3.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria4.png")
        );
        this.boxCollider = new BoxCollider(x, y, 30, 30);
    }

    public void run(){
        this.move();
        this.shoot();
        deactivateIfNeeded();
    }

    public void shoot() {
        enemyShoot.run(this);
    }

    public void move(){
        super.run();
       this.position.addUp(0, 3);
    }

    private void deactivateIfNeeded(){
        if (this.position.y > 800){
            this.isActive = false;
        }
    }


    public void getHit(){
        this.destroy();
        EnemyExplosion enemyExplosion = new EnemyExplosion((int)this.position.x,
                (int)this.position.y);
        enemyExplosion.run();
        GameObject.add(enemyExplosion);

    }
}
