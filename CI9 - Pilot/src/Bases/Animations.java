package bases;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Animations extends Renderer{
    public boolean finished;
    private boolean oneTime;

    ArrayList<Image> images;
    int imageIndex;
    FrameCounter frameCounter;

    public Animations(Image...imgs){
        this(10, false, imgs);
    }

    //load anh
    public Animations(int frameDelay, boolean oneTime, Image ... imgs ){
        this.images = new ArrayList<>();
        this.images.addAll(Arrays.asList(imgs));
        this.oneTime = oneTime;

        this.imageIndex = 0;
        this.frameCounter = new FrameCounter(frameDelay);
        this.finished = false;
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
                if(oneTime){
                    this.finished = true;
                }
                else{
                    this.imageIndex = 0;
                }
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
