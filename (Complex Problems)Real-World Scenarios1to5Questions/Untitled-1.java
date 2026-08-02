// //1)
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

// record Item(String name, double price) {}
// record Order(String customerName, List<Item> items) {}

// public class ShoppingCartAnalysis {

//     public static Map<String, Double> getTotalSpentPerCustomer(List<Order> orders) {
//         return orders.stream()
//                 .collect(Collectors.groupingBy(
//                         Order::customerName,
//                         Collectors.summingDouble(order ->
//                                 order.items().stream()
//                                         .mapToDouble(Item::price)
//                                         .sum()
//                         )
//                 ));
//     }

//     public static void main(String[] args) {
//         List<Order> orders = List.of(
//             new Order("Alice", List.of(new Item("Laptop", 1200.0), new Item("Mouse", 25.0))),
//             new Order("Bob", List.of(new Item("Headphones", 150.0))),
//             new Order("Alice", List.of(new Item("Keyboard", 80.0))),
//             new Order("Bob", List.of(new Item("Monitor", 300.0)))
//         );

//         Map<String, Double> result = getTotalSpentPerCustomer(orders);
//         result.forEach((customer, total) -> 
//             System.out.printf("%s total spent: $%.2f%n", customer, total));
//     }
// }

//2)
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

// record Book(String title, String author, int year, String genre) {}

// public class LibrarySystem {

//     public static String getMostPublishedGenre(List<Book> books) {
//         return books.stream()
//                 .collect(Collectors.groupingBy(Book::genre, Collectors.counting()))
//                 .entrySet().stream()
//                 .max(Map.Entry.comparingByValue())
//                 .map(Map.Entry::getKey)
//                 .orElse("N/A");
//     }

//     public static String getTopAuthor(List<Book> books) {
//         return books.stream()
//                 .collect(Collectors.groupingBy(Book::author, Collectors.counting()))
//                 .entrySet().stream()
//                 .max(Map.Entry.comparingByValue())
//                 .map(Map.Entry::getKey)
//                 .orElse("N/A");
//     }

//     public static void main(String[] args) {
//         List<Book> books = List.of(
//             new Book("Dune", "Frank Herbert", 1965, "Sci-Fi"),
//             new Book("Dune Messiah", "Frank Herbert", 1969, "Sci-Fi"),
//             new Book("The Hobbit", "J.R.R. Tolkien", 1937, "Fantasy"),
//             new Book("The Silmarillion", "J.R.R. Tolkien", 1977, "Fantasy"),
//             new Book("Foundation", "Isaac Asimov", 1951, "Sci-Fi")
//         );

//         System.out.println("Most Published Genre: " + getMostPublishedGenre(books));
//         System.out.println("Author with Most Books: " + getTopAuthor(books));
//     }
// }

// //3)
// import java.time.LocalDate;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

// record Employee(int id, String name, String department, double salary, LocalDate joiningDate) {}

// public class EmployeeAnalysis {

//     public static Map<String, Double> getRecentHireAvgSalaryByDept(List<Employee> employees) {
//         LocalDate fiveYearsAgo = LocalDate.now().minusYears(5);

//         return employees.stream()
//                 .filter(emp -> !emp.joiningDate().isBefore(fiveYearsAgo))
//                 .collect(Collectors.groupingBy(
//                         Employee::department,
//                         Collectors.averagingDouble(Employee::salary)
//                 ));
//     }

//     public static void main(String[] args) {
//         List<Employee> employees = List.of(
//             new Employee(1, "Alice", "IT", 90000, LocalDate.now().minusYears(2)),
//             new Employee(2, "Bob", "IT", 80000, LocalDate.now().minusYears(6)), // Excluded (> 5 yrs)
//             new Employee(3, "Charlie", "HR", 60000, LocalDate.now().minusYears(1)),
//             new Employee(4, "Diana", "IT", 95000, LocalDate.now().minusYears(3)),
//             new Employee(5, "Evan", "HR", 65000, LocalDate.now().minusYears(4))
//         );

//         Map<String, Double> result = getRecentHireAvgSalaryByDept(employees);
//         result.forEach((dept, avg) -> 
//             System.out.printf("%s Dept Average (Hired in last 5 yrs): $%.2f%n", dept, avg));
//     }
// }

//4)
// import java.util.Comparator;
// import java.util.List;
// import java.util.stream.IntStream;

// record Student(String name, List<Integer> marks) {}
// record StudentResult(String name, double percentage, int rank) {}

// public class StudentReport {

//     public static List<StudentResult> generateReportCard(List<Student> students) {
//         record Intermediate(String name, double percentage) {}

//         List<Intermediate> sorted = students.stream()
//                 .map(s -> new Intermediate(
//                         s.name(),
//                         s.marks().stream().mapToInt(Integer::intValue).average().orElse(0.0)
//                 ))
//                 .sorted(Comparator.comparingDouble(Intermediate::percentage).reversed())
//                 .toList();

//         return IntStream.range(0, sorted.size())
//                 .mapToObj(i -> new StudentResult(
//                         sorted.get(i).name(),
//                         Math.round(sorted.get(i).percentage() * 100.0) / 100.0,
//                         i + 1
//                 ))
//                 .toList();
//     }

//     public static void main(String[] args) {
//         List<Student> students = List.of(
//             new Student("Alice", List.of(85, 90, 88, 92, 95)),
//             new Student("Bob", List.of(70, 75, 80, 68, 72)),
//             new Student("Charlie", List.of(95, 98, 92, 96, 90))
//         );

//         List<StudentResult> reportCard = generateReportCard(students);
//         reportCard.forEach(res -> 
//             System.out.printf("Rank %d: %s - %.2f%%%n", res.rank(), res.name(), res.percentage()));
//     }
// }

//5)
// import java.util.Comparator;
// import java.util.List;
// import java.util.stream.IntStream;

// record Student(String name, List<Integer> marks) {}
// record StudentResult(String name, double percentage, int rank) {}

// public class StudentReport {

//     public static List<StudentResult> generateReportCard(List<Student> students) {
//         record Intermediate(String name, double percentage) {}

//         List<Intermediate> sorted = students.stream()
//                 .map(s -> new Intermediate(
//                         s.name(),
//                         s.marks().stream().mapToInt(Integer::intValue).average().orElse(0.0)
//                 ))
//                 .sorted(Comparator.comparingDouble(Intermediate::percentage).reversed())
//                 .toList();

//         return IntStream.range(0, sorted.size())
//                 .mapToObj(i -> new StudentResult(
//                         sorted.get(i).name(),
//                         Math.round(sorted.get(i).percentage() * 100.0) / 100.0,
//                         i + 1
//                 ))
//                 .toList();
//     }

//     public static void main(String[] args) {
//         List<Student> students = List.of(
//             new Student("Alice", List.of(85, 90, 88, 92, 95)),
//             new Student("Bob", List.of(70, 75, 80, 68, 72)),
//             new Student("Charlie", List.of(95, 98, 92, 96, 90))
//         );

//         List<StudentResult> reportCard = generateReportCard(students);
//         reportCard.forEach(res -> 
//             System.out.printf("Rank %d: %s - %.2f%%%n", res.rank(), res.name(), res.percentage()));
//     }
// }