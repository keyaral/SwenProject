package Logic;

import java.util.ArrayList;
import java.util.HashSet;

public class MailDelivery {

    public ArrayList<Destination> nzDestinations = new ArrayList<Destination>();	
    public ArrayList<Destination> overSeasDestinations = new ArrayList<Destination>();
    
	public int totalVolume = 0;
	public int totalWeight = 0;
	public int totalitems = 0;
	
	public int tRevenue = 0;
	public int tExpediture = 0;
	
	
	
	public HashSet<Mail> mails = new HashSet<Mail>();
	
	
	

	public MailDelivery() {
		nzDestinations.add(new Destination("Wellington", true) );
		nzDestinations.add(new Destination("Auckland", true) );
		nzDestinations.add(new Destination("Dunedin", true) );
		nzDestinations.add(new Destination("Rotarua", true) );
		nzDestinations.add(new Destination("Palmerston North", true) );
		nzDestinations.add(new Destination("Christchuch", true) );
		nzDestinations.add(new Destination("Wellington", true) );
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

	 Destination origin = findOrigin(m.origin);
	 Destination dest = findDestination(m.destination);
	 // handle Delivery time
	 // handle amount of mail
	 if (dest.isDomestic()) {
		 origin.addDomesticVolume(m.volume);
		 origin.addDomesticWeightS(m.weight);
	 }
	
	 else {
		 origin.addInternationVolume(m.volume);
		 origin.addInternationWeight(m.weight);
		 
	 }
	return true;
	}
	
	private Destination findOrigin(String origin) {
		Boolean dom = false;
		for (Destination d :nzDestinations ) {
			if ( origin.equals(d.getName()) ) {
				return d;  }
		}
	if (!dom) {//TODO ERROR}	
		}
	return null;
	}
	
	private Destination findDestination(String des) {
		Boolean dom = false;
		for (Destination d :nzDestinations ) {
			if ( des.equals(d.getName()) ) {
				return d;  }
		}
	
		
			for (Destination os :overSeasDestinations ) {
				if ( des.equals(os.getName()) ) {
					return os;  }
			}
		
		Destination newOs = new Destination(des, false);	
		overSeasDestinations.add(newOs);	
			return newOs;
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
