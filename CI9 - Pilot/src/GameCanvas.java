import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


// Ve Game

public class GameCanvas extends JPanel {


    Image background;
    Image player;
    ArrayList<PlayerBullet> bullets; // null
    ArrayList<Enemy> enemies; // null



    int x = 300 - 32;
    int y = 600;
    int count;
    int enemySpawnCount = 0;
    boolean rightPressed = false;
    boolean leftPressed = false;
    boolean upPressed = false;
    boolean downPressed = false;
    boolean xPressed = false;
    boolean shootLock = false;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;
    Random random;

    public GameCanvas(){

        Random random = new Random();

        bullets = new ArrayList<>();
        enemies = new ArrayList<>();

        Enemy e1 = new Enemy();
        e1.x = 320;
        e1.y = 0;

        Enemy e2 = new Enemy();
        e2.x = 200;
        e2.y = 0;

        background = ImageUtil.load("images/background/background.png");
        player = ImageUtil.load("images/player/MB-70/player1.png");
        e1.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
        e2.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");


        enemies.add(e1);
        enemies.add(e2);

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
       g.drawImage(backBuffer, 0 , 0 , null);
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
        if(e.getKeyCode() == KeyEvent.VK_X){
            xPressed = true;
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
        if(e.getKeyCode() == KeyEvent.VK_X)
        {
            xPressed = false;
        }
    }

    void run() {
        if(rightPressed){
            x += 5;
        }
        if(leftPressed){
            x -= 5;
        }
        if(upPressed){
            y -= 5;
        }
        if(downPressed){
            y += 5;
        }
        if(xPressed && !shootLock){
            PlayerBullet newB = new PlayerBullet();
            newB.x = x;
            newB.y = y;

            try {
                newB.image = ImageIO.read(new File("images/bullet/player/mb69bullet1.png"));
            } catch (IOException e) {
                System.out.println(" Damnn ");
                e.printStackTrace();
            }

            bullets.add(newB);
            shootLock = true;
        }

        for(PlayerBullet b: bullets)
        {
            b.y -= 10;
        }

        for(Enemy e : enemies){
            e.y += 3;
        }

        enemySpawnCount++;
        if(enemySpawnCount > 60){
            enemySpawnCount = 0;
            Enemy enemy = new Enemy();
            Random random = new Random();
            enemy.x = random.nextInt(600);
            enemy.y = 0;
            try {
                enemy.image = ImageIO.read(new File("images/enemy/bacteria/bacteria1.png"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            enemies.add(enemy);
        }

        if(shootLock){
            count++;
            if(count > 20)
            {
                shootLock = false;
                count = 0;
            }
        }

    }

    // Ham ve lai
    // k xu li logic
    void render(){
        backBufferGraphics.drawImage(background, 0, 0, null);
        backBufferGraphics.drawImage(player, x, y, null);

        for(PlayerBullet b: bullets){
            backBufferGraphics.drawImage(b.image, b.x , b.y , null);
        }
        for(Enemy e: enemies){
            backBufferGraphics.drawImage(e.image, e.x, e.y, null);
        }
        this.repaint();
    }
}
