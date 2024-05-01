package socialads2021;

public class AttractionAdvertiser extends Advertiser{
    //create advertiser object 
    public AttractionAdvertiser() {
        super();
    }
    
    @Override
    public void signUp(){
        
    	super.signUp();
        sector = "Attraction";
        System.out.println("Sign up complete as an Attraction Advertiser. Your unique reference number is "+ refNum);
    } 
    
    @Override
    public void display(){
        System.out.println("Attraction Advertiser details: " +  refNum + "\n" + name +  "\n" + telephone + "\n" + HQaddress +"\n" + sub.toString()+"\n" + VATnumber + "*******************************************");
    }
    
}
