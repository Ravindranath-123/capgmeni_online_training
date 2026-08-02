import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record EmployeeRecord(int id, String name, String department, double salary) {}

public class CsvAnalysis {

    public static List<EmployeeRecord> parseCsv(List<String[]> csvRows) {
        return csvRows.stream()
                .map(row -> new EmployeeRecord(
                        Integer.parseInt(row[0].trim()),
                        row[1].trim(),
                        row[2].trim(),
                        Double.parseDouble(row[3].trim())
                ))
                .toList();
    }

    public static void main(String[] args) {
        // Raw CSV data representing [id, name, department, salary]
        List<String[]> csvRows = List.of(
            new String[]{"1", "Alice", "IT", "95000.0"},
            new String[]{"2", "Bob", "HR", "50000.0"},
            new String[]{"3", "Charlie", "IT", "80000.0"},
            new String[]{"4", "Diana", "HR", "60000.0"}
        );

        // 1. Convert to objects
        List<EmployeeRecord> employees = parseCsv(csvRows);

        // 2. Average salary by department
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        EmployeeRecord::department,
                        Collectors.averagingDouble(EmployeeRecord::salary)
                ));

        // 3. Find top earner
        EmployeeRecord topEarner = employees.stream()
                .max(Comparator.comparingDouble(EmployeeRecord::salary))
                .orElseThrow();

        System.out.println("Parsed Employees: " + employees.size());
        System.out.println("Average Salary per Department: " + avgSalaryByDept);
        System.out.println("Highest Earner: " + topEarner.name() + " ($" + topEarner.salary() + ")");
    }
}