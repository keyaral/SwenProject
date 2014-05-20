package Tests;

import org.junit.Test;

import Logic.*;

public class KPEventTests {
	
	@Test
	public void KPEventConstructorTest(){
		
		KPEvent e = new KPEvent(null, null, null, null);
		
		assert(e.object==null&&e.success==null&&e.statistics==null&&e.type==null);
	}
	
	
}
