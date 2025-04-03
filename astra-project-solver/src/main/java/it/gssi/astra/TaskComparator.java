package it.gssi.astra;

import java.util.Comparator;

import Scheduler.Task;

class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2) {
        // Confronto basato sul tempo di inizio e sulla priorità

        if (task1.getActs().get(0).getStart().getValue() == task2.getActs().get(0).getStart().getValue()) {
            if (task1.getDuration() == task2.getDuration()) {
                return task2.getPriority() - task1.getPriority();
            } else {
                return task1.getDuration() - task2.getDuration();
            }
        } else {
            return task1.getActs().get(0).getStart().getValue() - task2.getActs().get(0).getStart().getValue();
        }
    }
}
