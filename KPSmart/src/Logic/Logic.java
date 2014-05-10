package Logic;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Logic {

	public static final Statistics stats = new Statistics();
	public final EventProcesser eventProcessor;

	public Logic() {
		eventProcessor = new EventProcesser();
		setupBaseEvents();
		
		
	}
	
	


	private void setupBaseEvents() {
		//Add Base Costs
		
		System.out.println("Costs start ");
		processform( new String[] {"3","122","15","20","Rotarua", "Auckland","2"} );
		
		processform( new String[] {"3","123","15","20","Wellington", "Auckland","1"} );
		processform( new String[] {"3","124","15","20","Auckland", "Wellington","1"} );
		
		processform( new String[] {"3","125","15","20","Rotarua", "Auckland","1"} );	
		processform( new String[] {"3","126","15","20","Wellington", "Rotarua","1"} );	
		processform( new String[] {"3","127","15","20","Auckland", "Rotarua","1"} );
		processform( new String[] {"3","128","15","20","Rotarua", "Wellington","1"} );
		
		System.out.println("Costs done ");
		
		processform( new String[] {"0","4126","Auckland", "Wellington","8","10","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","4125","Auckland", "Wellington","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		
		
		processform( new String[] {"0","4127","Rotarua", "Wellington","8","10","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","4128","Wellington", "Rotarua","8","10","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","4129","Auckland", "Rotarua","8","10","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","4120","Rotarua", "Auckland","8","10","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","4125","Wellington", "Auckland","8","10","200","200","1","Tuesday", "5", "3","KpStart"} );	
		System.out.println("routes done ");
		
		
		processform( new String[] {"5","5126","Rotarua", "Auckland","8","10","1", "10-17-2014"} );	
		processform( new String[] {"5","5126","Rotarua", "Auckland","8","10","2", "10-17-2014"} );
	System.out.println("mail done ");

//		
		
		
		}
		
		
		
		
		
	


	public String processform(String[] details) {
		System.out.println("call evnent");
				try {
					return eventProcessor.proccess(details);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
	}
	public String getdetails(){

		return " DONT RETURN THIS ANYMORE calll process form";
	}

	// TODO Marian >> The text returned will be splited by a single space; that is " "
	public String getStatistics(){
		return " Modify this method, or use a different one";
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
	  	// TODO Load File for previous Events.



	  //	l.processform("1a	4	Auckland	Wellington	10	15	200	200	1	Thursday	2	3	TylerCorp");
	//  	System.out.println(l.eventProcessor.events.size());
	}

}
