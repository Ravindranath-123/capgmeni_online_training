class Product {

    int id;
    String name;

    Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object obj) {

        Product p = (Product) obj;

        return this.id == p.id;
    }
}