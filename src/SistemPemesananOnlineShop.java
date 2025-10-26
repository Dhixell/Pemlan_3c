

// Record digunakan untuk menyimpan data sederhana
record Item(String name, double price, int quantity) {
    // 1️⃣ Introduce Constant
    public static final double DISCOUNT_RATE = 0.1;

    // 2️⃣ Extract Method
    public double calculateTotal() {
        return price * quantity;
    }

    public double calculateDiscountedTotal() {
        return calculateTotal() - (calculateTotal() * DISCOUNT_RATE);
    }
}

record Customer(String name, String address, String phone) {
}

// 3️⃣ Introduce Parameter Object
class OrderInfo {
    Item item;
    Customer customer;

    public OrderInfo(Item item, Customer customer) {
        this.item = item;
        this.customer = customer;
    }
}

// 4️⃣ Extract Interface
interface OrderSystem {
}

// 5️⃣ Rename Method
class OnlineShop implements OrderSystem {
    private final OrderInfo orderInfo;

    public OnlineShop(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public void displayOrder() {
        System.out.println("=== INFORMASI PESANAN ===");
        System.out.println("Nama Customer: " + orderInfo.customer.name());
        System.out.println("Alamat: " + orderInfo.customer.address());
        System.out.println("Nomor: " + orderInfo.customer.phone());
        System.out.println("Barang: " + orderInfo.item.name());
        System.out.println("Harga Satuan: " + orderInfo.item.price());
        System.out.println("Jumlah: " + orderInfo.item.quantity());
        System.out.println("Total Harga (Setelah Diskon): " +
                orderInfo.item.calculateDiscountedTotal());
    }
}

// 6️⃣ Move Method
public class SistemPemesananOnlineShop {
    public static void main(String[] args) {
        Item item = new Item("Kemeja", 150000, 2);
        Customer c = new Customer("Andi", "Jl. Merdeka No. 5", "08123456789");
        OrderInfo order = new OrderInfo(item, c);

        OnlineShop shop = new OnlineShop(order);
        shop.displayOrder();
    }
}
