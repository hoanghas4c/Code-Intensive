import game.GameWindow;

import java.io.IOException;

public class Program
{
    public static void main(String[] args) throws IOException {
        GameWindow gameWindow = new GameWindow();
        gameWindow.mainLoop();
    }
}

