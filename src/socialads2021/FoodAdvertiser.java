package socialads2021;

import java.util.Scanner;

public class FoodAdvertiser extends Advertiser{
	
    //create advertiser object 
    public FoodAdvertiser() {
        super();
    }
    
    @Override
    public void signUp(){
        
    	super.signUp();
        sector = "Food";
        System.out.println("Sign up complete as a " + sector + "Advertiser. Your unique reference number is "+ refNum);
        System.out.println("*******************************************");
    } 
    
    @Override
    public void display(){
        System.out.println("Name: " + name + "\nSector: " + sector + "\nRef number: " + refNum +  "\nTelephone: " + telephone + "\nHQaddress: " + HQaddress +"\nSubscription: " + sub.toString()+"\nVAT: " + VATnumber + "\n*******************************************");
    }
   
    
}
