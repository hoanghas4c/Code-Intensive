package players;

import bases.Vector2D;
import game.Settings;
import inputs.InputManager;


public class PlayerMove {

    public Vector2D velocity;

    public PlayerMove(){
        velocity = new Vector2D();
    }

    void run( Vector2D position){
        this.velocity.x = 0;
        this.velocity.y = 0;
        if(InputManager.instance.rightPressed){
            velocity.x += 5;
        }
        if(InputManager.instance.leftPressed){
            velocity.x -= 5;
        }
        if(InputManager.instance.upPressed){
            velocity.y -= 5;
        }
        if(InputManager.instance.downPressed){
            velocity.y += 5;
        }
        position.addUp(velocity);

        if(position.x < 0)  position.x = 0;
        if(position.x > Settings.SCREEN_WIDTH ) position.x = Settings.SCREEN_WIDTH;


        if(position.y < 0)  position.y = 0;
        if(position.y > Settings.SCREEN_HEIGHT ) position.x = Settings.SCREEN_HEIGHT;

    }
}

