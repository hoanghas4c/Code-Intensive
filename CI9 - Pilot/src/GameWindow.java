import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLOutput;

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
                gameCanvas.KeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gameCanvas.KeyReleased(e);
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

    long lastTimeRender = 0;
    void mainLoop(){
        while(true){
            long currentTime = System.nanoTime();
            if( currentTime - lastTimeRender >= 17_000_000){
                gameCanvas.render();
                gameCanvas.run();
                lastTimeRender = currentTime;
            }

        }
    }
}
