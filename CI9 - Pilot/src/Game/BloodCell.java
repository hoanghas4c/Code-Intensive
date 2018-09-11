package Game;

import Bases.Animations;
import Bases.GameObject;
import Bases.ImageRenderer;
import Bases.ImageUtil;

import java.util.ArrayList;

public class BloodCell extends GameObject {
    public ArrayList<BloodCell> bloodCells;

    public BloodCell(int x, int y){
        super(x, y);
        bloodCells = new ArrayList<>();
        renderer = new Animations(ImageUtil.load("images/blood cells/blood-cell1.png"),
                ImageUtil.load("images/blood cells/blood-cell2.png"),
                ImageUtil.load("images/blood cells/blood-cell3.png"),
                ImageUtil.load("images/blood cells/blood-cell4.png"));
    }

    private void deactivateIfNeeded() {
        if(this.position.y < 0){
            this.isActive = false;
        }
    }

    public void run(){
        this.position.addUp(3, 3);
        deactivateIfNeeded();
    }
}
