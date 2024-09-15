package exercises.general;


import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    private Date date;
    private double amount;
    private String category;

    // Constructor
    public Transaction(Date date, double amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}

public class TransactionManager {

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(new GregorianCalendar(2024, Calendar.MAY, 20).getTime(), 200.0, "Groceries"),
                new Transaction(new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), 200.0, "Groceries"),
                new Transaction(new GregorianCalendar(2024, Calendar.AUGUST, 22).getTime(), 150.0, "Electronics"),
                new Transaction(new GregorianCalendar(2024, Calendar.SEPTEMBER, 1).getTime(), 300.0, "Groceries"),
                new Transaction(new GregorianCalendar(2024, Calendar.SEPTEMBER, 5).getTime(), 250.0, "Clothing"),
                new Transaction(new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), 100.0, "Electronics"),
                new Transaction(new GregorianCalendar(2024, Calendar.SEPTEMBER, 15).getTime(), 400.0, "Clothing")
        );

        /**
         *
         * Filter the transactions to include only those within the last 30 days.
         * Group the filtered transactions by category.
         * Calculate the total amount spent for each category.
         * Sort the categories by total amount spent in descending order.
         * Print the category along with its total amount spent.
         */

        System.out.println(transactions.stream().filter(transaction -> {
            Date currentDate = new Date();
            Calendar thirtyDaysAgoCalendar = Calendar.getInstance();
            thirtyDaysAgoCalendar.setTime(currentDate);
            thirtyDaysAgoCalendar.add(Calendar.DAY_OF_MONTH, -30);
            Date thirtyDaysAgo = thirtyDaysAgoCalendar.getTime();
            return transaction.getDate().after(thirtyDaysAgo) && transaction.getDate().before(currentDate);
        }).map(trans -> List.of(trans.getDate(), trans.getAmount(), trans.getCategory())).toList());

        System.out.println(transactions.stream().filter(transaction -> {
            Date currentDate = new Date();
            Calendar thirtyDaysAgoCalendar = Calendar.getInstance();
            thirtyDaysAgoCalendar.setTime(currentDate);
            thirtyDaysAgoCalendar.add(Calendar.DAY_OF_MONTH, -30);
            Date thirtyDaysAgo = thirtyDaysAgoCalendar.getTime();
            return transaction.getDate().after(thirtyDaysAgo) && transaction.getDate().before(currentDate);
        }).collect(Collectors.groupingBy(Transaction::getCategory, Collectors.mapping(trans -> trans.getDate() +":"+trans.getAmount(), Collectors.toList()))));

        System.out.println(transactions.stream().collect(Collectors.groupingBy(Transaction::getCategory, Collectors.summingDouble(Transaction::getAmount))));

        transactions.stream().collect(Collectors.groupingBy(Transaction::getCategory, Collectors.summingDouble(Transaction::getAmount))).entrySet()
                .stream().sorted(Map.Entry.comparingByValue()).forEach(kv -> System.out.println(kv.getKey()+": value is:"+kv.getValue()));
    }
}

