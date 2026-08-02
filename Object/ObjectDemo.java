public class ObjectDemo {

    public static void main(String[] args) {

        Product p1 = new Product(101, "Laptop");
        Product p2 = new Product(101, "Laptop");

        // Calls toString()
        System.out.println(p1);

        // Calls equals()
        System.out.println(p1.equals(p2));
    }
}