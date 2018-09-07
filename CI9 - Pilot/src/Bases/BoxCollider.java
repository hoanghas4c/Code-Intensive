package Bases;

public class BoxCollider extends GameObject{
    private int width;
    private int height;


    public BoxCollider(int x, int y, int width, int height){
        super(x, y);
        this.width = width;
        this.height = height;
    }

    private float top(){
        return this.position.y - this.height / 2;
    }


    private float bot(){
        return  this.position.y - this.height / 2;
    }

    private float left(){
        return this.position.x - this.width / 2;
    }

    private  float right(){
        return this.position.x + this.width / 2;
    }

    public boolean collideWith(BoxCollider boxCollider){
        //this vs other
        boolean xOverlap = this.left() <= other.right() &&
                other.left <= this.right();
        boolean yOverlap = this.bot() >= other.top &&
                other.bot >= this.top();

        return xOverlap && yOverlap;
    }
}
