import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
// Ve Game

public class GameCanvas extends JPanel {
    Image background;
    Image player;

    public GameCanvas(){
        try {
             background = ImageIO.read(new File("images/background/background.png"));
             player = ImageIO.read(new File("images/player/MB-70/player1.png"));
        } catch (IOException e) {
            System.out.println(" Damnn ");
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(player, x, y, null);
        // x = cx - w/2;
        // y = cy - h/2;
    }

    int x = 300 - 32;
    int y = 600;

    // Thay vì nhận phím r repaint ngta repaint liên tục
    void KeyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x += 10;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x -= 10;
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP){
            y -= 10;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            y += 10;
        }
    }
    void KeyReleased(KeyEvent e){
        System.out.println("Canvas handling key released");
    }

    // Ham ve lai
    void render(){
        this.repaint();
    }
}
