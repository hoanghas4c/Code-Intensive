package Bases;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {

    public  Vector2D position;
    public  ImageRenderer imageRenderer;

    private static ArrayList<GameObject> gameObjects = new ArrayList<>();
    private static ArrayList<GameObject> newGameObjects = new ArrayList<>();


    public static void add(GameObject g ){
        newGameObjects.add(g);
    }

    public static void runAll(){
        for (GameObject go: gameObjects){
            go.run();
        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAll(Graphics g){
        for (GameObject go: gameObjects){
            go.render(g);
        }
    }

    public GameObject(int x, int y){
        this.position = new Vector2D(x, y);
        this.imageRenderer = null;
    }

    public void run(){

    }

    public void render(Graphics g){
        if (this.imageRenderer != null){
            this.imageRenderer.render(g, this.position);
        }
    }

}
