package exercises;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class SalesRecord {
    private String salesPerson;
    private String region;
    private double salesAmount;

    // Constructor
    public SalesRecord(String salesPerson, String region, double salesAmount) {
        this.salesPerson = salesPerson;
        this.region = region;
        this.salesAmount = salesAmount;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public String getRegion() {
        return region;
    }

    public double getSalesAmount() {
        return salesAmount;
    }
}

public class SalesManager {

    public static void main(String[] args) {

        List<SalesRecord> salesRecords = Arrays.asList(
                new SalesRecord("Alice", "North", 1200.50),
                new SalesRecord("Bob", "South", 1500.75),
                new SalesRecord("Alice", "East", 800.25),
                new SalesRecord("Bob", "North", 1300.00),
                new SalesRecord("Charlie", "West", 1100.50),
                new SalesRecord("Charlie", "East", 950.25)
        );


        /**
         *
         * Flatten the list of sales records across all regions.
         * Group the sales records by salesPerson.
         * Calculate the total sales amount for each salesperson.
         * Sort the salespeople by their total sales amount in descending order.
         * Return a Map where each key is the salesperson's name, and the value is their total sales amount. Print this map.
         */
        System.out.println(salesRecords.stream().map(sale -> sale.getRegion()).collect(Collectors.toSet()));
        System.out.println(salesRecords.stream().collect(Collectors.groupingBy(SalesRecord::getSalesPerson, Collectors.mapping(sale -> sale.getSalesAmount() +" " +sale.getRegion(), Collectors.toList()))));
        System.out.println(salesRecords.stream().collect(Collectors.groupingBy(SalesRecord::getSalesPerson, Collectors.summingDouble(SalesRecord::getSalesAmount))));

        System.out.println(salesRecords.stream().collect(Collectors.groupingBy(SalesRecord::getSalesPerson, Collectors.summingDouble(SalesRecord::getSalesAmount))).entrySet()
                .stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).toList());
        salesRecords.stream().collect(Collectors.groupingBy(SalesRecord::getSalesPerson, Collectors.summingDouble(SalesRecord::getSalesAmount)))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, value -> value.getValue())).entrySet().forEach(ent -> System.out.println(ent.getKey() +"total sale is: "+ ent.getValue()));

    }
}
