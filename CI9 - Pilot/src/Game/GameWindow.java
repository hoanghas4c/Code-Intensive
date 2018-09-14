package game;

import inputs.InputManager;

import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JFrame
{
    GameCanvas gameCanvas;

    public GameWindow()
    {
        // Set up window
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Nhận phím ấn vào
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                InputManager.instance.KeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                InputManager.instance.KeyReleased(e);
            }
        });


        this.setSize(600, 800);// Vẽ khung hình
        this.setResizable(false);// Khóa phóng to thu nhỏ
        this.setTitle("Micro - War"); // Hiện tên ở window

        // Set up canvas
        gameCanvas = new GameCanvas();
        this.setContentPane(gameCanvas);


        this.setVisible(true);
    }

    public void mainLoop(){
        long lastTimeRender = 0;
        long currentTime = 0;
        while(true){
            currentTime = System.nanoTime();
            if( currentTime - lastTimeRender >= 17_000_000){
                gameCanvas.render();
                gameCanvas.run();
                lastTimeRender = currentTime;
            }
        }
    }
}
