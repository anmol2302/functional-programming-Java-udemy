package exercises;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Person {
    private String name;
    private int age;
    private String role;

    // Constructor
    public Person(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    // toString for easy printing
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", role='" + role + "'}";
    }
}

class Employees {
    String name;
    int age;
    double salary;
    String department;

    public Employees(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    // Constructor, getters, and toString() methods
}

class Product {
    String name;
    double price;
    double rating;
    String category;

    public Product(String name, double price, double rating, String category) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.category = category;
    }

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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    // Constructor, getters, and toString() methods
}

class Transaction {
    private LocalDate date;
    private double amount;

    // Constructor
    public Transaction(LocalDate date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}


class Order {
    double totalAmount;
    String status;

    public Order(double totalAmount, String status) {
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // Constructor, getters, and toString() methods
}


class Customer {
    private String name;
    private Optional<String> address;

    // Constructor
    public Customer(String name, Optional<String> address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(Optional<String> address) {
        this.address = address;
    }
}


public class Revision {

    public static void main(String[] args) {

        List<Integer> numList = Arrays.asList(1, 2, 3, 3, 4, 5, 6, 6, 89);
        List<Employees> employees = Arrays.asList(
                new Employees("Alice", 30, 60000, "IT"),
                new Employees("Bob", 25, 45000, "HR"),
                new Employees("Charlie", 30, 70000, "IT"),
                new Employees("David", 40, 80000, "Finance"),
                new Employees("Eve", 25, 50000, "HR")
        );

        List<Product> products = Arrays.asList(
                new Product("Laptop", 1000, 4.5, "Electronics"),
                new Product("Phone", 500, 4.2, "Electronics"),
                new Product("Desk", 150, 3.8, "Furniture"),
                new Product("Chair", 100, 4.1, "Furniture")
        );

        List<Order> orders = Arrays.asList(
                new Order(120, "Shipped"),
                new Order(80, "Pending"),
                new Order(150, "Shipped"),
                new Order(50, "Pending")
        );

        List<Transaction> transactions = Arrays.asList(
                new Transaction(LocalDate.of(2023, 1, 1), 200),
                new Transaction(LocalDate.of(2023, 5, 5), 300),
                new Transaction(LocalDate.of(2024, 7, 10), 100)
        );

        List<Customer> customers = Arrays.asList(
                new Customer("Alice", Optional.of("1234 Elm St")),
                new Customer("Bob", Optional.empty()),
                new Customer("Charlie", Optional.of("5678 Oak St"))
        );

        List<String> words = Arrays.asList("apple", "orange", "banana", "apple", "orange");
        List<String> mapWords = Arrays.asList("apple orange", "banana apple", "orange banana");
        List<Double> pricesList = Arrays.asList(12.0,15.1,16.9);
        List<List<String>> wordsList = Arrays.asList(Arrays.asList("apple", "banana"), Arrays.asList("orange", "grape"));

        // Calling the tasks
        System.out.println("=== Task 1: Grouping by Department and Age ===");

        Map<String, Map<Integer, List<Employees>>> empMap = employees
                .stream()
                .collect(Collectors.groupingBy(emp -> emp.department, Collectors.groupingBy(em -> em.age)));
        System.out.println(empMap);

        System.out.println("=== Task 2: Sort product by price, if same price sort them in rating basis");

        System.out.println(products.stream().sorted(Comparator.comparing(Product::getPrice).reversed().thenComparing(Product::getRating)).toList());

        System.out.println("=== Task 3: remove duplicates from Integer list and collect them into set");

        System.out.println(numList.stream().collect(Collectors.toSet()));

        System.out.println("=== Task 4: Partition data based on order price >= 100");

        Map<Boolean, List<Order>> orderPartiotionMap = orders.stream().collect(Collectors.partitioningBy(ord -> ord.totalAmount >= 100));
        System.out.println(orderPartiotionMap.get(true));
        System.out.println(orderPartiotionMap.get(false));

        System.out.println("=== Task 5: Maps the employee names into a Map<String, Double> where the key is the employee's name and the value is their salary");

        System.out.println(employees.stream().collect(Collectors.toMap(emp -> emp.name, emp -> emp.salary)));

        System.out.println("=== Task 6: Flattens the list into a single List<String> of words.");

        System.out.println(wordsList.stream().flatMap(wor -> wor.stream()).map(wo -> wo).toList());

        System.out.println("=== Task 7:  Within each groupby category, sort the products by price in descending order.");

        System.out.println(products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.collectingAndThen(Collectors.toList(), pro -> pro.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).toList()))));

