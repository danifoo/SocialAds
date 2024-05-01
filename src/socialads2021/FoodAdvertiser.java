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
        System.out.println("Sign up complete as a Food Advertiser. Your unique reference number is "+ refNum);
    } 
    
    @Override
    public void display(){
        System.out.println("Food Advertiser details: " +  refNum + "\n" + name +  "\n" + telephone + "\n" + HQaddress +"\n" + sub.toString()+"\n" + VATnumber + "*******************************************");
    }
    
}
