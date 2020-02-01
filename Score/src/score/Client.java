package score;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

class Client extends Thread {

    public synchronized void run(int n) {
        try {
            System.out.println("Client "+n+" is reading-");

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("score.txt"));

            CricketScore cs = (CricketScore) ois.readObject();

            System.out.println("Score: " + cs.getScore() + "; Wickets: " + cs.getWickets() + "; Overs: " + cs.getOvers() + "\n");

        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}
