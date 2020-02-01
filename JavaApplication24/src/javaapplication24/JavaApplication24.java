//JAVA TUTORIAL 4
package javaapplication24;

import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

 class Student  implements Serializable
 {
     int roll;
     String name,prog,branch;
     
     Student(int roll,String name,String prog,String branch)
     {
         this.roll=roll;
         this.branch=branch;
         this.name=name;
         this.prog=prog;
     }
 }


public class JavaApplication24 {
    JFrame f;
    JTable t;
    
    public JavaApplication24(String head[],String data[][])
    {
        
        f=new JFrame("STUDENT INFORMATION");
        //f.setLayout(null);
        Font x = new Font("Italics",Font.ITALIC,15);
        f.setSize(300,300);
          t=new JTable(data,head);
          t.setBounds(50,50,100,200);
          t.setBackground(Color.BLUE);
          t.setFont(x);
          t.setForeground(Color.WHITE);
          JScrollPane sp=new JScrollPane(t);
          //f.add(t.getTableHeader());
          f.add(sp); 
          //f.add(t);
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          f.setVisible(true);
        }
    
    
    public static void main(String[] args) {
        int j=0,k;
        String head[]={"ROLL NO","NAME","PROGRAM","BRANCH"};
        String data[][] = new String[2][4];
        Scanner sc=new Scanner(System.in);
        int i,roll;
        String name,prog,branch;
        try
      {
          FileOutputStream fout=new FileOutputStream("f1.txt");  
          ObjectOutputStream out=new ObjectOutputStream(fout); 
          for(i=0;i<2;i++)
          {
          System.out.println("Enter details ROLL NAME PROGRAM BRANCH");
          roll=sc.nextInt();
          name=sc.next();
          prog=sc.next();
          branch=sc.next();
          Student s=new Student(roll,name,prog,branch);
          out.writeObject(s);
          }
          out.close();
          ObjectInputStream in=new ObjectInputStream(new FileInputStream("f1.txt"));
          for(k=0;k<2;k++)
          { 
            Student  s=(Student)in.readObject();
            data[j][0]=Integer.toString(s.roll);
            data[j][1]=s.name;
            data[j][2]=s.prog;
            data[j][3]=s.branch;
            j++;
          }
          in.close();
          JavaApplication24 java=new JavaApplication24(head,data);
      }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
