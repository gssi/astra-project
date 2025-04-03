package it.gssi.astra.telemetry;

import java.util.HashMap;
import java.util.Map;

public class PacketData {
    private String frameTime;    // Timestamp delle misurazioni
    private int obrt;            // OBRT, dato di cui il significato è sconosciuto
    private int pkt;             // Valore Pkt da salvare
    private String pktHeader;    // Valore PktHeader da salvare
    private Map<String, Integer> taskDurations; // Mappa per memorizzare i nomi dei task e le loro durate massime

    public PacketData(String frameTime, int obrt, int pkt, String pktHeader) {
        this.frameTime = frameTime;
        this.obrt = obrt;
        this.pkt = pkt;
        this.pktHeader = pktHeader;
        this.taskDurations = new HashMap<>();
    }

    public void addTaskDuration(String taskName, int duration) {
        this.taskDurations.put(taskName, duration);
    }

    // Getter per FrameTime
    public String getFrameTime() {
        return frameTime;
    }

    // Getter per OBRT
    public int getObrt() {
        return obrt;
    }

    // Getter per Pkt
    public int getPkt() {
        return pkt;
    }

    // Getter per PktHeader
    public String getPktHeader() {
        return pktHeader;
    }

    // Metodo per ottenere la durata di un task specifico
    public int getTaskDuration(String taskName) {
        return this.taskDurations.getOrDefault(taskName, 0);
    }

    // Metodo per ottenere tutte le durate dei task
    public Map<String, Integer> getTaskDurations() {
        return taskDurations;
    }

    @Override
    public String toString() {
        return "PacketData{" +
                "frameTime='" + frameTime + '\'' +
                ", obrt=" + obrt +
                ", pkt=" + pkt +
                ", pktHeader='" + pktHeader + '\'' +
                ", taskDurations=" + taskDurations +
                '}';
    }
}
