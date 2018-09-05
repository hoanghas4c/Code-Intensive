package Enemies;

import Bases.FrameCounter;
import Bases.GameObject;
import Bases.Vector2D;

public class EnemyShoot {
    FrameCounter frameCounter = new FrameCounter(100);

    public void run(Enemy enemy) {
        frameCounter.run();
        if (frameCounter.expired) {
            Vector2D bulletPosition = enemy.position.add(0, 20);
            EnemyBullet newB = new EnemyBullet((int)bulletPosition.x, (int)bulletPosition.y);
            GameObject.add(newB);
            frameCounter.reset();
        }
    }
}