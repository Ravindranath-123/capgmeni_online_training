import java.util.List;
import java.util.Map;

public class FlattenMapOfIntegers {

    public static List<Integer> flattenMapValues(Map<String, List<Integer>> map) {
        return map.values().stream()
                .flatMap(List::stream)
                .toList();
    }

    public static void main(String[] args) {
        Map<String, List<Integer>> map = Map.of(
            "Group A", List.of(10, 20, 30),
            "Group B", List.of(40, 50),
            "Group C", List.of(60, 70, 80)
        );

        System.out.println("Flattened Integers: " + flattenMapValues(map));
    }
}