package players;

import bases.Animations;
import bases.ImageUtil;
import bases.Renderer;
import bases.Vector2D;

import java.awt.*;

public class PlayerAnimator extends Renderer {
    private Animations currentAnimation;
    private Animations leftAnimation;
    private Animations straightAnimation;
    private Animations rightAnimation;

    public PlayerAnimator(){
        leftAnimation = new Animations(
          10,
          false,
                ImageUtil.load("images/player/MB-69/player_left1.png"),
                ImageUtil.load("images/player/MB-69/player_left2.png"),
                ImageUtil.load("images/player/MB-69/player_left3.png"),
                ImageUtil.load("images/player/MB-69/player_left4.png")
                );

        rightAnimation = new Animations(
                10,
                false,
                ImageUtil.load("images/player/MB-69/player_right1.png"),
                ImageUtil.load("images/player/MB-69/player_right2.png"),
                ImageUtil.load("images/player/MB-69/player_right3.png"),
                ImageUtil.load("images/player/MB-69/player_right4.png")
                );

        straightAnimation = new Animations(
                10,
                false,
                ImageUtil.load("images/player/MB-69/player1.png"),
                ImageUtil.load("images/player/MB-69/player2.png"),
                ImageUtil.load("images/player/MB-69/player3.png"),
                ImageUtil.load("images/player/MB-69/player4.png")
                );
        this.currentAnimation = straightAnimation;
    }

    @Override
    public void render(Graphics g, Vector2D position) {
        this.currentAnimation.render(g, position);
    }

    void selectAnimation(Vector2D playerVelocity){
        if(playerVelocity.x < 0){
            this.currentAnimation = this.leftAnimation;
        }
        else if(playerVelocity.x > 0){
            this.currentAnimation = this.rightAnimation;
        }
        else{
            this.currentAnimation = this.straightAnimation;
        }
    }
}
