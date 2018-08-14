public class Random {
    public static void main(String[] args) {
        int rand = rand(0, 600);
    }

    public static int rand(int min, int max){
        try{
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
