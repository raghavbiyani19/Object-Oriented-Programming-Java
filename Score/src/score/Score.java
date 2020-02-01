package score;
import java.util.Scanner;
class Score {
    public static void main(String[] args) {
        int c = 5;
        Scanner sc = new Scanner(System.in);
        CricketScore cs = new CricketScore(0, 0, 0);

        for (int i = 0; i < 5; i++) {

            cs.score += 5;
            cs.wickets+=1;
            cs.overs+=0.2;

            Server ser=new Server();
            ser.run(cs);

            Client cl1=new Client();
            Client cl2=new Client();
            cl1.run(1);
            cl2.run(2);
        }
    }
}