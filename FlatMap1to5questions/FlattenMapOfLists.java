//1)
// import java.util.List;

// public class FlattenListOfLists {

//     public static List<Integer> flatten(List<List<Integer>> nestedList) {
//         return nestedList.stream()
//                 .flatMap(List::stream)
//                 .toList();
//     }

//     public static void main(String[] args) {
//         List<List<Integer>> listOfLists = List.of(
//             List.of(1, 2, 3),
//             List.of(4, 5),
//             List.of(6, 7, 8, 9)
//         );

//         System.out.println("Flattened Integers: " + flatten(listOfLists));
//     }
// }

//2)
// import java.util.Arrays;
// import java.util.List;

// public class FlattenListOfArrays {

//     public static List<String> flatten(List<String[]> listOfArrays) {
//         return listOfArrays.stream()
//                 .flatMap(Arrays::stream)
//                 .toList();
//     }

//     public static void main(String[] args) {
//         List<String[]> listOfArrays = List.of(
//             new String[]{"Java", "Python"},
//             new String[]{"C++", "Go"},
//             new String[]{"Rust"}
//         );

//         System.out.println("Flattened Strings: " + flatten(listOfArrays));
//     }
// }

//3)
// import java.util.Arrays;
// import java.util.List;

// public class UniqueWords {

//     public static List<String> getUniqueWords(List<String> sentences) {
//         return sentences.stream()
//                 .flatMap(sentence -> Arrays.stream(sentence.split("\\s+")))
//                 .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase())
//                 .filter(word -> !word.isEmpty())
//                 .distinct()
//                 .toList();
//     }

//     public static void main(String[] args) {
//         List<String> sentences = List.of(
//             "Hello world",
//             "hello Java stream API",
//             "world of Java code"
//         );

//         System.out.println("Unique Words: " + getUniqueWords(sentences));
//     }
// }

//4)
// import java.util.List;

// record Item(String name, double price) {}
// record Order(int orderId, List<Item> items) {}

// public class OrderItemsExtractor {

//     public static List<String> getAllItemNames(List<Order> orders) {
//         return orders.stream()
//                 .flatMap(order -> order.items().stream())
//                 .map(Item::name)
//                 .toList();
//     }

//     public static void main(String[] args) {
//         List<Order> orders = List.of(
//             new Order(101, List.of(new Item("Laptop", 1200.0), new Item("Mouse", 25.0))),
//             new Order(102, List.of(new Item("Keyboard", 75.0), new Item("Monitor", 300.0))),
//             new Order(103, List.of(new Item("Mouse", 25.0)))
//         );

//         System.out.println("All Item Names: " + getAllItemNames(orders));
//     }
// }

//5)
// import java.util.List;
// import java.util.Map;

// public class FlattenMapOfLists {

//     public static <K, V> List<V> flattenMapValues(Map<K, List<V>> map) {
//         return map.values().stream()
//                 .flatMap(List::stream)
//                 .toList();
//     }

//     public static void main(String[] args) {
//         Map<String, List<String>> categoryMap = Map.of(
//             "Fruits", List.of("Apple", "Banana"),
//             "Vegetables", List.of("Carrot", "Spinach"),
//             "Grains", List.of("Rice", "Wheat")
//         );

//         System.out.println("Flattened Map Values: " + flattenMapValues(categoryMap));
//     }
// }