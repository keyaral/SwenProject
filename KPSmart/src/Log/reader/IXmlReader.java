package Log.reader;

import java.util.ArrayList;

import Log.*;
import Log.Log.*;

public interface IXmlReader {
	
	ArrayList<Cost> FindCost();
	ArrayList<Price> FindPrice();
	ArrayList<Timelimit> FindTimelimit();
	ArrayList<Discontinue> FindDiscontinue();
	ArrayList<Mail> FindMail();
	Log FindAll();

}
