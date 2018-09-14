package enemies;

import bases.Animations;
import bases.GameObject;
import bases.ImageUtil;

public class EnemyExplosion extends GameObject {

    public EnemyExplosion(int x, int y){
        super(x, y);
        this.renderer = new Animations(3, true, ImageUtil.load("images/enemy/bacteria/bacteria_dead1.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria_dead2.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria_dead3.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria_dead4.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria_dead5.png"));
    }


    @Override
    public void run() {
        super.run();
        Animations animations = (Animations)this.renderer;
        if(animations.finished){
            this.destroy();
        }
    }
}
