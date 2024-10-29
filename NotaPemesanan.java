import java.util.ArrayList;
import java.util.List;

// Kelas MenuItem untuk merepresentasikan item makanan di menu
class MenuItem {
    private String name;
    private double unitPrice;
    private int quantity;

    // Constructor
    public MenuItem(String name, double unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    // Getter dan Setter
    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    // Menggunakan Custom Live Template "calc" untuk menghitung total harga item
    public double getTotalPrice() {
        double totalPrice = unitPrice * quantity; // calc
        return totalPrice;
    }
}

// Kelas OrderReceipt untuk mengelola pesanan dan mencetak nota
public class NotaPemesanan {
    private List<MenuItem> orderItems;

    public NotaPemesanan() {
        orderItems = new ArrayList<>();
    }

    // Menambahkan item ke pesanan
    public void addItem(MenuItem item) {
        orderItems.add(item);
    }

    // Menghitung total biaya semua item
    public double calculateTotalAmount() {
        double totalAmount = 0.0;
        for (MenuItem item : orderItems) {
            totalAmount += item.getTotalPrice(); // calc
        }
        return totalAmount;
    }

    // Mencetak nota
    public void printReceipt() {
        System.out.println("===== Nota Pemesanan Makanan =====");
        for (MenuItem item : orderItems) {
            System.out.printf("%s x%d - Rp %.2f%n", item.getName(), item.getQuantity(), item.getTotalPrice());
        }
        System.out.println("----------------------------------");
        System.out.printf("Total Bayar: Rp %.2f%n", calculateTotalAmount());
        System.out.println("==================================");
    }

    // Main Method
    public static void main(String[] args) {
        // Membuat nota pesanan baru
       NotaPemesanan order = new NotaPemesanan();

        // Menambahkan item ke nota pesanan
        order.addItem(new MenuItem("Nasi Goreng", 20000, 2));
        order.addItem(new MenuItem("Ayam Bakar", 25000, 1));
        order.addItem(new MenuItem("Es Teh Manis", 5000, 3));

        // Mencetak nota
        order.printReceipt();
    }
}
