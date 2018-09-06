package Game;

import Bases.FrameCounter;
import Bases.GameObject;
import java.util.Random;

public class BloodSpawn{
    Random random;
    FrameCounter frameCounter = new FrameCounter(100);
    public BloodSpawn(){
        random = new Random();
    }

    public void run(){
        frameCounter.run();
        if (frameCounter.expired){
            BloodCell bloodCell = new BloodCell(random.nextInt(600) , 0);
            GameObject.add(bloodCell);
            frameCounter.reset();
        }
    }
}
