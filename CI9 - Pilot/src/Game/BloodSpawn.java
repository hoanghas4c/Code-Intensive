package game;

import bases.FrameCounter;
import bases.GameObject;
import java.util.Random;

public class BloodSpawn extends GameObject {
    Random random;
    FrameCounter frameCounter = new FrameCounter(100);
    public BloodSpawn(){
        super(0, 0);
        random = new Random();
    }

    public void run(){
        frameCounter.run();
        if (frameCounter.expired){
            BloodCell bloodCell = new BloodCell(0 ,random.nextInt(800));
            GameObject.add(bloodCell);
            frameCounter.reset();
        }
    }
}
