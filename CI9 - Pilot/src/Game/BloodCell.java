package Game;

import Bases.GameObject;
import Bases.ImageRenderer;

import java.util.ArrayList;

public class BloodCell extends GameObject {
    public ArrayList<BloodCell> bloodCells;

    public BloodCell(int x, int y){
        super(x, y);
        bloodCells = new ArrayList<>();
        renderer = new ImageRenderer("images/blood cells/blood-cell1.png");
    }


    public void run(){
        this.position.addUp(0, 3);
    }
}
