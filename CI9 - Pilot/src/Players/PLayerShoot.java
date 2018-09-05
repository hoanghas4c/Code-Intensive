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
            PlayerBullet newBullet = new PlayerBullet((int)bulletPosition.x ,(int)bulletPosition.y);
            GameObject.add(newBullet);
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
