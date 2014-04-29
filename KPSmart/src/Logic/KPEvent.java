package Logic;

public class KPEvent {

	public String type;
	public Boolean success;
	public String Statistics;
	public Object object;
	
	public KPEvent(String t, Object o, Boolean d){
	this.type = t;
	this.object = o; 
	this.success = d;
	}
}
