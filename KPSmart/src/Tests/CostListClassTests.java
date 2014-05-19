package Tests;

import java.util.Date;

import org.junit.Test;

import Logic.CostListClass;

public class CostListClassTests {
	
	@Test
	public void AddCostTest(){
		//Construct a Logic.Cost
		Logic.Cost cost = new Logic.Cost(1, 1.0, 2.0, "Auckland", "Wellington", 1);
		CostListClass clc = new CostListClass();
		
		assert(clc.addCost(cost));
		
	}
	
	@Test
	public void ChangeCostTest(){
		//Construct cost
		Logic.Cost cost = new Logic.Cost(1, 1.0, 2.0, "Auckland", "Wellington", 1);
		CostListClass clc = new CostListClass();
		clc.costs.put("Test", cost);
		
		assert(clc.changeCost(cost));
	}
	
	@Test
	public void DeleteCostTest(){
		//Construct cost
		Logic.Cost cost = new Logic.Cost(1, 1.0, 2.0, "Auckland", "Wellington", 1);
		CostListClass clc = new CostListClass();
		clc.costs.put("Test", cost);
		
		assert(clc.deleteCost(cost));
	}
	
	@Test
	public void FindValidCostTest(){
		//Construct cost
		Logic.Cost cost = new Logic.Cost(1, 1.0, 2.0, "Auckland", "Wellington", 1);
		CostListClass clc = new CostListClass();
		clc.costs.put(cost.origin+cost.priority+cost.destination, cost);
		
		//Construct mail
		Logic.Mail mail = new Logic.Mail(1, "Auckland", "Wellington", 1.0, 2.0, 1, new Date(2014,05,19));
		
		assert(clc.findValidCost(mail) != null);
	}
	
	@Test
	public void ContainsTest(){
		//Construct cost
		Logic.Cost cost = new Logic.Cost(1, 1.0, 2.0, "Auckland", "Wellington", 1);
		CostListClass clc = new CostListClass();
		clc.costs.put(cost.origin+cost.priority+cost.destination, cost);
		
		assert(clc.contains(cost));
	}
	
	
}
