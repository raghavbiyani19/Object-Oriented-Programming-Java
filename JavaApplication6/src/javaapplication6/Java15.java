/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.io.*;
import java.math.*;
import java.util.Scanner;


 class Point
{
  public double x,y;
  public Point()
  {
  x=0;
  y=0;
  }
  public Point(double p,double q)
  {
    x=p;
    y=q;
  }
  public void display(Point c2)
  {
   System.out.println("the values of the points are"+x +","+y);   
   System.out.println("the values of the points are"+c2.x +","+c2.y);
  }
  public double Getlen(Point c2)
  {
   double len;
   len=Math.sqrt(Math.pow(x-c2.x,2)+Math.pow(y-c2.y,2));
   return len;
  }
}
class Shape{
    public String name;
    public int vert;
    
    public double peri;
    
   public void calci(Point p[]){
    int i=0;
    double l=0;
    for(i=0;i<vert-1;i++)
    {
        l=l+p[i].Getlen(p[i+1]);
    }
    l=l+p[0].Getlen(p[(this.vert)-1]);
    System.out.println("perimetter is"+l);
   }
}
public class Java15 {

    
    public static void main(String[] args) {
        int i;
    Point p1,p2;
    Point p[];
    Shape s;
    s=new Shape ();
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the vertex");
    s.vert=sc.nextInt();
    p=new Point[s.vert];
    for(i=0;i<s.vert;i++)
    {
      System.out.println("enter the point");  
      p[i]=new Point(sc.nextDouble(),sc.nextDouble());
    }
    s.calci(p);
    p1=new Point(sc.nextDouble(),sc.nextDouble());
    p2=new Point(sc.nextDouble(),sc.nextDouble());
    p1.display(p2);
    p1.Getlen(p2);
    }
    
}