        System.out.println("=== Task 8:  Count the occurence of words");

        System.out.println(words.stream().collect(Collectors.groupingBy(word -> word, Collectors.counting())));

        System.out.println("=== Task 9:  Filters employees whose salary >= 50,000. Maps the names of the filtered employees into a single String (comma-separated).");

        System.out.println(employees.stream().filter(e -> e.salary>=50000).map(e -> e.name).collect(Collectors.joining(",")));

        System.out.println("=== Task 10:  Extracts the non-null addresses of Customer and collects them into a List<String>.");

        customers.stream().filter(cust -> cust.getAddress().isPresent()).map(cust -> cust.getAddress().get()).collect(Collectors.toList());

        System.out.println("=== Task 11:  Sums the amount of all transactions that occurred in the year 2023.");

        System.out.println(transactions.stream().filter(trans -> trans.getDate().getYear()==2023).mapToDouble(tra -> tra.getAmount()).sum());

        System.out.println("=== Task 12:  Sums the amount of all prices using reduce method.");

        System.out.println(pricesList.stream().reduce(0.0 , (a,b)-> a+b));

        System.out.println("=== Task 13:  Find max price product and lowest price product");

        System.out.println(products.stream().mapToDouble(e -> e.price).summaryStatistics());


        System.out.println("=== Task 14: Collects the products into a Map<Integer, Double> where:\n" +
                "        The key is the productId.\n" +
                "                The value is the price of the product.\n" +
                "\n" +
                "\n");

        System.out.println( products.stream().collect(Collectors.toMap(e -> e.name, e -> e.getPrice())));

        System.out.println("=== Task 15: You are given a wordsMap Finds all unique words across all sentences.");


        System.out.println(mapWords.stream().map(wor ->wor.split(" ")).flatMap(w -> Arrays.stream(w)).distinct().toList());


        System.out.println("=== Task 16: Collects the products into a TreeSet based on their price.");

        System.out.println(products.stream().collect(Collectors.groupingBy(Product::getPrice,
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingDouble(Product::getPrice))))));

        List<Person> empss = Arrays.asList(
                new Person("Alice", 30, "Employee"),
                new Person("Bob", 40, "Employee"),
                new Person("Charlie", 30, "Employee")
        );

        List<Person> contractors = Arrays.asList(
                new Person("David", 30, "Contractor"),
                new Person("Eve", 40, "Contractor"),
                new Person("Frank", 25, "Contractor")
        );

        System.out.println("=== Task 17: Combining two streams");


        System.out.println(Stream.concat(empss.stream(), contractors.stream()).collect(Collectors.groupingBy(Person::getAge)));


        System.out.println("=== Task 18 : You are given a List<Person>. Write a stream that:\n" +
                "\n" +
                "Groups the persons by their age.\n" +
                "For each group, collect the names into a List<String>.\n" +
                "Sort the names alphabetically within each age group.");

        empss.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(e -> e.getName(), Collectors.toList()))).entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey() , e -> {List<String> li = e.getValue().stream().sorted().toList();
                    return li; }));

        System.out.println("=== Task 19: Concatenates the wordsList that are longer than 3 characters, converting them to uppercase.");
        System.out.println(words.stream().filter(w -> w.length()>3).map( wo -> wo.toUpperCase()).collect(Collectors.joining(",")));

    }

}