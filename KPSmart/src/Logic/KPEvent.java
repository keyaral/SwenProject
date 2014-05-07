package Logic;

public class KPEvent {

	public String type;
	public Boolean success;
	public Statistics statistics;
	public Object object;

	public KPEvent(String t, Object o, Boolean d, Statistics s){
	this.type = t;
	this.object = o;
	this.success = d;
	this.statistics = s;
	}
}
