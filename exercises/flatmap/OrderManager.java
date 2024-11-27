package exercises.flatmap;



import java.util.List;
import java.util.stream.Collectors;

class Order {
    private String customerId;
    private List<Item> items;

     public Order(String customerId, List<Item> items) {
         this.customerId = customerId;
         this.items = items;
     }

     public String getCustomerId() {
         return customerId;
     }

     public void setCustomerId(String customerId) {
         this.customerId = customerId;
     }

     public List<Item> getItems() {
         return items;
     }

     public void setItems(List<Item> items) {
         this.items = items;
     }

     // Constructor, Getters, and Setters
}

 class Item {
     public Item(String name, double price) {
         this.name = name;
         this.price = price;
     }

     private String name;
    private double price;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public double getPrice() {
         return price;
     }

     public void setPrice(double price) {
         this.price = price;
     }

     // Constructor, Getters, and Setters
}


public class OrderManager {


    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("C1", List.of(new Item("A", 10.0), new Item("B", 20.0))),
                new Order("C2", List.of(new Item("C", 15.0))),
                new Order("C1", List.of(new Item("D", 25.0))),
                new Order("C3", List.of(new Item("E", 30.0), new Item("F", 5.0)))
        );

        /**
         *
         * The total number of orders.
         * The total revenue generated from all orders.
         * The average revenue per order.
         * The total number of unique customers.
         * A breakdown of total revenue per customer.
         */


        System.out.println("total number of orders" + orders.size());

        System.out.println(orders.stream().flatMap(order -> order.getItems().stream())
                .mapToDouble(item -> item.getPrice()).summaryStatistics().getSum());

        System.out.println(orders.stream().flatMap(order -> order.getItems().stream())
                .mapToDouble(item -> item.getPrice()).summaryStatistics().getAverage());

        System.out.println(orders.stream().map(order -> order.getCustomerId()).distinct().count());


        System.out.println(orders.stream().collect(Collectors.groupingBy(Order::getCustomerId, Collectors.collectingAndThen(Collectors.toList(),

                orderList -> {
                  return  orderList.stream().flatMap(order -> order.getItems().stream()).mapToDouble(item -> item.getPrice()).sum();
                }

                ))));



    }
}
