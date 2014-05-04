package Logic;

import java.util.HashSet;

public class MailDelivery {

	public int totalVolume = 0;
	public int totalWeight = 0;
	public int totalitems = 0;
	
	public int tRevenue = 0;
	public int tExpediture = 0;
	
	
	
	public HashSet<Mail> mails = new HashSet<Mail>();
	
	
	

	public MailDelivery() {
		
		
		
		// TODO Auto-generated constructor stub
	}

	public boolean deliverMail(Mail m, Route r, Cost c){
		if ( r ==null || c == null ) return false;
	
		totalVolume += m.volume;
		totalWeight += m.weight;
		totalitems ++;
		
		
	double kpVcost =	m.volume *c.volume;
	double kpWcost=	m.volume *c.volume;
	double routeVcost =	m.volume *r.costVolume;
	double routeWcost = m.volume *r.costWeight;
	
	double kpCost = Math.max(kpVcost, kpWcost);
	double routeCost = Math.max(routeVcost, routeWcost);
	
	 tRevenue += kpCost;
	 tExpediture += routeCost;
	 
	 // handle Delivery time
	 // handle amount of mail

	
			return true;
	
	}
	
	public int getTotalVolume() {
		return totalVolume;
	}

	public int getTotalWeight() {
		return totalWeight;
	}

	public int getTotalitems() {
		return totalitems;
	}

	public int gettRevenue() {
		return tRevenue;
	}

	public int gettExpediture() {
		return tExpediture;
	}

	public HashSet<Mail> getMails() {
		return mails;
	}
	
	
}
