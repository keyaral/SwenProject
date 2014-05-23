package Logic;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  @author BusyBees
 *
 *The logic class is the gateway for GUI commands. 
 *
 *Logic creates an Event processor for creating all the objects and calls commands on it 
 *as per the user requests.
 *
 *The process form method handles User rquests and returns a string for the gui to display.
 *
 */
public class Logic {

	public final EventProcesser eventProcessor;
	
/**
 * Constructor creates the EventProcessor, it also sues setupDestinationXY to make sure
 * all destination have valid co-ordinates.
 */
	public Logic() {
		eventProcessor = new EventProcesser(new Statistics());
		setupDestinationXY(eventProcessor.mailList.allDestinations);

	}
	
	
	private void setupDestinationXY(ArrayList<Destination> allDestinations) {
		for(Destination d: allDestinations){
			if(d.getName().equals("Auckland")){d.GeographicalX = 200; d.GeographicalY = 100;}
			if(d.getName().equals("Wellington")){d.GeographicalX = 160; d.GeographicalY = 200;}
			if(d.getName().equals("Dunedin")){d.GeographicalX = 230; d.GeographicalY = 400;}
			if(d.getName().equals("Rotorua")){d.GeographicalX = 180; d.GeographicalY = 150;}
			if(d.getName().equals("Palmerston North")){d.GeographicalX = 190; d.GeographicalY = 180;}
			if(d.getName().equals("Christchurch")){d.GeographicalX = 240; d.GeographicalY = 350;}		//TODO fix spelling of CCH and RotoRua
			if(d.getName().equals("Hamilton")){d.GeographicalX = 190; d.GeographicalY = 120;}
				//TODOD figure out international destinations
		}
		
	}



	/**
	 *
	 * Takes a string array from the user and calls a event to occur. 
	 * Will return a string to inform the user what the result was.
	 */
	public String processform(String[] details) {
		
				try {
					return eventProcessor.proccess(details);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
	}
	
	/**
	 *
	 * @param mailId - Each entry for mail should have a unique ID
	 * @param routeNo - Route Number
	 * @param originatingPort - Originating Port
	 * @param destinationPort - Destination Port
	 *	@param cost - Price for that particular route
	 * @return
	 * 
	 * 
	 * These two methods return string arrays to represent mail or route objects.
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
	

/**
 * Methods for getting the list of destination for the gui to display.
 * 
 * @return
 */
	public String[] getNZDestinations() {
		// TODO Auto-generated method stub
		ArrayList<Destination> des_list = eventProcessor.mailList.nzDestinations;
		String[] desArr = new String[des_list.size()];
		int i = 0;
		for(Destination d : des_list) {
			desArr[i] =d.getName();
					i++;
		}
		return desArr;
	}
	public String[] getDestinations() {
		// TODO Auto-generated method stub
		ArrayList<Destination> des_list = eventProcessor.mailList.allDestinations;
		String[] desArr = new String[des_list.size()];
		int i = 0;
		for(Destination d : des_list) {
			desArr[i] =d.getName();
					i++;
		}
		return desArr;
	}
	
	// Main method for testin logic
	public static void main(String[] args){
	  	Logic l = new Logic();

	}
	
}
