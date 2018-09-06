package Game;

import Bases.GameObject;
import Bases.ImageRenderer;

import java.util.ArrayList;

public class BloodCell extends GameObject {
    public ArrayList<BloodCell> bloodCells;
    BloodSpawn bloodSpawn;

    public BloodCell(int x, int y){
        super(x, y);
        bloodCells = new ArrayList<>();
        imageRenderer = new ImageRenderer("images/blood cells/blood-cell1.png");
    }


    public void run(){
        this.position.addUp(0, 3);
    }
}
