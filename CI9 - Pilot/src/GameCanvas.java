import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
        g.drawImage(player, 268, 600, null);
        // x = cx - w/2;
        // y = cy - h/2;
    }
}
