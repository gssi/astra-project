package it.gssi.astra.telemetry;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class TelemetryUtility {

    public static List<PacketData> loadExcelFile(String filePath) {
        List<PacketData> packets = new ArrayList<>();
        Workbook workbook;
		try {
			workbook = WorkbookFactory.create(new File(filePath));
		
        Sheet sheet = workbook.getSheetAt(0);

        Row headerRow = sheet.getRow(sheet.getFirstRowNum());
        List<String> columnNames = new ArrayList<>();
        headerRow.forEach(cell -> columnNames.add(cell.getStringCellValue()));

        for (int rowNum = headerRow.getRowNum() + 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row == null) continue;

            String frameTime = row.getCell(0).getStringCellValue();
            int obrt = (int) row.getCell(1).getNumericCellValue();
            int pkt = (int) row.getCell(2).getNumericCellValue();
            String pktHeader = row.getCell(3).getStringCellValue();
            Map<String, Integer> taskDurations = new HashMap<>();

            for (int colIndex = 4; colIndex < columnNames.size(); colIndex++) {
                Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    String taskName = columnNames.get(colIndex);
                    int duration = (int) cell.getNumericCellValue();
                    taskDurations.put(taskName, duration);
                }
            }

            PacketData packet = new PacketData(frameTime, obrt, pkt, pktHeader);
            taskDurations.forEach(packet::addTaskDuration);
            packets.add(packet);
        }

        workbook.close();
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return packets;
    }
    
    
    // Metodo per stampare la matrice di correlazione in forma tabellare
    public static void printCorrelationMatrix(Map<String, Map<String, Double>> matrix) {
        System.out.printf("%15s", "");
        matrix.keySet().forEach(name -> System.out.printf("%15s", name));
        System.out.println();
        matrix.forEach((task1, correlations) -> {
            System.out.printf("%15s", task1);
            correlations.forEach((task2, value) -> System.out.printf("%15.2f", value));
            System.out.println();
        });
    }
}

