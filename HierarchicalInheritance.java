//Default Constructor
class Employee {

    int id;
    String name;

    Employee() {
        id = 1;
        name = "Rahul";
    }

    void display() {
        System.out.println(id);
        System.out.println(name);
    }

    public static void main(String[] args) {

        Employee e1 = new Employee();

        e1.display();
    }
}