package Logic;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Logic {

	public final EventProcesser eventProcessor;
	

	public Logic() {
		eventProcessor = new EventProcesser(new Statistics());
		
		
	//setupBaseEvents();
	
		
		
		processform( new String[] {"3","1234","0.3","0.5","Wellington", "Rotorua","2"} );
	processform( new String[] {"0","21125","Wellington", "Rotorua","0.2","0.5","200","200","2","Tuesday", "1", "2","KpStart"} );
		
	setupDestinationXY(eventProcessor.mailList.allDestinations);
		
	//	testMethod();
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


	private void testMethod() {
		
		
		
	}


	private void setupBaseEvents() {
		//Add Base Costs

	//	Route routeTest1 = new Route(1,"Auckland","Wellington",10,15,200,200,1,"Thursday",2,3,"TylerCorp");
	//	Route routeTest2 = new Route(2,"Christchurch","Wellington",10,15,200,200,2,"Thursday",2,3,"TylerCorp");
	//	Route routeTest3 = new Route(3,"Auckland","Wellington",10,15,200,200,1,"Thursday",2,3,"TylerCorp");
		
	//	eventProcessor.addRoute(routeTest1)
		
		
		
		processform( new String[] {"3","1234","0.3","0.5","Wellington", "Auckland","1"} );
		processform( new String[] {"3","1235","0.3","0.5","Wellington", "Dunedin","1"} );
		processform( new String[] {"3","1236","0.3","0.5","Wellington", "Rotorua","1"} );
		processform( new String[] {"3","1237","0.3","0.5","Wellington", "Palmerston North","1"} );
		processform( new String[] {"3","1238","0.3","0.5","Wellington", "Christchurch","1"} );
		processform( new String[] {"3","1240","0.3","0.5","Wellington", "Hamilton","1"} );
		
		processform( new String[] {"3","2234","0.3","0.5","Auckland", "Wellington","1"} );
		processform( new String[] {"3","2235","0.3","0.5","Auckland", "Dunedin","1"} );
		processform( new String[] {"3","2236","0.3","0.5","Auckland", "Rotorua","1"} );
		processform( new String[] {"3","2237","0.3","0.5","Auckland", "Palmerston North","1"} );
		processform( new String[] {"3","2238","0.3","0.5","Auckland", "Christchurch","1"} );
		processform( new String[] {"3","2240","0.3","0.5","Auckland", "Hamilton","1"} );
		
		processform( new String[] {"3","3234","0.3","0.5","Dunedin", "Wellington","1"} );
		processform( new String[] {"3","3235","0.3","0.5","Dunedin", "Auckland","1"} );
		processform( new String[] {"3","3236","0.3","0.5","Dunedin", "Rotorua","1"} );
		processform( new String[] {"3","3237","0.3","0.5","Dunedin", "Palmerston North","1"} );
		processform( new String[] {"3","3238","0.3","0.5","Dunedin", "Christchurch","1"} );
		processform( new String[] {"3","3240","0.3","0.5","Dunedin", "Hamilton","1"} );
		
		
		processform( new String[] {"3","4234","0.3","0.5","Rotorua", "Wellington","1"} );
		processform( new String[] {"3","4235","0.3","0.5","Rotorua", "Auckland","1"} );
		processform( new String[] {"3","4236","0.3","0.5","Rotorua", "Dunedin","1"} );
		processform( new String[] {"3","4237","0.3","0.5","Rotorua", "Palmerston North","1"} );
		processform( new String[] {"3","4238","0.3","0.5","Rotorua", "Christchurch","1"} );
		processform( new String[] {"3","4240","0.3","0.5","Rotorua", "Hamilton","1"} );
		
	
		processform( new String[] {"3","5234","0.3","0.5","Palmerston North", "Wellington","1"} );
		processform( new String[] {"3","5235","0.3","0.5","Palmerston North", "Auckland","1"} );
		processform( new String[] {"3","5236","0.3","0.5","Palmerston North", "Rotorua","1"} );
		processform( new String[] {"3","5237","0.3","0.5","Palmerston North", "Dunedin","1"} );
		processform( new String[] {"3","5238","0.3","0.5","Palmerston North", "Christchurch","1"} );
		processform( new String[] {"3","5240","0.3","0.5","Palmerston North", "Hamilton","1"} );

		processform( new String[] {"3","6234","0.3","0.5","Christchurch", "Wellington","1"} );
		processform( new String[] {"3","6235","0.3","0.5","Christchurch", "Auckland","1"} );
		processform( new String[] {"3","6236","0.3","0.5","Christchurch", "Rotorua","1"} );
		processform( new String[] {"3","6237","0.3","0.5","Christchurch", "Dunedin","1"} );
		processform( new String[] {"3","6238","0.3","0.5","Christchurch", "Palmerston North","1"} );
		processform( new String[] {"3","6240","0.3","0.5","Christchurch", "Hamilton","1"} );
		
		
		processform( new String[] {"3","7234","0.3","0.5","Hamilton", "Wellington","1"} );
		processform( new String[] {"3","7235","0.3","0.5","Hamilton", "Auckland","1"} );
		processform( new String[] {"3","7236","0.3","0.5","Hamilton", "Rotorua","1"} );
		processform( new String[] {"3","7237","0.3","0.5","Hamilton", "Dunedin","1"} );
		processform( new String[] {"3","7238","0.3","0.5","Hamilton", "Christchurch","1"} );
		processform( new String[] {"3","7240","0.3","0.5","Hamilton", "Palmerston North","1"} );
		
	///////////////////////////////////////////////////////////////////////////////////////////////

		processform( new String[] {"3","211234","0.3","0.5","Wellington", "Auckland","2"} );
		processform( new String[] {"3","211235","0.3","0.5","Wellington", "Dunedin","2"} );
		processform( new String[] {"3","211236","0.3","0.5","Wellington", "Rotorua","2"} );
		processform( new String[] {"3","211237","0.3","0.5","Wellington", "Palmerston North","2"} );
		processform( new String[] {"3","211238","0.3","0.5","Wellington", "Christchurch","2"} );
		processform( new String[] {"3","211240","0.3","0.5","Wellington", "Hamilton","2"} );
		
		processform( new String[] {"3","212234","0.3","0.5","Auckland", "Wellington","2"} );
		processform( new String[] {"3","212235","0.3","0.5","Auckland", "Dunedin","2"} );
		processform( new String[] {"3","212236","0.3","0.5","Auckland", "Rotorua","2"} );
		processform( new String[] {"3","212237","0.3","0.5","Auckland", "Palmerston North","2"} );
		processform( new String[] {"3","212238","0.3","0.5","Auckland", "Christchurch","2"} );
		processform( new String[] {"3","212240","0.3","0.5","Auckland", "Hamilton","2"} );
		
		processform( new String[] {"3","213234","0.3","0.5","Dunedin", "Wellington","2"} );
		processform( new String[] {"3","213235","0.3","0.5","Dunedin", "Auckland","2"} );
		processform( new String[] {"3","213236","0.3","0.5","Dunedin", "Rotorua","2"} );
		processform( new String[] {"3","213237","0.3","0.5","Dunedin", "Palmerston North","2"} );
		processform( new String[] {"3","213238","0.3","0.5","Dunedin", "Christchurch","2"} );
		processform( new String[] {"3","213240","0.3","0.5","Dunedin", "Hamilton","2"} );
		
		
		processform( new String[] {"3","214234","0.3","0.5","Rotorua", "Wellington","2"} );
		processform( new String[] {"3","214235","0.3","0.5","Rotorua", "Auckland","2"} );
		processform( new String[] {"3","214236","0.3","0.5","Rotorua", "Dunedin","2"} );
		processform( new String[] {"3","214237","0.3","0.5","Rotorua", "Palmerston North","2"} );
		processform( new String[] {"3","214238","0.3","0.5","Rotorua", "Christchurch","2"} );
		processform( new String[] {"3","214240","0.3","0.5","Rotorua", "Hamilton","2"} );
		
	
		processform( new String[] {"3","215234","0.3","0.5","Palmerston North", "Wellington","2"} );
		processform( new String[] {"3","215235","0.3","0.5","Palmerston North", "Auckland","2"} );
		processform( new String[] {"3","215236","0.3","0.5","Palmerston North", "Rotorua","2"} );
		processform( new String[] {"3","215237","0.3","0.5","Palmerston North", "Dunedin","2"} );
		processform( new String[] {"3","215238","0.3","0.5","Palmerston North", "Christchurch","2"} );
		processform( new String[] {"3","215240","0.3","0.5","Palmerston North", "Hamilton","2"} );

		processform( new String[] {"3","216234","0.3","0.5","Christchurch", "Wellington","2"} );
		processform( new String[] {"3","216235","0.3","0.5","Christchurch", "Auckland","2"} );
		processform( new String[] {"3","216236","0.3","0.5","Christchurch", "Rotorua","2"} );
		processform( new String[] {"3","216237","0.3","0.5","Christchurch", "Dunedin","2"} );
		processform( new String[] {"3","216238","0.3","0.5","Christchurch", "Palmerston North","2"} );
		processform( new String[] {"3","216240","0.3","0.5","Christchurch", "Hamilton","2"} );
		
		
		processform( new String[] {"3","217234","0.3","0.5","Hamilton", "Wellington","2"} );
		processform( new String[] {"3","217235","0.3","0.5","Hamilton", "Auckland","2"} );
		processform( new String[] {"3","217236","0.3","0.5","Hamilton", "Rotorua","2"} );
		processform( new String[] {"3","217237","0.3","0.5","Hamilton", "Dunedin","2"} );
		processform( new String[] {"3","217238","0.3","0.5","Hamilton", "Christchurch","2"} );
		processform( new String[] {"3","217240","0.3","0.5","Hamilton", "Palmerston North","2"} );
		
		

		
		
		processform( new String[] {"0","11121","Auckland", "Wellington","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","11122","Auckland", "Dunedin","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","11123","Auckland", "Rotorua","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","11124","Auckland", "Palmerston North","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","11125","Auckland", "Rotorua","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","11126","Auckland", "Christchurch","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","11127","Auckland", "Hamilton","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		
		processform( new String[] {"0","21121","Wellington", "Auckland","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","21122","Wellington", "Dunedin","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","21123","Wellington", "Rotorua","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","21124","Wellington", "Palmerston North","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","21125","Wellington", "Rotorua","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","21126","Wellington", "Christchurch","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","21127","Wellington", "Hamilton","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		
		
		processform( new String[] {"0","31121","Christchurch", "Wellington","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","31122","Christchurch", "Dunedin","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","31123","Christchurch", "Rotorua","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","31124","Christchurch", "Palmerston North","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","31125","Christchurch", "Rotorua","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","31126","Christchurch", "Auckland","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","31127","Christchurch", "Hamilton","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		
		
		processform( new String[] {"0","41126","Rotorua", "Wellington","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","41127","Rotorua", "Dunedin","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","41128","Rotorua", "Auckland","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","41129","Rotorua", "Palmerston North","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","41125","Rotorua", "Rotorua","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","41124","Rotorua", "Christchurch","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","41123","Rotorua", "Hamilton","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		
		processform( new String[] {"0","51121","Palmerston North", "Wellington","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","51122","Palmerston North", "Dunedin","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","51123","Palmerston North", "Rotorua","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","51124","Palmerston North", "Auckland","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","51125","Palmerston North", "Rotorua","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","51126","Palmerston North", "Christchurch","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","51127","Palmerston North", "Hamilton","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );
		
		processform( new String[] {"0","61121","Hamilton", "Wellington","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","61122","Hamilton", "Dunedin","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","61123","Hamilton", "Rotorua","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","61124","Hamilton", "Palmerston North","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","61125","Hamilton", "Rotorua","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","61126","Hamilton", "Christchurch","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","61127","Hamilton", "Auckland","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		
		processform( new String[] {"0","71121","Dunedin", "Wellington","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","71122","Dunedin", "Hamilton","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","71123","Dunedin", "Rotorua","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","71124","Dunedin", "Palmerston North","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","71125","Dunedin", "Rotorua","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","71126","Dunedin", "Christchurch","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		processform( new String[] {"0","71127","Dunedin", "Auckland","0.2","0.4","200","200","1","Tuesday", "5", "3","KpStart"} );
		
	
		
		
		processform( new String[] {"0","11325","Auckland", "Rotorua","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","11323","Rotorua", "Auckland","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
		
		processform( new String[] {"0","21223","Palmerston North", "Rotorua","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","21225","Rotorua", "Palmerston North","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
	
		
		processform( new String[] {"0","32126","Auckland", "Hamilton","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","32124","Hamilton", "Auckland","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
		
		processform( new String[] {"0","42126","Palmerston North", "Hamilton","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","42124","Hamilton", "Palmerston North","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
		
		
		processform( new String[] {"0","53126","Palmerston North", "Rotorua","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","53124","Rotorua", "Palmerston North","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
	
		processform( new String[] {"0","644126","Palmerston North", "Wellington","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","644124","Wellington", "Palmerston North","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );
		
		processform( new String[] {"0","754127","Christchurch", "Wellington","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","75126","Wellington", "Christchurch","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
		
		processform( new String[] {"0","86127","Dunedin", "Wellington","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
		processform( new String[] {"0","86126","Wellington", "Dunedin","0.2","0.4","200","200","2","Tuesday", "5", "3","KpStart"} );	
		
		
		
		
		
		
		
		
//
//		System.out.println(	processform( new String[] {"5","115126","Rotarua", "Auckland","8","10","1", "10-17-2014"} ) );	
//		System.out.println(	processform( new String[] {"5","125126","Rotarua", "Auckland","8","10","2", "10-17-2014"} ) ) ;
//		
//		System.out.println(	processform( new String[] {"5","215126","Auckland", "Auckland","8","10","1", "10-17-2014"} ) );	
//		System.out.println(	processform( new String[] {"5","225126","Rotarua", "Rotarua","8","10","2", "10-17-2014"} ) ) ;
//		
//		System.out.println(	processform( new String[] {"5","315126","Dunedin", "Auckland","8","10","1", "10-17-2014"} ) );	
//		System.out.println(	processform( new String[] {"5","325126","Rotarua", "Dunedin","8","10","2", "10-17-2014"} ) ) ;
//		
//				
//		System.out.println(" THIS SHOULD WORK~~" + 	processform( new String[] {"5","415126","Wellington", "Auckland","8","10","2", "10-17-2014"} ) );	
//		System.out.println(	processform( new String[] {"5","425126","Auckland", "Dunedin","8","10","2", "10-17-2014"} ) ) ;
//	System.out.println("mail done ");

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
}
