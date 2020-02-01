package javaapplication20;
//PRAC7
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

class MyException extends Exception
{
    MyException(String msg)
    {
        super(msg);
    }
}

 class Semcompare implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Students s1=(Students)o1;
        Students s2=(Students)o2;
        if(s1.sem==s2.sem)
        {
            if(s1.roll>s2.roll)
            {
                return 1;
            }
            else
                return -1;
        }
        else if(s1.sem>s2.sem)
        {
            return 1;
        }
        else
            return -1;
    }
}

public class Students {
    String name;
    int roll;
    int sem;
    String number;
    String city;
    
    public Students(String name,int roll,String number,int sem,String city)
             {
                this.name=name;
                this.roll=roll;
                this.sem=sem;
                this.number=number;
                this.city=city;
            }
   
    
   static void display(ArrayList a1)
    {
      Iterator itr;
      itr = a1.iterator();
        while(itr.hasNext()) {  
            Students st2=(Students)itr.next();
            System.out.println("NAME-" + st2.name+"  SEM-"+ st2.sem+ "  ROLL -  "+ st2.roll+"  NUMBER-"
            + st2.number + "  CITY- " +st2.city);
                }  
    }
                 

    
    public static void main(String[] args) throws MyException {
        Scanner sc= new Scanner(System.in);
        ArrayList a1;
        a1 = new ArrayList();
        Iterator itr;
        int n = 0,i,flag=0;
        String c;
        a1.add(new Students("Raghav",19,"7972305810",4,"Nagpur"));
        a1.add(new Students("Virat",18,"8007447195",8,"Delhi"));
        do
        {
            try
                 {
        System.out.println("Enter your choice 1.PRINT RECORDS 2.SORT 3.CITYWISE PRINT"
                + " 4.ADD RECORDS 5.REMOVE WITH INDEX 6.REMOVE WITH NAME 7.EXIT ");
        n=sc.nextInt();
        switch(n)
        {
         case 1:
                display(a1);
         break;
         case 2:
               System.out.println("After sorting");
               Collections.sort(a1,new Semcompare());
               display(a1);
         break;
         case 3:
               System.out.println("Enter the city");
               c=sc.next();
               itr=a1.iterator();
               while(itr.hasNext())
               {
                   Students st2=(Students)itr.next();
               if(st2.city.contains(c)==true)
               {  
                System.out.println("NAME-" + st2.name+"  SEM-"+ st2.sem+ "  ROLL -  "+ st2.roll+"  NUMBER-"
               + st2.number + "  CITY- " +st2.city);
               }
               }
         break;
         case 4: 
                 int sem,roll;
                 String name,number,city;
                 System.out.println("Enter values in sequence of name,roll,number,sem,city");
                 name=sc.next();
                 roll=sc.nextInt();
                 number=sc.next();
                 sem=sc.nextInt();
                 city=sc.next();            
                 if(name.equals("null") || roll==0 || sem==0 || number.equals("null") || city.equals("null"))
                 {
                     ///////System.out.println("!@#$%^&*(");
                    throw new MyException("MISSING FIELD");
                 }
                 else
                     a1.add(new Students(name,roll,number,sem,city));               
         break;
         case 5:System.out.println("Enter the record number"); 
                i= sc.nextInt();
                a1.remove(i);
         break;
         case 6: System.out.println("Enter student name");
                 c=sc.next();
                 itr=a1.iterator();
               while(itr.hasNext())
               {
                   Students st3=(Students)itr.next();
               if(st3.name.contains(c)==true)
               {
                 flag=1;
                 a1.remove(st3);
                 break;
               }
               }
               if(flag==0)
               {
                       System.out.println("No such record found");
                
               }
         break;
        }
                 }
            catch(Exception e)
                {
                    System.out.println("*****MISSING FIELD*****" + e);
                }
}while(n!=7);
    }
}