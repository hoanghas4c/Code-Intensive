package Game;

import Bases.ImageUtil;
import Bases.GameObject;
import Enemies.Enemy;
import Enemies.EnemyBullet;
import Enemies.EnemySpawn;
import Players.Player;
import Players.PlayerBullet;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    GameObject gameObject;

    EnemySpawn enemySpawn;
    EnemyBullet enemyBullet;

    Player player;
    BloodSpawn bloodSpawn;

    BackGround backGround;
    BufferedImage backBuffer;
    Graphics backBufferGraphics;


    public GameCanvas(){

        enemySpawn = new EnemySpawn();
        bloodSpawn = new BloodSpawn();

        backGround = new BackGround(300, 400);
        GameObject.add(backGround);

        player = new Player(300, 700);
        GameObject.add(player);

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
       g.drawImage(backBuffer, 0 , 0 , null);
    }

    void run() {
        GameObject.runAll();
        enemySpawn.run();
        bloodSpawn.run();

    }
    
    void render(){
        gameObject.renderAll(backBufferGraphics);
        this.repaint();
    }
}
