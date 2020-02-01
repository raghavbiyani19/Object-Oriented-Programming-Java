package score;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
class Server extends Thread {

    public synchronized void run(CricketScore cs) {
        try {
            System.out.println("Server is writing. \n");

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("score.txt"));

            oos.writeObject(cs);


        } catch (Exception e) {
            System.err.println(e);
        }
    }
}