import java.util.List;
import java.util.stream.Stream;

record Category(String name, List<Category> subcategories) {}

public class FlattenCategoryTree {

    public static Stream<Category> flattenCategory(Category category) {
        return Stream.concat(
                Stream.of(category),
                category.subcategories().stream().flatMap(FlattenCategoryTree::flattenCategory)
        );
    }

    public static List<String> getAllCategoryNames(List<Category> categories) {
        return categories.stream()
                .flatMap(FlattenCategoryTree::flattenCategory)
                .map(Category::name)
                .toList();
    }

    public static void main(String[] args) {
        Category smartphones = new Category("Smartphones", List.of());
        Category laptops = new Category("Laptops", List.of());
        Category electronics = new Category("Electronics", List.of(smartphones, laptops));
        
        Category shirts = new Category("Shirts", List.of());
        Category clothing = new Category("Clothing", List.of(shirts));

        List<Category> catalog = List.of(electronics, clothing);

        System.out.println("All Category Names in Tree: " + getAllCategoryNames(catalog));
    }
}