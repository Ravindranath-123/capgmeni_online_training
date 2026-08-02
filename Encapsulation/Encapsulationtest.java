public class EncapsulationDemo {

    public static void main(String[] args) {

        Student s = new Student();

        s.setId(101);
        s.setName("Amulya");

        System.out.println("Id: " + s.getId());
        System.out.println("Name: " + s.getName());
    }
}