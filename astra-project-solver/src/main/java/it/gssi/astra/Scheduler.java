package it.gssi.astra;

//tasks.add(new TaskBean("PUSL", 0, 13, 14, 135));
//tasks.add(new TaskBean("SATCM", 0, 15, 16, 136));
//tasks.add(new TaskBean("CMG", 2, 3, 1, 133));
import java.util.*;

public class Scheduler {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("PUSL", 14, 135, Arrays.asList(new ACT("ACT1", 0, 13))));
        tasks.add(new Task("SATCM", 16, 136, Arrays.asList(new ACT("ACT1", 0, 15))));
        tasks.add(new Task("CMG", 1, 133, Arrays.asList(new ACT("ACT1", 2, 3))));

        scheduleTasks(tasks);
    }

    public static void scheduleTasks(List<Task> tasks) {
        List<Task> scheduledTasks = new ArrayList<>();
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(new TaskComparator());
        taskQueue.addAll(tasks);

        int currentTime = 0;
        while (!taskQueue.isEmpty()) {
            Task currentTask = taskQueue.poll();
            ACT currentACT = currentTask.getCurrentACT();
            if (currentACT.getStart() > currentTime) {
                currentTime = currentACT.getStart();
            }

            int elapsedTime = currentTime - currentACT.getStart();
            int remainingTime = currentACT.getEnd() - currentACT.getStart() - elapsedTime;

            // Check if the task can be executed within its time limits
            if (remainingTime > 0) {
                int executionTime = Math.min(remainingTime, currentTask.getDuration());
                System.out.println(currentTask.getName() + " - Elapsed: " + elapsedTime + " - Remaining: " + remainingTime + " - Execution: " + executionTime);

                currentTask.setDuration(currentTask.getDuration() - executionTime);
                currentTime += executionTime;

                // Check if the task has finished
                if (currentTask.getDuration() == 0) {
                    scheduledTasks.add(currentTask);
                    currentTask.getACTs().remove(currentACT);
                    if (!currentTask.getACTs().isEmpty()) {
                        currentTask.setCurrentACT(currentTask.getACTs().get(0));
                        taskQueue.offer(currentTask);
                    }
                } else {
                    // Check for preemption
                    for (Task task : taskQueue) {
                        if (task.getPriority() < currentTask.getPriority()) {
                            task.setCurrentACT(currentTask.getCurrentACT());
                            break;
                        }
                    }
                    currentTask.setCurrentACT(null);
                    taskQueue.offer(currentTask);
                }
            } else {
                // The task cannot be executed within its time limits
                System.out.println(currentTask.getName() + " - Elapsed: " + elapsedTime + " - Remaining: " + remainingTime + " - Execution: 0");

                currentTask.setCurrentACT(null);
                taskQueue.offer(currentTask);
            }
        }

        // Print the scheduled tasks
        System.out.println("\nScheduled Tasks:");
        for (Task task : scheduledTasks) {
            System.out.println(task.getName());
        }
    }

    static class Task {
        private String name;
        private int duration;
        private int priority;
        private List<ACT> ACTs;
        private ACT currentACT;

        public Task(String name, int duration, int priority, List<ACT> ACTs) {
            this.name = name;
            this.duration = duration;
            this.priority = priority;
            this.ACTs = ACTs;
            this.currentACT = ACTs.get(0);
        }

        public String getName() {
            return name;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getPriority() {
            return priority;
        }

        public List<ACT> getACTs() {
            return ACTs;
        }

        public ACT getCurrentACT() {
            return currentACT;
        }

        public void setCurrentACT(ACT currentACT) {
            this.currentACT = currentACT;
        }
    }

    static class ACT {
        private String period;
        private int start;
        private int end;

        public ACT(String period, int start, int end) {
            this.period = period;
            this.start = start;
            this.end = end;
        }

        public String getPeriod() {
            return period;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    static class TaskComparator implements Comparator<Task> {
        @Override
        public int compare(Task task1, Task task2) {
            if (task1.getPriority() < task2.getPriority()) {
                return -1;
            } else if (task1.getPriority() > task2.getPriority()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
