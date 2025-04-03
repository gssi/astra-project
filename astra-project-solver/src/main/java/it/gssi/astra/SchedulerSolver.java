package it.gssi.astra;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import Scheduler.ACT;
import Scheduler.SchedulerFactory;
import Scheduler.SchedulerModel;
import Scheduler.SchedulerPackage;
import Scheduler.Task;
import Scheduler.Tick;

public class SchedulerSolver {
//    private List<Task> tasks = new ArrayList<Task>();

    final static private ResourceSet resourceSet = new ResourceSetImpl();
    
    public SchedulerSolver() {
    	registerMetamodel();
    }
    
    
    /**
	 * Register EMFRESTAPIConfiguration metamodel
	 */
	private void registerMetamodel() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(SchedulerPackage.eINSTANCE.getNsURI(), SchedulerPackage.eINSTANCE);
		System.out.println("Scheduler Metamodel registered!");
	}

    public void solveScheduling(List<Task> tasks) {
        // Ordina i task per tempo di fine crescente
//        tasks.sort((t1, t2) -> t1.getActs().get(0).getEnd().getValue() - 
//        		t2.getActs().get(0).getEnd().getValue());

    	
    	// Ordinamento dei task in base al tempo di inizio crescente e priorità
    	tasks.sort(new TaskComparator());
        
//        tasks.sort(TaskComparator.(Task::getStart).thenComparing(Task::getPriority));
        

        // Lista per tenere traccia dei task già schedulati
        List<Task> scheduledTasks = new ArrayList<>();

        // Risoluzione dello scheduling con preemption
        for (Task currentTask : tasks) {
            // Verifica se il task può essere eseguito senza preemption
            boolean canExecute = true;

            for (Task scheduledTask : scheduledTasks) {
                // Verifica se c'è un'intersezione tra il tempo di inizio e il tempo di fine
                if (currentTask.getActs().get(0).getStart().getValue() < scheduledTask.getActs().get(0).getEnd().getValue() &&
                        scheduledTask.getActs().get(0).getStart().getValue() < currentTask.getActs().get(0).getEnd().getValue()) {
                    canExecute = false;
                    break;
                }
            }

            if (canExecute) {
                // Aggiungi il task alla lista dei task schedulati
                scheduledTasks.add(currentTask);
                System.out.println("Task eseguito: " + currentTask.getName());
            } else {
                // Preemption del task
                int remainingDuration = currentTask.getDuration();
                int startTime = currentTask.getActs().get(0).getStart().getValue();

                for (Task scheduledTask : scheduledTasks) {
                    // Verifica se c'è una sovrapposizione di tempo
                    if (startTime < scheduledTask.getActs().get(0).getEnd().getValue() && scheduledTask.getActs().get(0).getStart().getValue() < currentTask.getActs().get(0).getEnd().getValue()) {
                        // Calcola la durata parziale del task che viene prelazionato
                        int overlapDuration = Math.min(remainingDuration, scheduledTask.getActs().get(0).getEnd().getValue() - startTime);

                        // Stampa il task spezzato in più esecuzioni
                        System.out.println("Task prelazionato: " + currentTask.getName() +
                                " (Durata parziale: " + overlapDuration + ")");

                        remainingDuration -= overlapDuration;
                        startTime = scheduledTask.getActs().get(0).getEnd().getValue();
                    }
                }

                // Aggiungi la parte rimanente del task alla lista dei task schedulati
//                scheduledTasks.add(new Task(startTime, startTime + remainingDuration, currentTask.getPriority(), currentTask.getName()));
                scheduledTasks.add(createTask(currentTask.getName(), remainingDuration, currentTask.getPriority(), startTime, startTime));
                System.out.println("Task eseguito: " + currentTask.getName());
            }
        }
    }
    
    
    public void solveScheduling2(List<Task> tasks) {
    	
    	
    	   Collections.sort(tasks, new TaskComparator());

    	   int currentTime = 0;
           while (!tasks.isEmpty() && currentTime < 125) {
        	   System.out.println("Time = " + currentTime);
               Task selectedTask = null;
               for (Task task : tasks) {
                   if (task.getActs().get(0).getStart().getValue() <= currentTime && currentTime <= task.getActs().get(0).getEnd().getValue()) {
                       if (selectedTask == null || task.getPriority() < selectedTask.getPriority()) {
                           selectedTask = task;
                       }
                   }
               }

               if (selectedTask != null) {
                   int elapsedTime = currentTime - selectedTask.getActs().get(0).getStart().getValue();
                   int remainingTime = selectedTask.getDuration() - elapsedTime;
                   System.out.println(selectedTask.getName() + " - Elapsed: " + elapsedTime + " - Remaining: " + remainingTime);

                   if (remainingTime == 0) {
                	   System.out.println(selectedTask.getName() + " Elapsed!");
                       tasks.remove(selectedTask);
                   }

                   currentTime++;
               } else {
                   currentTime++;
               }
           }
    	   
           
    }
    
    
    
