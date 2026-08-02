import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Employee(String name, String department, double salary) {}

public class GroupByDeptAndSalaryRange {

    private static String getSalaryRange(double salary) {
        if (salary < 50000) return "< 50000";
        if (salary <= 100000) return "50000-100000";
        return "> 100000";
    }

    public static Map<String, Map<String, List<Employee>>> groupEmployees(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.groupingBy(emp -> getSalaryRange(emp.salary()))
                ));
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", "IT", 120000),
            new Employee("Bob", "IT", 45000),
            new Employee("Charlie", "IT", 75000),
            new Employee("Diana", "HR", 48000),
            new Employee("Evan", "HR", 85000)
        );

        Map<String, Map<String, List<Employee>>> grouped = groupEmployees(employees);
        
        grouped.forEach((dept, salaryMap) -> {
            System.out.println("Department: " + dept);
            salaryMap.forEach((range, empList) -> {
                List<String> names = empList.stream().map(Employee::name).toList();
                System.out.printf("  Range [%s]: %s%n", range, names);
            });
        });
    }
}