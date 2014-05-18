package Log.writer;

import Log.*;
import Log.Log.*;
import Logic.KPEvent;



public interface IXmlWriter {
	
	Log WriteLog(Log log);
	Log UpdateCost(Cost cost);
	Log UpdatePrice(Price price);
	Log UpdateMail(Mail mail);
	Log UpdateTimeLimit(Timelimit timeLimit);
	Log UpdateDiscontinue(Discontinue discontinue);
	Log InsertCost(Cost cost);
	Log InsertPrice(Price price);
	Log InsertMail(Mail mail);
	Log InsertTimeLimit(Timelimit timeLimit);
	Log InsertDiscontinue(Discontinue discontinue);
	Log InsertRoute(Route route);
	Log InsertKPEvent(KPEvent event);
	

}
