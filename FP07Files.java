import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FP07Files {

    public static void main(String[] args) throws IOException {

        Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);

       Files.lines(Paths.get("dummy.json"))
               .forEach(data -> {
                            String jsonContent = new String(data.getBytes());
                   System.out.println(jsonContent.toLowerCase());

               });

//
//        try (Files.lines(Paths.get("dummy.json")) {
//            paths.filter(Files::isRegularFile) // Filter to ensure it's a file
//                    .filter(path -> path.toString().endsWith(".json")) // Filter for JSON files
//                    .forEach(path -> {
//                        try {
//                            // Read the JSON content from the file
//                            String jsonContent = new String(Files.readAllBytes(path));
//
//                            // Parse the JSON content
//
//
//                            // Process the JSON content (for example, print the content)
//                            System.out.println("File: " + path.getFileName());
//                            System.out.println("Content: " + jsonContent);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
