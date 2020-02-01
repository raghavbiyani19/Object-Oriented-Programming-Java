package javaapplication23;
//OOP-8
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;


class Score implements Serializable
{
    int run,wicket,score;
        String player;
        double over;
        
       Score(String player,int run,int score,int wicket,double over)
       {
           this.run=run;
           this.player=player;
           this.over=over;
           this.wicket=wicket;
           this.score=score;
       }
}

class thread1 extends Thread
{
 synchronized public void update()
  {
      Scanner sc=new Scanner(System.in);
      try
      {
      int run,wicket,score;
      String player;
      double over;
      System.out.println("ENTER details of player name run score wicket over ");
      player=sc.next();
      run=sc.nextInt();
      score=sc.nextInt();
      wicket=sc.nextInt();
      over=sc.nextDouble();
      Score s=new Score(player,run,score,wicket,over);
      FileOutputStream fout=new FileOutputStream("f1.txt");  
      ObjectOutputStream out=new ObjectOutputStream(fout);   
      out.writeObject(s);  
      out.flush();  
      System.out.println("*****successfully updated*****"); 
  }
      catch (Exception e)
      {
          System.out.println(e);
      }
}
  @Override
  public void run()
  {
      update();
  }
}

class thread2 extends Thread
{
    synchronized public void read()
    {
        try
        {
       ObjectInputStream in=new ObjectInputStream(new FileInputStream("f1.txt"));  
       Score s=(Score)in.readObject();  
       System.out.println(s.player + " made "+ s.run +" runs " 
       +"in last ball final score is "+ s.score+" - "+s.wicket+ " in "+s.over+ " overs "  );  
       in.close();
    }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    @Override
    public void run()
    {
     read();
    }
}


public class JavaApplication23 {
    public static void main(String[] args) {
        try
        {
        thread1 t1=new thread1();  
        thread1 t3=new thread1();
        thread1 t5=new thread1();
        thread2 t2=new thread2(); 
        thread2 t4=new thread2(); 
        thread2 t6=new thread2();
        thread2 t8=new thread2();
        thread2 t10=new thread2();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();
        t6.start();
        t6.join();
        t8.start();
        t8.join();
        t5.start();
        t5.join();
        t10.start();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        
    }
    
}
