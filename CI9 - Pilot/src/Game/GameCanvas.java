package Game;

import Bases.ImageUtil;
import Bases.GameObject;
import Enemies.Enemy;
import Enemies.EnemySpawn;
import Players.Player;
import Players.PlayerBullet;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {


    Image background;
    GameObject gameObject;

    EnemySpawn enemySpawn;
    Enemy enemy;
    Player player;
    ArrayList<PlayerBullet> bullets; // null
    ArrayList<Enemy> enemies; // null


    BufferedImage backBuffer;
    Graphics backBufferGraphics;
    Random random;

    public GameCanvas(){

        enemySpawn = new EnemySpawn();
        random = new Random();
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        enemySpawn.enemies = enemies;

        player = new Player(300, 700);

        GameObject.add(player);
        GameObject.add(enemy);

        background = ImageUtil.load("images/background/background.png");

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
       g.drawImage(backBuffer, 0 , 0 , null);
    }

    void run() {
        GameObject.runAll();

        for(Enemy e : enemies){
            e.run();
        }

        enemySpawn.run();
    }

    void render(){
        backBufferGraphics.drawImage(background, 0, 0, null);

        gameObject.renderAll(backBufferGraphics);
        this.repaint();
    }
}
