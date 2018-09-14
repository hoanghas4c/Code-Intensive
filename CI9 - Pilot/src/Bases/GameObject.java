package bases;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class GameObject {

    public  Vector2D position;
    public  Renderer renderer;
    public boolean isActive;
    public static boolean isAlive;

    private static ArrayList<GameObject> gameObjects = new ArrayList<>();
    private static ArrayList<GameObject> newGameObjects = new ArrayList<>();


    public static void add(GameObject g ){
        newGameObjects.add(g);
    }

    public static void runAll(){
        for (GameObject go: gameObjects){
            if(go.isActive && go.isAlive){
                go.run();
            }

        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

    public static void renderAll(Graphics g){
        for (GameObject go: gameObjects){
            if(go.isActive && go.isAlive)
            {
                go.render(g);
            }
        }
    }


    public static <R extends GameObject> R recycle(int x, int y, Class<R> cls ) {
        R r = null;
        for(GameObject go: gameObjects){
            if(!go.isActive){
                if(go.getClass().equals(cls)){
                    r =  (R) go;
                }
            }
        }

        if(r == null){
            try {
                // class --> Constructer --> newInstance
                r = cls.getConstructor(int.class, int.class).newInstance(x, y);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
            GameObject.add(r);
        }
        else{
            r.isActive = true;
            r.position.x = x;
            r.position.y = y;
        }
        return r;
    }

    public GameObject(){
        this(0, 0);
    }

    public GameObject(int x, int y){
        this.position = new Vector2D(x, y);
        this.renderer = null;
        this.renderer = null;
        this.isActive = true;
        this.isAlive = true;
    }

    public BoxCollider boxCollider;

    //Generics
    public static <T extends GameObject> T checkCollision(BoxCollider boxCollider, Class<T> cls){

        T result = null;

        for (GameObject go: gameObjects){
            if(go.boxCollider != null && go.isActive){
                if(go.getClass().equals(cls)){
                    if(go.boxCollider.collideWith(boxCollider)){
                        result = (T)go;
                    }
                }
            }
        }
        return  result;
    }

    public void run(){
        if(this.boxCollider != null){
            this.boxCollider.position.x = this.position.x;
            this.boxCollider.position.y = this.position.y;
            this.boxCollider.run();
        }
    }

    public void render(Graphics g){
        if (this.renderer != null){
            this.renderer.render(g, this.position);
        }

        if(this.boxCollider != null){
            this.boxCollider.render(g);
        }
    }

    public void destroy(){
        this.isActive = false;
    }

    public void death(){
        this.isAlive = false;
    }

}
