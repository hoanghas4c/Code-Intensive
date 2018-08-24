import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;


// Ve Game

public class GameCanvas extends JPanel {


    Image background;
    Vector2D vector2D;


    Player player;
    ArrayList<PlayerBullet> bullets; // null
    ArrayList<Enemy> enemies; // null


    InputManager inputManager;

    int enemySpawnCount = 0;


    BufferedImage backBuffer;
    Graphics backBufferGraphics;
    Random random;

    public GameCanvas(){

        random = new Random();

        inputManager = new InputManager();

        bullets = new ArrayList<>();
        enemies = new ArrayList<>();

        player = new Player(268, 600);
        player.bullets = this.bullets;
        player.inputManager = inputManager;// reference point to

        background = ImageUtil.load("images/background/background.png");

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
       g.drawImage(backBuffer, 0 , 0 , null);
    }

    // Thay vì nhận phím r repaint ngta repaint liên tục
    // Dùng phương pháp gán boolen cho mỗi khi ấn phím để chạy gameLoop


    void run() {
        player.run();
        player.shoot();

        for(Enemy e : enemies){
            e.run();
        }

        enemySpawnCount++;
        if(enemySpawnCount > 60){
            enemySpawnCount = 0;
            int posX = random.nextInt(600);
            Enemy enemy = new Enemy(posX, 0);
            enemies.add(enemy);
        }
    }

    // Ham ve lai
    // k xu li logic
    void render(){
        backBufferGraphics.drawImage(background, 0, 0, null);
        player.render(backBufferGraphics);

        for(PlayerBullet b: bullets){
            b.render(backBufferGraphics);
        }
        for(Enemy e: enemies){
            e.render(backBufferGraphics);
        }
        this.repaint();
    }
}
