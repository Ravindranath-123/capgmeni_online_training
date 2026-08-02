//1)
// import java.util.Comparator;
// import java.util.List;

// public class SortByLengthThenAlpha {

//     public static List<String> sortStrings(List<String> strings) {
//         return strings.stream()
//                 .sorted(Comparator
//                         .comparingInt(String::length)
//                         .thenComparing(Comparator.naturalOrder()))
//                 .toList();
//     }

//     public static void main(String[] args) {
//         List<String> words = List.of("banana", "apple", "fig", "cherry", "date", "kiwi", "pear");

//         System.out.println("Original: " + words);
//         System.out.println("Sorted:   " + sortStrings(words));
//     }
// }

//2)
// import java.util.Comparator;
// import java.util.List;

// public class SortByAbsoluteValue {

//     public static List<Integer> sortByAbs(List<Integer> numbers) {
//         return numbers.stream()
//                 .sorted(Comparator.comparingInt(Math::abs))
//                 .toList();
//     }

//     public static void main(String[] args) {
//         List<Integer> numbers = List.of(-10, 5, -2, 8, 1, -1, 0, -5);

//         System.out.println("Original: " + numbers);
//         System.out.println("Sorted:   " + sortByAbs(numbers));
//     }
// }