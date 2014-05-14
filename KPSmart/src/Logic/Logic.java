package Logic;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Logic {

	public final EventProcesser eventProcessor;
	

	public Logic() {
		eventProcessor = new EventProcesser(new Statistics());
		setupBaseEvents();
		
		System.out.print( " CAN HAS TEST");
		
		testMethod();
	}
	
	
	private void testMethod() {
		// TODO Auto-generated method stub
		
		eventProcessor.getStats().printAll();
		eventProcessor.getMailList().printAll();
		eventProcessor.getRoutes().printAll();
		eventProcessor.getCosts().printAll();
		
		
	}


	private void setupBaseEvents() {
		//Add Base Costs

		
		
		System.out.println("Costs start ");
		processform( new String[] {"3","1234","15","20","Wellington", "Auckland","1"} );
		processform( new String[] {"3","1235","15","20","Wellington", "Dunedin","1"} );
		processform( new String[] {"3","1236","15","20","Wellington", "Rotarua","1"} );
		processform( new String[] {"3","1237","15","20","Wellington", "Palmerston North","1"} );
		processform( new String[] {"3","1238","15","20","Wellington", "Christchuch","1"} );
		processform( new String[] {"3","1240","15","20","Wellington", "Hamilton","1"} );
		
		processform( new String[] {"3","2234","15","20","Auckland", "Wellington","1"} );
		processform( new String[] {"3","2235","15","20","Auckland", "Dunedin","1"} );
		processform( new String[] {"3","2236","15","20","Auckland", "Rotarua","1"} );
		processform( new String[] {"3","2237","15","20","Auckland", "Palmerston North","1"} );
		processform( new String[] {"3","2238","15","20","Auckland", "Christchuch","1"} );
		processform( new String[] {"3","2240","15","20","Auckland", "Hamilton","1"} );
		
		processform( new String[] {"3","3234","15","20","Dunedin", "Wellington","1"} );
		processform( new String[] {"3","3235","15","20","Dunedin", "Auckland","1"} );
		processform( new String[] {"3","3236","15","20","Dunedin", "Rotarua","1"} );
		processform( new String[] {"3","3237","15","20","Dunedin", "Palmerston North","1"} );
		processform( new String[] {"3","3238","15","20","Dunedin", "Christchuch","1"} );
		processform( new String[] {"3","3240","15","20","Dunedin", "Hamilton","1"} );
		
		
		processform( new String[] {"3","4234","15","20","Rotarua", "Wellington","1"} );
		processform( new String[] {"3","4235","15","20","Rotarua", "Auckland","1"} );
		processform( new String[] {"3","4236","15","20","Rotarua", "Dunedin","1"} );
		processform( new String[] {"3","4237","15","20","Rotarua", "Palmerston North","1"} );
		processform( new String[] {"3","4238","15","20","Rotarua", "Christchuch","1"} );
		processform( new String[] {"3","4240","15","20","Rotarua", "Hamilton","1"} );
		
	
		processform( new String[] {"3","5234","15","20","Palmerston North", "Wellington","1"} );
		processform( new String[] {"3","5235","15","20","Palmerston North", "Auckland","1"} );
		processform( new String[] {"3","5236","15","20","Palmerston North", "Rotarua","1"} );
		processform( new String[] {"3","5237","15","20","Palmerston North", "Dunedin","1"} );
		processform( new String[] {"3","5238","15","20","Palmerston North", "Christchuch","1"} );
		processform( new String[] {"3","5240","15","20","Palmerston North", "Hamilton","1"} );

		processform( new String[] {"3","6234","15","20","Christchuch", "Wellington","1"} );
		processform( new String[] {"3","6235","15","20","Christchuch", "Auckland","1"} );
		processform( new String[] {"3","6236","15","20","Christchuch", "Rotarua","1"} );
		processform( new String[] {"3","6237","15","20","Christchuch", "Dunedin","1"} );
		processform( new String[] {"3","6238","15","20","Christchuch", "Palmerston North","1"} );
		processform( new String[] {"3","6240","15","20","Christchuch", "Hamilton","1"} );
		
		
		processform( new String[] {"3","7234","15","20","Hamilton", "Wellington","1"} );
		processform( new String[] {"3","7235","15","20","Hamilton", "Auckland","1"} );
		processform( new String[] {"3","7236","15","20","Hamilton", "Rotarua","1"} );
		processform( new String[] {"3","7237","15","20","Hamilton", "Dunedin","1"} );
		processform( new String[] {"3","7238","15","20","Hamilton", "Christchuch","1"} );
		processform( new String[] {"3","7240","15","20","Hamilton", "Palmerston North","1"} );
		
	///////////////////////////////////////////////////////////////////////////////////////////////

		processform( new String[] {"3","211234","15","20","Wellington", "Auckland","2"} );
		processform( new String[] {"3","211235","15","20","Wellington", "Dunedin","2"} );
		processform( new String[] {"3","211236","15","20","Wellington", "Rotarua","2"} );
		processform( new String[] {"3","211237","15","20","Wellington", "Palmerston North","2"} );
		processform( new String[] {"3","211238","15","20","Wellington", "Christchuch","2"} );
		processform( new String[] {"3","211240","15","20","Wellington", "Hamilton","2"} );
		
		processform( new String[] {"3","212234","15","20","Auckland", "Wellington","2"} );
		processform( new String[] {"3","212235","15","20","Auckland", "Dunedin","2"} );
		processform( new String[] {"3","212236","15","20","Auckland", "Rotarua","2"} );
		processform( new String[] {"3","212237","15","20","Auckland", "Palmerston North","2"} );
		processform( new String[] {"3","212238","15","20","Auckland", "Christchuch","2"} );
		processform( new String[] {"3","212240","15","20","Auckland", "Hamilton","2"} );
		
		processform( new String[] {"3","213234","15","20","Dunedin", "Wellington","2"} );
		processform( new String[] {"3","213235","15","20","Dunedin", "Auckland","2"} );
		processform( new String[] {"3","213236","15","20","Dunedin", "Rotarua","2"} );
		processform( new String[] {"3","213237","15","20","Dunedin", "Palmerston North","2"} );
		processform( new String[] {"3","213238","15","20","Dunedin", "Christchuch","2"} );
		processform( new String[] {"3","213240","15","20","Dunedin", "Hamilton","2"} );
		
		
		processform( new String[] {"3","214234","15","20","Rotarua", "Wellington","2"} );
		processform( new String[] {"3","214235","15","20","Rotarua", "Auckland","2"} );
		processform( new String[] {"3","214236","15","20","Rotarua", "Dunedin","2"} );
		processform( new String[] {"3","214237","15","20","Rotarua", "Palmerston North","2"} );
		processform( new String[] {"3","214238","15","20","Rotarua", "Christchuch","2"} );
		processform( new String[] {"3","214240","15","20","Rotarua", "Hamilton","2"} );
		
	
		processform( new String[] {"3","215234","15","20","Palmerston North", "Wellington","2"} );
		processform( new String[] {"3","215235","15","20","Palmerston North", "Auckland","2"} );
		processform( new String[] {"3","215236","15","20","Palmerston North", "Rotarua","2"} );
		processform( new String[] {"3","215237","15","20","Palmerston North", "Dunedin","2"} );
		processform( new String[] {"3","215238","15","20","Palmerston North", "Christchuch","2"} );
		processform( new String[] {"3","215240","15","20","Palmerston North", "Hamilton","2"} );

		processform( new String[] {"3","216234","15","20","Christchuch", "Wellington","2"} );
		processform( new String[] {"3","216235","15","20","Christchuch", "Auckland","2"} );
		processform( new String[] {"3","216236","15","20","Christchuch", "Rotarua","2"} );
		processform( new String[] {"3","216237","15","20","Christchuch", "Dunedin","2"} );
		processform( new String[] {"3","216238","15","20","Christchuch", "Palmerston North","2"} );
		processform( new String[] {"3","216240","15","20","Christchuch", "Hamilton","1"} );
		
		
		processform( new String[] {"3","217234","15","20","Hamilton", "Wellington","2"} );
		processform( new String[] {"3","217235","15","20","Hamilton", "Auckland","2"} );
		processform( new String[] {"3","217236","15","20","Hamilton", "Rotarua","2"} );
		processform( new String[] {"3","217237","15","20","Hamilton", "Dunedin","2"} );
		processform( new String[] {"3","217238","15","20","Hamilton", "Christchuch","2"} );
		processform( new String[] {"3","217240","15","20","Hamilton", "Palmerston North","2"} );
		
		System.out.println("Costs done ");
		

		
		
		processform( new String[] {"0","11121","Auckland", "Wellington","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","11122","Auckland", "Dunedin","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","11123","Auckland", "Rotarua","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","11124","Auckland", "Palmerston North","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","11125","Auckland", "Rotarua","18","20","200","200","2","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","11126","Auckland", "Christchuch","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","11127","Auckland", "Hamilton","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		
		processform( new String[] {"0","21121","Wellington", "Auckland","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","21122","Wellington", "Dunedin","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","21123","Wellington", "Rotarua","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","21124","Wellington", "Palmerston North","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","21125","Wellington", "Rotarua","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","21126","Wellington", "Christchuch","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","21127","Wellington", "Hamilton","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		
		
		processform( new String[] {"0","31121","Christchuch", "Wellington","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","31122","Christchuch", "Dunedin","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","31123","Christchuch", "Rotarua","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","31124","Christchuch", "Palmerston North","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","31125","Christchuch", "Rotarua","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","31126","Christchuch", "Auckland","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","31127","Christchuch", "Hamilton","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		
		
		processform( new String[] {"0","41126","Rotarua", "Wellington","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","41127","Rotarua", "Dunedin","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","41128","Rotarua", "Auckland","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","41129","Rotarua", "Palmerston North","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","41125","Rotarua", "Rotarua","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","41124","Rotarua", "Christchuch","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","41123","Rotarua", "Hamilton","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		
		processform( new String[] {"0","51121","Palmerston North", "Wellington","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","51122","Palmerston North", "Dunedin","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","51123","Palmerston North", "Rotarua","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","51124","Palmerston North", "Auckland","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","51125","Palmerston North", "Rotarua","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","51126","Palmerston North", "Christchuch","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","51127","Palmerston North", "Hamilton","18","20","200","200","2","Tuesday", "5", "3","KpStart"} );
		
		processform( new String[] {"0","61121","Hamilton", "Wellington","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","61122","Hamilton", "Dunedin","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","61123","Hamilton", "Rotarua","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","61124","Hamilton", "Palmerston North","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","61125","Hamilton", "Rotarua","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","61126","Hamilton", "Christchuch","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","61127","Hamilton", "Auckland","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		
		processform( new String[] {"0","71121","Dunedin", "Wellington","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","71122","Dunedin", "Hamilton","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","71123","Dunedin", "Rotarua","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","71124","Dunedin", "Palmerston North","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","71125","Dunedin", "Rotarua","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","71126","Dunedin", "Christchuch","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","71127","Dunedin", "Auckland","18","20","200","200","1","Tuesday", "5", "3","KpStart"} );
		
	
		
		
		processform( new String[] {"0","11125","Auckland", "Rotarua","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","11123","Rotarua", "Auckland","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		
		processform( new String[] {"0","21123","Palmerston North", "Rotarua","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","21125","Rotarua", "Palmerston North","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
	
		
		processform( new String[] {"0","32126","Auckland", "Hamilton","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","32124","Hamilton", "Auckland","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		
		processform( new String[] {"0","42126","Palmerston North", "Hamilton","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","42124","Hamilton", "Palmerston North","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		
		
		processform( new String[] {"0","53126","Palmerston North", "Rotarua","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","53124","Rotarua", "Palmerston North","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
	
		processform( new String[] {"0","644126","Palmerston North", "Wellington","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","644124","Wellington", "Palmerston North","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );
		
		processform( new String[] {"0","754127","Christchuch", "Wellington","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","75126","Wellington", "Christchuch","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		
		processform( new String[] {"0","86127","Dunedin", "Wellington","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","86126","Wellington", "Dunedin","8","10","200","200","2","Tuesday", "5", "3","KpStart"} );	
		
		
		
		
		
		
		System.out.println("routes done ");
		

		System.out.println(	processform( new String[] {"5","115126","Rotarua", "Auckland","8","10","1", "10-17-2014"} ) );	
		System.out.println(	processform( new String[] {"5","125126","Rotarua", "Auckland","8","10","2", "10-17-2014"} ) ) ;
		
		System.out.println(	processform( new String[] {"5","215126","Auckland", "Auckland","8","10","1", "10-17-2014"} ) );	
		System.out.println(	processform( new String[] {"5","225126","Rotarua", "Rotarua","8","10","2", "10-17-2014"} ) ) ;
		
		System.out.println(	processform( new String[] {"5","315126","Dunedin", "Auckland","8","10","1", "10-17-2014"} ) );	
		System.out.println(	processform( new String[] {"5","325126","Rotarua", "Dunedin","8","10","2", "10-17-2014"} ) ) ;
		
				
		System.out.println(" THIS SHOULD WORK~~" + 	processform( new String[] {"5","415126","Wellington", "Auckland","8","10","2", "10-17-2014"} ) );	
		System.out.println(	processform( new String[] {"5","425126","Auckland", "Dunedin","8","10","2", "10-17-2014"} ) ) ;
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
	//This method will be called from the input entry forms
	public final String switchEvents(int eventType,String type){
		String returnStr="";
		 switch(eventType){
		 case 0: //For Route Add/C
			 if (type.equals("1a")) {
				 returnStr="1a";
			 }else if (type.equals("1b")){
				 returnStr= "1b";
			 }else if (type.equals("1c")){
				 returnStr= "1c";
			 }
			 break;
		 case 1: 
			 if (type.equals("2a")) {
				 returnStr= "2a";
			 }else if (type.equals("2b")){
				 returnStr= "2b";
			 }else if (type.equals("2c")){
				 returnStr= "2c";
			 }
			 break;
		 case 2: 
			 if (type.equals("3a")){
				 returnStr= "3a";
			 }
			 break;
		 }
			 return returnStr;
		 
	 }


	public String[] getDestinations() {
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
}
