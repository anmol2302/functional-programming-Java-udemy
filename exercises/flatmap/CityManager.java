package exercises.flatmap;

import java.util.List;

public class CityManager {
    public static List<String> getUniqueCities(List<Company> companies) {


        return companies.stream().flatMap(com -> com.getOffices().stream())
                .map(office -> office.getCity())
                .distinct()
                .sorted()
                .toList();
    }
}
