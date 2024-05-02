/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialads2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author minut
 */
enum Subscription {Gold, Silver}; 
public class Advertiser implements Subject{
    protected String name; 
    protected String HQaddress; 
    protected String telephone;
    protected String sector;
    protected String VATnumber;
    protected Subscription sub;
    protected HashMap<String,Advertisement> uploadedAds;
    private List<Observer> observers;
    //private Administration admin;

    protected String refNum;

    //create advertiser object 
    public Advertiser() {
        uploadedAds = new HashMap<String,Advertisement>();
        observers = new ArrayList<>();
    }
    
    public void signUp(){
        
        // sample details from representative and store in Advertiser
        
        System.out.println("*******************************************");
        System.out.println("Input Details for a silver Advertiser ");
        System.out.println("*******************************************");
        
        // stub- get details for an Advertiser 
        
        
        //name = "Coats Ltd";
        //telephone = "07384983844";
        //sector= "Fashion";
        //HQaddress= "B42 2SU";
        //VATnumber="GB1234567";
        sub=Subscription.Silver;
        
        
        try (Scanner scanner = new Scanner(System.in)) {
        	
        	while (true) {
        		System.out.println("Enter the name of the advertiser: ");
    			name = scanner.nextLine();
    			if(!name.isBlank()) {
    				break;
    			}else {
    				System.out.println("The name filed can not be left empty.");	
    			}
        	}
        	
        	while (true) {
        		System.out.println("Enter the telephone number of the advertiser: ");
        		telephone = scanner.nextLine();
    			if(!telephone.isBlank()) {
    				break;
    			}else {
    				System.out.println("The telephone number filed can not be left empty.");	
    			}
        	}
        	
        	while (true) {
        		System.out.println("Enter the HQ address of the advertiser: ");
        		HQaddress = scanner.nextLine();
    			if(!HQaddress.isBlank()) {
    				break;
    			}else {
    				System.out.println("The HQ address filed can not be left empty.");	
    			}
        	}
        	
        	while (true) {
        		System.out.println("Enter the VAT number of the advertiser: ");
        		VATnumber = scanner.nextLine();
    			if(!VATnumber.isBlank()) {
    				break;
    			}else {
    				System.out.println("The VAT number filed can not be left empty.");	
    			}
        	}
        	
        }
        //System.out.println("Sign up complete. Your unique reference number is "+ refNum);
         
    } 
    
    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

    public String getRefNum() {
        return refNum;
    }
    
    public void changeDetails(){
        // get change details from advertiser and store
        
        //HQaddress="B40 2FG";
    	
    	sub = Subscription.Gold;
    	System.out.println("\n*******************************************");
        System.out.println("Subscription has been changed to gold");
        display();
        //System.out.println("*******************************************");
        //System.out.println("*******************************************");
        
        
    } 
    
    public void display(){
        System.out.println("Advertiser details: " +  refNum + "\n" + name +  "\n" + telephone + "\n" + HQaddress + "\n" + sector +"\n" + sub.toString()+"\n" + VATnumber + "\n*******************************************");
    }
 
    public void simulation() {
       //addAdverts
       addAdvertisement("ad 1","ad 1 text");
       addAdvertisement("ad 2","ad 2 text");
       addAdvertisement("ad 3","ad 3 text");
       addAdvertisement("ad 4","ad 4 text");
       addAdvertisement("ad 5","ad 5 text");
       addAdvertisement("ad 6","ad 6 text");
       addAdvertisement("ad 7","ad 7 text");
       addAdvertisement("ad 8","ad 8 text");
       addAdvertisement("ad 9","ad 9 text");
       
       addAdvertisement("1st ad with foul term","this is a test ad text with a foul1 term");
       
       addAdvertisement("ad 10","ad 10 text");
       addAdvertisement("ad 11","ad 11 text");
       
       //change subscription type and HQAddress
       changeDetails(); 
       
       //Attempt adding an advert after the subscription type is changed
       addAdvertisement("ad 12","ad 12 text");
       addAdvertisement("ad 13","ad 13 text");
       
       //display all uploaded advertisements
       getUploadedAds();
        
       //Edit the text of an existing advert
       editAdvertisement("ad 1","ad 1 text edited");
       
       //Delete an existing advertisement
       deleteAdvertisement("ad 2"); 
       
       //Display advertisements after update/delete
       getUploadedAds();
       
   
       //unsubscribe from Social Ads
       //unsubscribe();
   }
 
   void unsubscribe() {
	  System.out.println("Advertiser "+refNum+" removed"+"\n"+"*******************************************");
   }
   
   public void addAdvertisement (String title,String adText){
        if (sub==Subscription.Gold && uploadedAds.entrySet().size()>=20){
            System.out.println("Sorry you reached the max limit (20) of uploaded adverts this month given your Gold subscription.");
            //System.exit(1);
        }
        else if (sub==Subscription.Silver && uploadedAds.entrySet().size()>=10){
            System.out.println("Sorry you reached the max limit (10) of uploaded adverts this month given your Silver subscription.");
            //System.exit(1);
        }
        else{
            Advertisement newAd=new Advertisement(title, adText);
            if(this.notify(newAd)) {
            	uploadedAds.put(title,newAd);
            	System.out.println("New Ad title: " + newAd.getTitle());
				System.out.println("New Ad text: " + newAd.getText());
                System.out.println("Status: New advertisement titled "+title+" uploaded.\n");	
            }
        }
    }

    public void getUploadedAds() {
        Set set = uploadedAds.entrySet();
        Iterator i = set.iterator();
        System.out.println("\n*******************************************\nAll the uploaded ads of " +name+ ": ");
        while (i.hasNext())
        {
            Map.Entry me = (Map.Entry)i.next();
            uploadedAds.get(me.getKey()).display();
        }
            
        System.out.println("\n*******************************************\n");
    }
    public void editAdvertisement(String title,String newText){
        Advertisement toEdit=uploadedAds.get(title);
        toEdit.setText(newText);
        System.out.println("Advert updated as follows: ");
        uploadedAds.get(title).display();
    }
    public void deleteAdvertisement(String title){
        uploadedAds.remove(title);
        System.out.println("Advert titled "+title+" removed from database");
    }
    
    @Override
    public boolean notify(Advertisement ad) {
    	Regulator regulator =  Regulator.getInstance();
    	return regulator.update(ad);
    }    
    
}

