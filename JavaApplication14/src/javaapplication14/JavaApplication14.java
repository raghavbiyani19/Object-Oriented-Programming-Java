package javaapplication14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MyException extends Exception
{
    MyException(String msg)
    {
        super(msg);
    }
}

public class JavaApplication14 {
    
    private static final Pattern pswrd_regex = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,})");
    private static final Pattern email_regex = Pattern.compile("[a-z]+[a-z|\\d|_|.]*[@]{1}[a-z]{1,}[.][a-z]{2,5}");
    private static final Pattern mobile_regex = Pattern.compile("[\\d]{10}");
    
    boolean checkPassword(String password) throws MyException
    {
        Matcher mtch1 = pswrd_regex.matcher(password);
        if(mtch1.matches()){
            return true;
        }
        return false;     
    }
    
    boolean checkEmail(String email) throws MyException
    {
        Matcher mtch2 = email_regex.matcher(email);
        if(mtch2.matches()){
            return true;
        }
        return false;    
    }
    
    boolean checkMobileNumber(String mobile_no) throws MyException
    {
        Matcher mtch3 = mobile_regex.matcher(mobile_no);
        if(mtch3.matches()){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        String email,password,user_name;
        String mobile_no;
        Scanner sc = new Scanner(System.in);
        JavaApplication14 obj = new JavaApplication14();
         boolean ansPassword=true;
         boolean ansEmail=true;
         boolean ansMobileNumber=true;
            System.out.println("Enter Username");
            user_name = sc.next();
         do{
         try{
            System.out.println("Enter Password");
            password = sc.next();
            ansPassword = obj.checkPassword(password);
            if(ansPassword == false)
            {
                throw new MyException("Incorrect password.");
            }
            }
         catch(Exception e1)
        {
            System.out.println(e1);
        }
          }while(ansPassword==false);
         do{
         try{
            System.out.println("Enter Email");
            email = sc.next();
            ansEmail=obj.checkEmail(email);
            if(ansEmail==false)
            {
                throw new MyException("Incorrect email id.");
            }
            }
         catch(Exception e1)
        {
            System.out.println(e1);
        }
          }while(ansEmail==false);
         do{
         try{
            System.out.println("Enter Mobile number");
            mobile_no = sc.next();
            ansMobileNumber =obj.checkMobileNumber(mobile_no);
            if(ansMobileNumber==false)
            {
                throw new MyException("Incorrect mobile number.");
            }
            }
         catch(Exception e1)
        {
            System.out.println(e1);
        }
         }while(ansMobileNumber==false);
            
        if((ansPassword==true) && (ansEmail==true) && (ansMobileNumber==true))
            System.out.println("Succesfully logged in.");    
    }   
}