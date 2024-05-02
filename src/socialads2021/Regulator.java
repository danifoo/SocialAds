package socialads2021;

import java.util.ArrayList;
import java.util.List;

public class Regulator implements Observer{
	private List<String> foulTerms;
	private static Regulator instance;
	
	private Regulator() {
		foulTerms = new ArrayList<>();
		foulTerms.add("foul1");
		foulTerms.add("second foul");
		foulTerms.add("foul 3");
		foulTerms.add("the 4th foul term");
	}
	
	public static Regulator getInstance() {
		if(instance == null) {
			instance = new Regulator();
		}
		
		return instance;
	}
	
	@Override
	public boolean update(Advertisement ad) {
		for(String foulTerm: foulTerms) {
			if(ad.getText().contains(foulTerm)) {
				System.out.println("Ad title: " + ad.getTitle());
				System.out.println("Ad text: " + ad.getText());
				System.out.println("Status: The Advertisement text contains " + "\"" + foulTerm + "\". This is a foul term.");
				System.out.println("Advertisement wil not be uploaded.\n");
				return false;
			}
		}
		return true;
	}

}