//    public static List<Task> scheduleTasks(List<Task> tasks) {
//        List<Task> scheduledTasks = new ArrayList<>();
//        PriorityQueue<Task> taskQueue = new PriorityQueue<>(Comparator.comparingInt(Task::getPriority));
//
//        int currentTime = 0;
//
//        while (!tasks.isEmpty() || !taskQueue.isEmpty()) {
//            if (!tasks.isEmpty()) {
//                // Aggiungi nuovi task alla coda in base al loro istante di inizio
//                for (Task task : tasks) {
//                    if (task.getStartTime() <= currentTime) {
//                        taskQueue.add(task);
//                    }
//                }
//                tasks.removeAll(taskQueue); // Rimuovi i task aggiunti dalla lista dei task
//            }
//
//            Task currentTask = taskQueue.poll();
//
//            if (currentTask == null) {
//                currentTime++;
//                continue;
//            }
//
//            int remainingTime = currentTask.getEndTime() - currentTime;
//
//            if (remainingTime > currentTask.getDuration()) {
//                // Il task viene prelazionato, aggiungi il tempo trascorso e riaggiungi alla coda
//                currentTask.setStartTime(currentTime);
//                currentTime += currentTask.getDuration();
//                currentTask.setEndTime(currentTime);
//                scheduledTasks.add(currentTask);
//                taskQueue.add(currentTask);
//            } else {
//                // Il task viene eseguito fino alla sua fine
//                currentTask.setStartTime(currentTime);
//                currentTime += remainingTime;
//                currentTask.setEndTime(currentTime);
//                scheduledTasks.add(currentTask);
//            }
//        }
//
//        return scheduledTasks;
//    }
    
    
    
    
    public SchedulerModel loadtModel(String modelPath) {
		URI uri = URI.createFileURI(modelPath);

		Resource resource = resourceSet.getResource(uri, true);
		return (SchedulerModel) resource.getContents().get(0);
	}
    
    
    private Task createTask(String taskName, int remainingDuration, int priority, int startTickValue, int endTickValue) {
    	Task task = SchedulerFactory.eINSTANCE.createTask();
    	task.setName(taskName);
    	task.setDuration(remainingDuration);
    	task.setPriority(priority);
    	
    	ACT act = SchedulerFactory.eINSTANCE.createACT();
    	Tick startTick = SchedulerFactory.eINSTANCE.createTick();
    	startTick.setName("startTick_"+taskName);
    	startTick.setValue(startTickValue);
    	act.setStart(startTick);
    	Tick endTick = SchedulerFactory.eINSTANCE.createTick();
    	endTick.setName("endTick_"+taskName);
    	endTick.setValue(endTickValue);
    	act.setEnd(endTick);
    	
    	task.getActs().add(act);
    	
    	return task;
    }

    //need a method to schedule tasks
    //need a method to check if a task is schedulable with preemption


    

    public static void main(String[] args) {
    	
    	
    	SchedulerSolver solver = new SchedulerSolver();
        String modelFilePath = "/Users/basciani/git/astra-project/astra-project-solver/model/SchedulerTest.xmi";
//        String modelFilePath = "astra-project-solver/model/SchedulerTest.xmi";
        File file = new File(modelFilePath);
        //check if the path exists using File class
        //if not, return an error message
        if(!file.exists()) {
        	System.out.println("File not found!");
        	return;
        }
        


        
    	SchedulerModel loadtModel = solver.loadtModel(modelFilePath);

    	EList<Task> tasks = loadtModel.getTableTask().get(0).getTasks();
    	

//    	for (Task task : tasks) {
//    		
//			System.out.println(task.getName());
//			System.out.println("##-> "+task.getActs().get(0).getStart().getValue());
//			System.out.println("##-> "+task.getActs().get(0).getEnd().getValue());
//		}
    	
        // Creazione dei Task
//        Task task1 = SchedulerFactory.eINSTANCE.createTask();
//        task1.setName("Task1");
//        task1.setDuration(16);
////        		(0, 16, 10, "Task 1", "", false, 1, 1);
//        Task task2 = new Task(0, 10, 5, "Task 2", "", false, 1, 2);
//        Task task3 = new Task(0, 12, 8, "Task 3", "", false, 1, 3);

//        // Creazione del solver dello scheduling
//        List<Task> tasks = new ArrayList<>();
//        tasks.add(task1);
//        tasks.add(task2);
//        tasks.add(task3);

        // Risoluzione dello scheduling con preemption
        solver.solveScheduling2(tasks);
    	
//    	List<Task> scheduleTasks = SchedulerSolver.scheduleTasks(tasks);
//    	
//    	for (Task task : scheduleTasks) {
//			System.out.println(task.getName());
//		}
//        
        System.out.println("Fine!");
    }
}
