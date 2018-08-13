import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
// Ve Game

public class GameCanvas extends JPanel {

    Image background;
    Image player;

    int x = 300 - 32;
    int y = 600;
    boolean rightPressed = false;
    boolean leftPressed = false;
    boolean upPressed = false;
    boolean downPressed = false;

    BufferedImage backBuffer;


    public GameCanvas(){
        try {
             background = ImageIO.read(new File("images/background/background.png"));
             player = ImageIO.read(new File("images/player/MB-70/player1.png"));
        } catch (IOException e) {
            System.out.println(" Damnn ");
            e.printStackTrace();
        }

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(player, x, y, null);
        // x = cx - w/2;
        // y = cy - h/2;
    }

    // Thay vì nhận phím r repaint ngta repaint liên tục
    // Dùng phương pháp gán boolen cho mỗi khi ấn phím để chạy gameLoop
    void KeyPressed(KeyEvent e){
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
    }
    void KeyReleased(KeyEvent e){

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
    }

    void run(){
        if(rightPressed){
            x += 10;
        }
        if(leftPressed){
            x -= 10;
        }
        if(upPressed){
            y -= 10;
        }
        if(downPressed){
            y += 10;
        }
    }

    // Ham ve lai
    void render(){
        this.repaint();
    }
}
