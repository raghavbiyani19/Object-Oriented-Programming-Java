package javaapplication22;
//OOP-9
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class MyFrame extends JFrame implements ActionListener{ 
 
    Container c;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1;
    JButton b1;
    Random rand;
    
    int chance = 2;
    int score = 0;
    MyFrame()
    {   
        
        c = this.getContentPane();
        c.setLayout(null);
        rand = new Random(); 
        
        this.setBounds(25,25,400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Math Game");
        Font font = new Font("Arial",Font.BOLD,25);
        
        l1 = new JLabel("MATH GAME");
        l1.setBounds(160,10,170,100);
        l1.setFont(font);
        this.add(l1);
        
        int num1 = rand.nextInt(100);
        int num2 = rand.nextInt(100);
        String number1 = Integer.toString(num1);
        String number2 = Integer.toString(num2);
        l2 = new JLabel();
        l3 = new JLabel("+");
        l4 = new JLabel();
        l2.setText(number1);
        l4.setText(number2);
        l2.setBounds(20,120,30,30);
        l3.setBounds(55,130,10,10);
        l4.setBounds(90,110,50,50);
        
        t1 = new JTextField();
        t1.setBounds(120,120,50,30);
        
        b1 = new JButton("NEXT");
        b1.setBounds(200,120,80,30);
        b1.addActionListener(this);
        
        l5 = new JLabel("Score =");
        l5.setBounds(140,160,80,30);
        
        l6 = new JLabel();
        l6.setBounds(200,160,80,30);
        
        Font font2 = new Font("Arial",Font.BOLD,18);
        l7 = new JLabel();
        l7.setBounds(130,250,200,30);
        l7.setFont(font2);
        
        this.add(l7);
        this.add(l6);
        this.add(l5);
        this.add(b1);
        this.add(t1);
        this.add(l2); 
        this.add(l3);
        this.add(l4);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int int1 = Integer.parseInt(l2.getText());
        int int2 = Integer.parseInt(l4.getText());
        int ansint = int1 + int2;
        String ans = Integer.toString(ansint);
        
        
        if(e.getSource()==b1 && chance!=0)
        {
            int num1 = rand.nextInt(100);
            int num2 = rand.nextInt(100);
        if(ans.equals(t1.getText()))
        {
           
            chance = 2;
            score+=10;
            System.out.println(score);
            l6.setText(Integer.toString(score));
            t1.setText("");
        }
       else
       {
           chance--;
           t1.setText("");
       }
        String number1 = Integer.toString(num1);
        String number2 = Integer.toString(num2);
        l2.setText(number1);
        l4.setText(number2);
        }
        if(chance==0)
        {
           l7.setText("Game Over!!");
        }
    }
}

public class JavaApplication22 {
    public static void main(String[] args) {
      MyFrame f = new MyFrame();
    }
}
