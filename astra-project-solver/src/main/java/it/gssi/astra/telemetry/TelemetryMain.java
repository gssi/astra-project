package it.gssi.astra.telemetry;

import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.util.*;

public class TelemetryMain {
	
	public static void main(String[] args) {
		
		String filePath = "telemetries/Pkt_00103.xls";
		
        List<PacketData> packets = TelemetryUtility.loadExcelFile(filePath);
        TelemetryAnalysis analysis = new TelemetryAnalysis(packets);
        
//        for (PacketData packetData : packets) {
//			System.out.println(packetData);
//		}
        
        /*
         * Calcolo delle Medie e Varianze: 
         * I metodi calculateAverageDurations e calculateVariance esemplificano 
         * come si possono calcolare le statistiche base per ogni tipo di task 
         * basato sulle loro durate di esecuzione. Queste analisi forniscono 
         * una comprensione basilare delle performance dei task.
         */
        Map<String, Double> averages = analysis.calculateAverageDurations();
        Map<String, Double> variances = analysis.calculateVariance();
        
        System.out.println("Average Durations: " + averages);
        System.out.println("Variances: " + variances);
        
        
        System.out.println("----------------------------------------------------------------------------");
        
        
        
        
        analysis.calculateDurationStatistics();  // Calcola e stampa le statistiche delle durate
        
        
        
        
        System.out.println("----------------------------------------------------------------------------");
        
        
        
        
        
        //----------------------------------------------------------------------------
        
        String task1 = "DNT40508(SATCM max dur)[ns]";
        String task2 = "DNT40513(SSMAPL max dur)[ns]";
        
        /*
         * Analisi complessa
         */
        // Correlazione: Utilizziamo la correlazione di Pearson per esaminare la relazione lineare tra le durate di due task specifici.
        double correlation = analysis.calculateCorrelation(task1, task2);
        System.out.println("Correlation between "+task1+" and "+task2+": " + correlation);
        
        System.out.println("----------------------------------------------------------------------------");
        
        Map<String, Map<String, Double>> correlations = analysis.calculateAllCorrelations();
        analysis.printCorrelationMatrix(correlations);
        
        System.out.println("----------------------------------------------------------------------------");
        
        double correlationThreshold = 0.8; // Definisci la soglia di correlazione
        List<String> correlatedTasks = analysis.findHighlyCorrelatedTasks(correlationThreshold);
        System.out.println("Pairs of tasks with correlation above " + correlationThreshold + ":");
        correlatedTasks.forEach(System.out::println);
        
        System.out.println("----------------------------------------------------------------------------");
        

        // Outlier Detection: Applichiamo la tecnica dell'Interquartile Range (IQR) per identificare gli outlier nelle durate dei task.
        List<Double> outliers = analysis.identifyOutliers(task1);
        System.out.println("Outliers in "+task1+": " + outliers);
        
        System.out.println("----------------------------------------------------------------------------");

        // Regressione Lineare: Usiamo SimpleRegression di Apache Commons Math per modellare la tendenza delle durate di un task e prevedere comportamenti futuri.
        SimpleRegression regression = analysis.predictFutureBehavior(task1);
        System.out.println("Future behavior prediction for "+task1+": Slope = " + regression.getSlope() + ", Intercept = " + regression.getIntercept());
    
        System.out.println("----------------------------------------------------------------------------");
        
        // Definisci le soglie in base alle tue specifiche esigenze
        double timeThreshold = 10000;  // Durata media che consideri eccessiva
        double varianceThreshold = 2000;  // Variabilità che consideri eccessiva

        analysis.analyzeTaskOptimization(timeThreshold, varianceThreshold);
        
        
        
        System.out.println("----------------------------------------------------------------------------");
        
        
        
        String mostActiveTask = analysis.findMostActiveTask();
        System.out.println("The most active task is: " + mostActiveTask);
        
        
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Execution Percentages");
        System.out.println("----------------------------------------------------------------------------");
        
        
        Map<String, Double> executionPercentages = analysis.calculateExecutionPercentage();
        System.out.println("Execution Percentages for each task:");
        executionPercentages.forEach((task, percentage) ->
            System.out.println(task + ": " + String.format("%.2f", percentage) + "%"));
    
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("MAX Execution Duration for all tasks");
        System.out.println("----------------------------------------------------------------------------");
        
        
        Map<String, Integer> maxDurations = analysis.getMaximumDurationsForEachTask();
        System.out.println("Maximum durations for each task:");
        maxDurations.forEach((task, duration) ->
            System.out.println(task + ": " + duration/1000000.0 + " ms"));
    }
	
	
	

}
