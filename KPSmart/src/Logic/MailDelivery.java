package Logic;

import java.util.HashSet;

public class MailDelivery {

	public int tVolume = 0;
	public int tWeight = 0;
	public int total = 0;
	
	public int tRevenue = 0;
	public int tExpediture = 0;
	
	
	
	public HashSet<Mail> mails = new HashSet<Mail>();
	
	
	public MailDelivery() {
		
		
		
		// TODO Auto-generated constructor stub
	}

	public boolean deliverMail(Mail m, Route r, Cost c){
		if ( r ==null || c == null ) return false;
	
		else
			// update mailbad figures
			return true;
	
	}
	
}
