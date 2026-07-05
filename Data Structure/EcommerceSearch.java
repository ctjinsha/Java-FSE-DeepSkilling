import java.util.*;

class Product {
    String name;

    Product(String name) {
        this.name = name;
    }
}

public class EcommerceSearch {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("Laptop"));
        products.add(new Product("Mobile"));
        products.add(new Product("Headphones"));
        products.add(new Product("Smart Watch"));
        products.add(new Product("Keyboard"));

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product name to search: ");
        String search = sc.nextLine();

        boolean found = false;

        for (Product p : products) {
            if (p.name.equalsIgnoreCase(search)) {
                System.out.println("Product Found: " + p.name);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product Not Found");
        }

        sc.close();
    }
}