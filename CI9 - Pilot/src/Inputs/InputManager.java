package inputs;

import java.awt.event.KeyEvent;

public class InputManager {
    public boolean rightPressed = false;
    public boolean leftPressed = false;
    public boolean upPressed = false;
    public boolean downPressed = false;
    public boolean xPressed = false;

    public static InputManager instance = new InputManager();

    public void KeyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_X){
            xPressed = true;
        }
    }
    public void KeyReleased(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP){
            upPressed = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_X)
        {
            xPressed = false;
        }
    }
}
