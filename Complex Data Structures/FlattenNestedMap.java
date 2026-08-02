import java.util.List;
import java.util.Map;

record FlatEntry(String outerKey, String innerKey, Integer value) {}

public class FlattenNestedMap {

    public static List<FlatEntry> flattenMap(Map<String, Map<String, Integer>> nestedMap) {
        return nestedMap.entrySet().stream()
                .flatMap(outer -> outer.getValue().entrySet().stream()
                        .map(inner -> new FlatEntry(outer.getKey(), inner.getKey(), inner.getValue())))
                .toList();
    }

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> scores = Map.of(
            "Class A", Map.of("Alice", 90, "Bob", 85),
            "Class B", Map.of("Charlie", 95, "Diana", 88)
        );

        List<FlatEntry> flatList = flattenMap(scores);
        flatList.forEach(System.out::println);
    }
}