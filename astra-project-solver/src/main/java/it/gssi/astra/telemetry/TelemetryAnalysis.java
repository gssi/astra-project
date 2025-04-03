package it.gssi.astra.telemetry;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.util.*;
import java.util.stream.Collectors;

public class TelemetryAnalysis {
    
    private List<PacketData> packetDataList;

    public TelemetryAnalysis(List<PacketData> packetDataList) {
        this.packetDataList = packetDataList;
    }

    // Metodo per calcolare la media delle durate per ogni task
    public Map<String, Double> calculateAverageDurations() {
        Map<String, List<Integer>> taskDurations = new HashMap<>();
        packetDataList.forEach(packet -> {
            packet.getTaskDurations().forEach((taskName, duration) -> {
                taskDurations.computeIfAbsent(taskName, k -> new ArrayList<>()).add(duration);
            });
        });

        return taskDurations.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream().mapToInt(i -> i).average().orElse(0.0)));
    }
    
    
 // Metodo per ottenere la durata massima per ogni task
    public Map<String, Integer> getMaximumDurationsForEachTask() {
        Map<String, Integer> maxDurations = new HashMap<>();

        // Scorrere tutti i PacketData per raccogliere la durata massima di ciascun task
        for (PacketData packet : packetDataList) {
            Map<String, Integer> durations = packet.getTaskDurations();
            for (Map.Entry<String, Integer> entry : durations.entrySet()) {
                maxDurations.merge(entry.getKey(), entry.getValue(), Math::max);
            }
        }

        return maxDurations;
    }
    
    
    
    
    // Metodo per calcolare min, max e media delle durate di tutti i task in nanosecondi
    public void calculateDurationStatistics() {
        List<Integer> allDurations = new ArrayList<>();

        // Raccogliere tutte le durate dei task
        packetDataList.forEach(packet -> 
            packet.getTaskDurations().values().forEach(duration -> allDurations.add(duration)));

        // Calcolare minima, massima e media
        int minDuration = allDurations.stream().min(Integer::compare).orElse(0);
        int maxDuration = allDurations.stream().max(Integer::compare).orElse(0);
        double averageDuration = allDurations.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        // Stampare le statistiche in nanosecondi
        System.out.println("Duration Statistics for all tasks (in ns):");
        System.out.println("Minimum Duration: " + minDuration + " ns");
        System.out.println("Maximum Duration: " + maxDuration + " ns");
        System.out.println("Average Duration: " + String.format("%.2f", averageDuration) + " ns");
    }
    
    
    
    
    
    
    

    // Metodo per calcolare la varianza delle durate per ogni task
    public Map<String, Double> calculateVariance() {
        Map<String, List<Integer>> taskDurations = new HashMap<>();
        packetDataList.forEach(packet -> {
            packet.getTaskDurations().forEach((taskName, duration) -> {
                taskDurations.computeIfAbsent(taskName, k -> new ArrayList<>()).add(duration);
            });
        });

        Map<String, Double> means = calculateAverageDurations();

        return taskDurations.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> {
                double mean = means.get(entry.getKey());
                return entry.getValue().stream().mapToDouble(i -> Math.pow(i - mean, 2)).average().orElse(0.0);
            }));
    }

    
    // Metodo per calcolare la correlazione tra due task
    public double calculateCorrelation(String task1, String task2) {
        List<Double> task1Durations = new ArrayList<>();
        List<Double> task2Durations = new ArrayList<>();

        packetDataList.forEach(packet -> {
            if (packet.getTaskDurations().containsKey(task1) && packet.getTaskDurations().containsKey(task2)) {
                task1Durations.add((double) packet.getTaskDurations().get(task1));
                task2Durations.add((double) packet.getTaskDurations().get(task2));
            }
        });

        double[] task1Array = task1Durations.stream().mapToDouble(d -> d).toArray();
        double[] task2Array = task2Durations.stream().mapToDouble(d -> d).toArray();

        PearsonsCorrelation correlation = new PearsonsCorrelation();
        return correlation.correlation(task1Array, task2Array);
    }

    
    // Metodo per calcolare la correlazione tra tutte le coppie di task
    public Map<String, Map<String, Double>> calculateAllCorrelations() {
        Set<String> taskNames = new HashSet<>();
        packetDataList.forEach(packet -> taskNames.addAll(packet.getTaskDurations().keySet()));
        List<String> taskList = new ArrayList<>(taskNames);

        Map<String, Map<String, Double>> correlationMatrix = new HashMap<>();
        PearsonsCorrelation correlation = new PearsonsCorrelation();

        for (int i = 0; i < taskList.size(); i++) {
            for (int j = i; j < taskList.size(); j++) {
                String task1 = taskList.get(i);
                String task2 = taskList.get(j);
                double[] task1Data = packetDataList.stream().map(packet -> packet.getTaskDurations().getOrDefault(task1, 0).doubleValue()).mapToDouble(d -> d).toArray();
                double[] task2Data = packetDataList.stream().map(packet -> packet.getTaskDurations().getOrDefault(task2, 0).doubleValue()).mapToDouble(d -> d).toArray();

                double corr = correlation.correlation(task1Data, task2Data);
                correlationMatrix.computeIfAbsent(task1, k -> new HashMap<>()).put(task2, corr);
                if (!task1.equals(task2)) {
                    correlationMatrix.computeIfAbsent(task2, k -> new HashMap<>()).put(task1, corr);
                }
            }
        }
        return correlationMatrix;
    }

    // Metodo per stampare la matrice di correlazione in forma tabellare
    public void printCorrelationMatrix(Map<String, Map<String, Double>> matrix) {
        System.out.printf("%15s", "");
        matrix.keySet().forEach(name -> System.out.printf("%15s", name));
        System.out.println();
        matrix.forEach((task1, correlations) -> {
            System.out.printf("%15s", task1);
            correlations.forEach((task2, value) -> System.out.printf("%15.2f", value));
            System.out.println();
        });
    }
    
    
 // Metodo per trovare coppie di task con correlazione superiore a una soglia
    public List<String> findHighlyCorrelatedTasks(double threshold) {
        Set<String> taskNames = new HashSet<>();
        packetDataList.forEach(packet -> taskNames.addAll(packet.getTaskDurations().keySet()));
        List<String> taskList = new ArrayList<>(taskNames);
        PearsonsCorrelation correlation = new PearsonsCorrelation();
        List<String> highlyCorrelatedPairs = new ArrayList<>();

        for (int i = 0; i < taskList.size(); i++) {
            for (int j = i + 1; j < taskList.size(); j++) {
                String task1 = taskList.get(i);
                String task2 = taskList.get(j);
                double[] task1Data = packetDataList.stream()
                                                  .map(packet -> packet.getTaskDurations().getOrDefault(task1, 0).doubleValue())
                                                  .mapToDouble(d -> d).toArray();
                double[] task2Data = packetDataList.stream()
                                                  .map(packet -> packet.getTaskDurations().getOrDefault(task2, 0).doubleValue())
                                                  .mapToDouble(d -> d).toArray();

                double corr = correlation.correlation(task1Data, task2Data);
                if (Math.abs(corr) > threshold) {
                    highlyCorrelatedPairs.add(task1 + " and " + task2 + " : Correlation = " + String.format("%.2f", corr));
                }
            }
        }

        return highlyCorrelatedPairs;
    }
    
    
    
    // Metodo per identificare outlier nelle durate dei task
    public List<Double> identifyOutliers(String taskName) {
        List<Double> durations = packetDataList.stream()
                .map(packet -> (double) packet.getTaskDurations().getOrDefault(taskName, 0))
                .collect(Collectors.toList());

        double q1 = new Median().evaluate(durations.stream().mapToDouble(d -> d).toArray(), 0, 25);
        double q3 = new Median().evaluate(durations.stream().mapToDouble(d -> d).toArray(), 75, 100);
        double iqr = q3 - q1;
        double lowerBound = q1 - 1.5 * iqr;
        double upperBound = q3 + 1.5 * iqr;

        return durations.stream().filter(d -> d < lowerBound || d > upperBound).collect(Collectors.toList());
    }

    
    
    
    // Metodo per prevedere il comportamento futuro dei task usando la regressione lineare
    public SimpleRegression predictFutureBehavior(String taskName) {
        SimpleRegression regression = new SimpleRegression();
        for (int i = 0; i < packetDataList.size(); i++) {
            Integer duration = packetDataList.get(i).getTaskDurations().get(taskName);
            if (duration != null) {
                regression.addData(i, duration);
            }
        }
        return regression;
    }
    
    
    
    
    // Metodo per analizzare l'ottimizzazione dei task
    /*
     * Calcolo di Media e Varianza: Il metodo calcola la media e la varianza per le durate di ogni task. 
     * La media fornisce un'indicazione del tempo medio impiegato per il task, 
     * mentre la varianza mostra quanto le durate si discostano dalla media, indicando l'inconsistenza nelle esecuzioni.
     * 
     * Identificazione per Ottimizzazione: I task con una durata media o varianza che superano le soglie stabilite sono considerati 
     * candidati per l'ottimizzazione. Ciò suggerisce che questi task possono essere irregolari nelle loro esecuzioni o 
     * richiedere più tempo del necessario, entrambi fattori che possono essere indirizzati con strategie di ottimizzazione mirate.
     * 
     * Questa analisi identifica punti critici nell'esecuzione dei task che, se migliorati, potrebbero portare a prestazioni 
     * complessivamente più efficienti.
     */
    public void analyzeTaskOptimization(double timeThreshold, double varianceThreshold) {
        Map<String, List<Integer>> taskDurations = new HashMap<>();
        packetDataList.forEach(packet -> packet.getTaskDurations().forEach((task, duration) -> {
            taskDurations.computeIfAbsent(task, k -> new ArrayList<>()).add(duration);
        }));

        Map<String, Double> averageDurations = new HashMap<>();
        Map<String, Double> varianceDurations = new HashMap<>();

        taskDurations.forEach((task, durations) -> {
            double average = durations.stream().mapToDouble(d -> d).average().orElse(0);
            double variance = durations.stream().mapToDouble(d -> Math.pow(d - average, 2)).average().orElse(0);

            averageDurations.put(task, average);
            varianceDurations.put(task, variance);
        });

        System.out.println("Task Optimization Analysis Report:");
        System.out.println("Tasks that may need optimization based on duration and variability:");

        averageDurations.forEach((task, avg) -> {
            double var = varianceDurations.get(task);
            if (avg > timeThreshold || var > varianceThreshold) {
                System.out.println(String.format("Task: %s, Average Duration: %.2f, Variance: %.2f", task, avg, avg+3*Math.sqrt(var)));
            }
        });
    }
    
    
    // Metodo per trovare il task con la durata totale massima
    public String findMostActiveTask() {
        Map<String, Long> taskTotalDurations = new HashMap<>();

        // Sommare le durate per ogni task in tutti i packetData
        for (PacketData packet : packetDataList) {
            Map<String, Integer> durations = packet.getTaskDurations();
            for (Map.Entry<String, Integer> entry : durations.entrySet()) {
                taskTotalDurations.merge(entry.getKey(), entry.getValue().longValue(), Long::sum);
            }
        }

        // Determinare il task con la durata totale massima
        return taskTotalDurations.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("No tasks found");
    }
    
    
    
    
    // Metodo per calcolare la percentuale di esecuzione per ciascun task
    /*
     * Questo metodo fornisce un'analisi utile per capire l'impatto relativo di ciascun task sulle operazioni complessive, 
     * per identificare quali task richiedono più risorse o tempo e potrebbero beneficiare di ottimizzazione.
     * 
     * Passi del metodo:
     * 1) Calcolare la durata totale di ciascun task.
     * 2) Trovare la somma di tutte queste durate per ottenere il tempo totale di esecuzione.
     * 3) Calcolare la percentuale del tempo totale rappresentata da ogni task.
     */
    public Map<String, Double> calculateExecutionPercentage() {
        Map<String, Long> taskTotalDurations = new HashMap<>();

        // Accumulare le durate totali per ciascun task
        for (PacketData packet : packetDataList) {
            Map<String, Integer> durations = packet.getTaskDurations();
            for (Map.Entry<String, Integer> entry : durations.entrySet()) {
                taskTotalDurations.merge(entry.getKey(), entry.getValue().longValue(), Long::sum);
            }
        }

        // Calcolare la durata totale combinata di tutti i task
        long totalDuration = taskTotalDurations.values().stream().mapToLong(Long::longValue).sum();

        // Utilizzare TreeMap per ordinare automaticamente in base alla percentuale di esecuzione
        Map<String, Double> executionPercentages = new TreeMap<>(Comparator.comparing((String key) -> taskTotalDurations.get(key) / (double) totalDuration).reversed());

        taskTotalDurations.forEach((task, duration) -> {
            double percentage = 100.0 * duration / totalDuration;
            executionPercentages.put(task, percentage);
        });

        return executionPercentages;
    }
}
