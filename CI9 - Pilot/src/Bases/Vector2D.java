package Bases;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(){
        this(0, 0);
    }
    void  print(){
        System.out.println(this.x + " , " + this.y);
    }

    void addUp(float x, float y)
    {
        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D other)
    {
        this.addUp(other.x, other.y);
    }



    Vector2D add(float x, float y){
        return new Vector2D(this.x + x, this.y +y);
    }

    Vector2D add(Vector2D other){
        return this.add(other.x, other.y);
    }



    void subtractBy(float x, float y){
        this.x -= x;
        this.y -= y;
    }

    Vector2D subtract(Vector2D other){
       return new Vector2D(other.x  , other.y );
    }


    void scaleBy(float m){
        this.x *= m;
        this.y *= m;
    }

    Vector2D scale(float m){
        return  new Vector2D( this.x *m, this.y *m);
    }

    float length(){
        return (float)Math.sqrt(this.x*this.x + this.y*this.y );
    }

    Vector2D normalize()
    {
        float length = this.length();
        return new Vector2D(this.x/length, this.y/length);
    }

}
