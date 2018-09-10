package Game;

import Bases.GameObject;
import Bases.ImageRenderer;


public class BackGround extends GameObject {
    BackGround(int x, int y)
    {
        super(x, y);
        renderer = new ImageRenderer("images/background/background.png");
    }

}
