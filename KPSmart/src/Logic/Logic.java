package Logic;

public class Logic {
	
	final EventProcesser eventProcessor;

	public Logic() {
		eventProcessor = new EventProcesser();
	}
	
	
	public String processform(String details){
		System.out.println("call evnent");			
		return eventProcessor.proccess(details);
	}
	public String getdetails(){
		
		return " Candy";
	}
	
	// TODO Marian >> The text returned will be splited by a single space; that is " "
	public String getStatistics(){
		return "math1 math2 math3 math4 math5 math6";
	}
	/**
	 *  
	 * @param mailId - Each entry for mail should have a unique ID
	 * @param routeNo - Route Number
	 * @param originatingPort - Originating Port
	 * @param destinationPort - Destination Port
	 *	@param cost - Price for that particular route
	 * @return
	 */
	public String getDetailsFromMailDeliver(long mailId,String routeNo,String originatingPort,String destinationPort,Double cost){
		String values= "\nMail ID: " + mailId +"\n"+"Route No: " + routeNo+"\n"+ "Originating Port: " +originatingPort+"\nDestination: "+destinationPort+"\nRoute Cost: " + cost;
		return values;
	}
	public String getTransporCostDetails(int transportCostId,String companyName,String to,String from, 
			String priorityType,Double weightCost,Double volumeCost,Double maxWeight,Double maxVolume,int duration,int frequency,String date){
		String values="\nTransport Cost ID: " + transportCostId +"\nCompany :" + companyName +
				"\nTo :" + to +"\nFrom: " +from +"\nPriority :" + priorityType + "\nWeight Cost: "+ weightCost +
				"\nVolume Cost : " + "\nMax Weight :" + maxWeight + "\nMax Volume :" + maxVolume +
				"\n Duration : " + duration + "\nFrequency : " + frequency + "\nDate: " + date;
		return values;	
	}
	public static void main(String[] args){
	  	Logic l = new Logic();
	  	l.processform("1a	4	Auckland	Wellington	10	15	200	200	1	Thursday	2	3	TylerCorp");
	  	System.out.println(l.eventProcessor.events.size());
	}

}
