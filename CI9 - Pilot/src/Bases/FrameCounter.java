package Bases;

public class FrameCounter {
    int count ;
    int limit;
    boolean expired;

    FrameCounter(int limit){
        this.limit = limit;
        this.count = 0;
        this.expired = false;
    }

    void run(){
        count++;
        if(count >= limit){
            expired = true;
        }
        else{
            count++;
        }
    }

    void reset(){
        count = 0;
        expired = false;
    }
}
