package javaapplication30;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

class Score implements Serializable
{
    int run,wicket,score;
        int over;
        int balls;

       Score(int balls,int run,int score,int wicket,int over)
       {
           this.balls=balls;
           this.run=run;
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
      Random rand = new Random();
      FileOutputStream fout=new FileOutputStream("f1.txt");
      ObjectOutputStream out=new ObjectOutputStream(fout);
      int run,wicket=0,score=0;
      int over=0;
      int balls=0;
      int frun=0;
      for(int i=0;i<30;i++)
      {
      run=rand.nextInt(8);
      balls++;
      if(run==7)
      {
          wicket=wicket+1;
          score=score;
          frun=0;
      }
      else
      {
          wicket=wicket;
          score=score +run;
          frun=run;
      }
      if(balls==6)
      {
          over=over+1;
      }
      else
      {
          over=over;
      }
      Score s=new Score(balls,frun,score,wicket,over);
      out.writeObject(s);
      if(balls==6)
      {
         balls=0;
      }
      }
      System.out.println("*****successfully updated*****");
      out.close();
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
    synchronized public void read( )
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter till what over");
            int over=sc.nextInt();
            //int wick=sc.nextInt();
            //int wickets;
            int cover;
       ObjectInputStream in=new ObjectInputStream(new FileInputStream("f1.txt"));
       do
       {
       Score s=(Score)in.readObject();
       System.out.println("In " +s.balls + "ball  made "+ s.run +" runs "
       +"final score is "+ s.score+" - "+s.wicket+ " in "+s.over+ " overs "  );
       cover=s.over;
       //wickets=s.wicket;
       }while(cover!=over /*|| wickets!=wick*/);
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


public class Cricket {

    public static void main(String[] args) {
        
        try
        {
        thread1 t1=new thread1();
        thread2 t2=new thread2();
        thread2 t8=new thread2();
        thread2 t10=new thread2();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t8.start();
        t8.join();
        t10.start();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }

}
