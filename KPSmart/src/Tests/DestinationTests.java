package Tests;

import org.junit.Test;

public class DestinationTests {
	
	private Logic.Destination des = new Logic.Destination("TestDestination", 1, 1, 1, 1);
	
	@Test
	public void AddDomesticVolumeTest(){
		des.addDomesticVolume(1);
		assert(des.getDomesticVolume()==2);
	}
	
	@Test
	public void AddInternationVolumeTest(){
		des.addInternationVolume(1);
		assert(des.getInternationVolume()==2);
	}
	
	@Test
	public void AddDomesticWeightTest(){
		des.addDomesticWeightS(1);
		assert(des.getDomesticWeightS()==2);
	}
	
	@Test
	public void AddInternationWeightTest(){
		des.addInternationWeight(1);
		assert(des.getInternationWeight()==2);
	}
	
	@Test
	public void AddRouteTest(){
		Logic.Route r = new Logic.Route(1, "Auckland", "Wellington", 1.0, 1.0, 1.0, 1.0, 1, "2014-05-20", 1.0, 1.0, "Test");
		des.addRoute(r);
		assert(des.routes.size()==1);
	}
	
}
