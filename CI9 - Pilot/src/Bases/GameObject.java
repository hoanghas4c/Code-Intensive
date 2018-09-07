package Bases;

import Enemies.Enemy;

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

    public static Enemy checkCollision(BoxCollider boxCollider){

        Enemy result = null;

        for (GameObject go: gameObjects){
            if(go.boxCollider != null){
                if(go instanceof Enemy){
                    if(go.boxCollider.collideWith(boxCollider)){
                        result = (Enemy)go;
                    }
                }
            }
        }
        return  result;
    }

    public void render(Graphics g){
        if (this.imageRenderer != null){
            this.imageRenderer.render(g, this.position);
        }
    }

}
