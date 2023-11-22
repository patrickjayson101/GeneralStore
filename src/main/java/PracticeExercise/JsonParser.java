package PracticeExercise;

import java.io.IOException;
import java.io.File; 
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
    public static void main(String[] args) {
        try {
            // Create an ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON from a file
            JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\COLLABERA\\eclipse-workspace\\GeneralStore\\src\\main\\java\\resources\\Test.json"));

            // Query JSON data
            String name = jsonNode.get("id").asText();
            String age = jsonNode.get("email").asText();

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}