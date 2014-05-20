package Tests;

import org.junit.Test;

public class CostTests {
	
	@Test
	public void ConstructorTest(){
		Logic.Cost cost = new Logic.Cost(1, 2.0, 3.0, "Auckland", "Wellington", 1);
		
		assert(cost.ID==1&&cost.weight==2.0&&cost.volume==3.0&&cost.destination.equals("Auckland")
				&&cost.origin.equals("wellington")&&cost.priority==1);
	}
	
	
}
