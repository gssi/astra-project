package it.gssi.astra;


import Scheduler.SchedulerModel;

public interface IAstraSolver {
	
	
	public boolean solver(SchedulerModel root);
	
	public boolean solver();

}
