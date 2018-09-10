package Players;

import Bases.FrameCounter;
import Bases.GameObject;
import Bases.Vector2D;
import Inputs.InputManager;

public class PLayerShoot {
    boolean shootLock = false;//shoot
    FrameCounter frameCounter =  new FrameCounter(20);

    void run(Player player){
        if(InputManager.instance.xPressed && !this.shootLock){
            Vector2D bulletPosition = player.position.subtract(0, 30);
            PlayerBullet newBullet = GameObject.recycle((int)bulletPosition.x, (int)bulletPosition.y);
            this.shootLock = true;
        }

        if(shootLock){
            frameCounter.run();
            if(frameCounter.expired){
                shootLock = false;
                frameCounter.reset();
            }
        }
    }

}
