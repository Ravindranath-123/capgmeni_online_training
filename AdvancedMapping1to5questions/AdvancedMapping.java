//1)
// import java.util.List;

// record Employee(String name, double salary, String department) {}

// public class AboveAverageSalary {

//     public static List<String> getHighEarners(List<Employee> employees) {
//         double avgSalary = employees.stream()
//                 .mapToDouble(Employee::salary)
//                 .average()
//                 .orElse(0.0);

//         return employees.stream()
//                 .filter(e -> e.salary() > avgSalary)
//                 .map(Employee::name)
//                 .toList();
//     }

//     public static void main(String[] args) {
//         List<Employee> employees = List.of(
//             new Employee("Alice", 70000, "Engineering"),
//             new Employee("Bob", 50000, "HR"),
//             new Employee("Charlie", 90000, "Engineering"),
//             new Employee("Diana", 40000, "Marketing")
//         );

//         System.out.println("Employees earning above average: " + getHighEarners(employees));
//     }
// }

//2)
// import java.util.List;

// public class LongestStringLength {

//     public static int getLongestLength(List<String> strings) {
//         return strings.stream()
//                 .mapToInt(String::length)
//                 .max()
//                 .orElse(0);
//     }

//     public static void main(String[] args) {
//         List<String> words = List.of("apple", "banana", "dragonfruit", "kiwi");
        
//         System.out.println("Length of longest string: " + getLongestLength(words));
//     }
// }

//3)
// import java.util.List;
// import java.util.Map;
// import java.util.function.Function;
// import java.util.stream.Collectors;

// public class StringLengthMap {

//     public static Map<String, Integer> mapStringToLength(List<String> strings) {
//         return strings.stream()
//                 .collect(Collectors.toMap(
//                         Function.identity(),
//                         String::length,
//                         (existing, replacement) -> existing
//                 ));
//     }

//     public static void main(String[] args) {
//         List<String> words = List.of("java", "stream", "mapping", "code");

//         System.out.println("String -> Length Map: " + mapStringToLength(words));
//     }
// }

//4)
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

// record Product(String name, double price) {}

// public class ProductPriceMap {

//     public static Map<String, Double> mapProductToPrice(List<Product> products) {
//         return products.stream()
//                 .collect(Collectors.toMap(
//                         Product::name,
//                         Product::price,
//                         (existing, replacement) -> replacement
//                 ));
//     }

//     public static void main(String[] args) {
//         List<Product> products = List.of(
//             new Product("Laptop", 1200.00),
//             new Product("Mouse", 25.50),
//             new Product("Keyboard", 75.00)
//         );

//         System.out.println("Product -> Price Map: " + mapProductToPrice(products));
//     }
// }

//5)
import java.util.List;

record Employee(String name, double salary, String department) {}

public class UniqueDepartments {

    public static List<String> getUniqueDepartments(List<Employee> employees) {
        return employees.stream()
                .map(Employee::department)
                .distinct()
                .toList();
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", 70000, "Engineering"),
            new Employee("Bob", 50000, "HR"),
            new Employee("Charlie", 90000, "Engineering"),
            new Employee("Diana", 40000, "Marketing"),
            new Employee("Evan", 60000, "HR")
        );

        System.out.println("Unique Departments: " + getUniqueDepartments(employees));
    }
}