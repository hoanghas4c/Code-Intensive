package Bases;

import java.awt.*;
import java.util.ArrayList;

public class Animations extends Renderer{
    ArrayList<Image> images;
    int imageIndex;
    FrameCounter frameCounter;

    public Animations(ArrayList<Image> images){
        this(images, 20);
    }


    //load anh
    public Animations(ArrayList<Image> images, int frameDelay){
        this.images = images;
        this.imageIndex = 0;
        this.frameCounter = new FrameCounter(frameDelay);
    }

    // ve anh

    public void render(Graphics g, Vector2D position){
        renderCurrentImage(g, position);
        changeCurrentImage();
    }

    private void changeCurrentImage() {
        frameCounter.run();
        if(frameCounter.expired){
            frameCounter.reset();
            if(imageIndex < this.images.size() - 1){
                this.imageIndex += 1;
            }
            else{
                this.imageIndex = 0;
            }
        }
    }

    private void renderCurrentImage(Graphics g, Vector2D position){
        Image currentImage = images.get(imageIndex);
        int width = currentImage.getWidth(null);
        int height = currentImage.getHeight(null);
        g.drawImage(currentImage,
                (int)(position.x - width/2),
                (int)(position.y - height/2), null);
    }
}
