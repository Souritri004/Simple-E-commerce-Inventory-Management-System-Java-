import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private String name;
    private int stock;

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(String name, int stock) {
        if (products.containsKey(name)) {
            System.out.println("Product already exists in the inventory.");
            return;
        }

        Product product = new Product(name, stock);
        products.put(name, product);
        System.out.println("Product added to the inventory.");
    }

    public void updateProductStock(String name, int stock) {
        Product product = products.get(name);
        if (product == null) {
            System.out.println("Product does not exist in the inventory.");
            return;
        }

        product.setStock(stock);
        System.out.println("Product stock updated.");
    }

    public void removeProduct(String name) {
        Product product = products.remove(name);
        if (product == null) {
            System.out.println("Product does not exist in the inventory.");
            return;
        }

        System.out.println("Product removed from the inventory.");
    }

    public void checkStock(String name) {
        Product product = products.get(name);
        if (product == null) {
            System.out.println("Product does not exist in the inventory.");
            return;
        }

        System.out.println("Available stock for " + name + ": " + product.getStock());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int choice;
        do {
            System.out.println("-------- Inventory Management System --------");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Stock");
            System.out.println("3. Remove Product");
            System.out.println("4. Check Product Stock");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial stock count: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    inventory.addProduct(name, stock);
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter updated stock count: ");
                    int updateStock = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    inventory.updateProductStock(updateName, updateStock);
                    break;
                case 3:
                    System.out.print("Enter product name: ");
                    String removeName = scanner.nextLine();
                    inventory.removeProduct(removeName);
                    break;
                case 4:
                    System.out.print("Enter product name: ");
                    String checkName = scanner.nextLine();
                    inventory.checkStock(checkName);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != 5);

        scanner.close();
    }
}
