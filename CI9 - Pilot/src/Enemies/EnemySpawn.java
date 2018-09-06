package Enemies;

import Bases.FrameCounter;
import Bases.GameObject;
import java.util.Random;

public class EnemySpawn {
    Random random;
    FrameCounter frameCounter = new FrameCounter(30);
    public EnemySpawn(){
        random = new Random();
    }

    public void run(){
        frameCounter.run();
        if (frameCounter.expired){
            Enemy enemy = new Enemy(random.nextInt(600), 0);
            GameObject.add(enemy);
            frameCounter.reset();
        }
    }
}
