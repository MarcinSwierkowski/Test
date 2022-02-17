package pl.sda.OOP;

import java.util.*;

public class Dokumenty {


    public static void main(String[] args) {
        TableDocument tableDoc = new TableDocument();
        tableDoc.addRow("name", "surname", "city");
        tableDoc.addRow("Jan", "Kowalski", "Wrocław");
        tableDoc.addRow("Ewa", "Nowak", "Warszawa");
        System.out.println(tableDoc.asText());
    }
}

class TableDocument {
    private List<List<String>> rows = new ArrayList<>();
    private Map<Integer, Integer> columnWidths = new TreeMap<>();

    public void addRow(String... columnValues) {
        rows.add(Arrays.asList(columnValues));
        updateWidths(columnValues);
    }

    public String asText() {
        if (!rows.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (List<String> row : rows) {
                stringBuilder
                        .append(rowToString(row))
                        .append("\n");
            }
            return stringBuilder.toString();
        }
        return "";
    }

    private String rowToString(List<String> row) {
        int columnWidth;
        String value;
        int valueWidth;
        String spaces;
        StringBuilder stringBuilder = new StringBuilder("|");
        for (int i = 0; i < row.size(); i++) {
            columnWidth = columnWidths.get(i);
            value = row.get(i);
            valueWidth = value.length();
            spaces = new String(new char[columnWidth - valueWidth]).replace("\0", " ");
            stringBuilder
                    .append(value)
                    .append(spaces)
                    .append("|");
        }
        return stringBuilder.toString();
    }

    /**
     * metoda pomocnicza, która pozwala mi aktualizować wymiary przyszłej tabeli,
     * potrzebuję jej, bo drukując już pierwszy wiersz, muszę wiedzieć jaką szerokość
     * będą miały najszersze komórki w każdej kolumnie
     **/
    private void updateWidths(String... columnValues) {
        int maxWidthForColumn;
        int currentValueWidth;
        String currentValue;
        for (int i = 0; i < columnValues.length; i++) {
            maxWidthForColumn = columnWidths.get(i) != null ? columnWidths.get(i) : 0;
            currentValue = columnValues[i];
            currentValueWidth = currentValue != null ? currentValue.length() : 0;
            // jeżeli obecna wartość dla komórki, jest większa od dotychczas spotkanych
            // to jej długość ustawię, jako nową maksymalną długość
            if (currentValueWidth > maxWidthForColumn) {
                columnWidths.put(i, currentValueWidth);
            }
        }
    }
}

