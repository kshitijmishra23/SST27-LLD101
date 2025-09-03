package exercise;

import java.util.Objects;

public final class EmployeeCSV {
  private final String csvRow;
  public EmployeeCSV(String csvRow) { this.csvRow = Objects.requireNonNull(csvRow); }
  public String getCsvRow() { return csvRow; }
  public String[] tokens() { return csvRow.split("\\s*,\\s*"); }
}
