package it.gssi.astra;
import Scheduler.ACT;
import Scheduler.SchedulerModel;
import Scheduler.TableTask;
import Scheduler.Task;
import Scheduler.Tick;

public class AstraSolver implements IAstraSolver {


	private int numeroTick = 32;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean solver(SchedulerModel root) {

		System.out.println("Sono qui!");

		//In questa applicazione se almeno un task non è schedulabile ritorna false
		for(TableTask tableTask : root.getTableTask()) {
			
			

			int tickAllTask = 0; 
			
			
			for(Task newTask : tableTask.getTasks()) {
				
				Tick tickIniziale = null;
				Tick tickFinale = null;
				
				int calcoloFinaleStart = 0;
				int calcoloFinaleEnd = 0;

					for (ACT act : newTask.getActs()) {
						
						tickIniziale = act.getStart(); // è il Tick 0 o 1 del BTS che trovo in tickfinale!
						calcoloFinaleStart = tickIniziale.getValue()*2;
						if(tickIniziale.getName().contains("0")) {
							calcoloFinaleStart += 0;
						}else {
							calcoloFinaleStart += 1;
						}
						
						
						System.out.println(calcoloFinaleStart);
						tickFinale = act.getEnd();
						calcoloFinaleEnd = tickFinale.getValue()*2;
						if(tickIniziale.getName().contains("0")) {
							calcoloFinaleEnd += 0;
						}else {
							calcoloFinaleEnd += 1;
						}
						
						
						System.out.println(calcoloFinaleEnd);
					}

				tickAllTask += (calcoloFinaleEnd-calcoloFinaleStart);
			}

			
			if(numeroTick < tickAllTask) {
				return false;
			}
		}

		return true;
		// Richiamato dall'editor 
	}


	public boolean solver() {
		return false;
		// richiamato esternamente

	}

}
