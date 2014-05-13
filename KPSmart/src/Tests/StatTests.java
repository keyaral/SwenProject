package Tests;

import org.junit.Test;
import java.util.*;
import Logic.*;
import Log.event.*;

public class StatTests {
	
	@Test
	public void testGetAmountOFMail1() {
		Statistics stat = new Statistics();
		stat.mails.add(new Mail(1,"dest1","org1",10,10,3,new Date()));
		stat.mails.add(new Mail(2,"dest1","org1",10,10,3,new Date()));
		List<String[]> result = stat.getMailAmounts();
		assert(result.size() == 1);
		assert(result.get(0)[2].equals("20"));
	}
	
}
