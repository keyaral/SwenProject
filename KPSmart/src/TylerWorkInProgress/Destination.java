package TylerWorkInProgress;
import java.util.ArrayList;



public class Destination {

private String name;	
	
	


private boolean domestic; 

private double domesticVolume = 0.0;
private double internationVolume = 0.0;
private double domesticWeightS = 0.0;
private double internationWeight = 0.0;




public ArrayList<Route> routes = new ArrayList<Route>();

public Destination(String name, double domesticVolume,
		double internationVolume, double domesticWeightS,
		double internationWeight) {
	super();
	this.name = name;
	this.domesticVolume = domesticVolume;
	this.internationVolume = internationVolume;
	this.domesticWeightS = domesticWeightS;
	this.internationWeight = internationWeight;
} 
	
public Destination(String name, Boolean dom) {
	this.name= name;
	this.domestic = dom;
}



public  void addDomesticVolume(double dv) {
	 domesticVolume += dv;
}

public  void addInternationVolume(double iv) {
	 internationVolume += iv;
}

public  void addDomesticWeightS( double dw ) {
	 domesticWeightS += dw;
}

public void addInternationWeight(double iw) {
	 internationWeight += iw;
}


public  String getName() {
	return name;
}

public  double getDomesticVolume() {
	return domesticVolume;
}

public  double getInternationVolume() {
	return internationVolume;
}

public  double getDomesticWeightS() {
	return domesticWeightS;
}

public  double getInternationWeight() {
	return internationWeight;
}

public  boolean isDomestic() {
	return domestic;
}

public void addRoute(Route r){
	this.routes.add(r);
}
}

