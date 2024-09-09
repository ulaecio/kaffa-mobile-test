import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class WorldClockRestClient {

    public static void main(String[] args) {
        try {
            // Create an HTTP client
            HttpClient client = HttpClient.newHttpClient();

            // Create an HTTP GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://worldclockapi.com/api/json/utc/now"))
                    .GET()
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Extract the currentDateTime field manually from the JSON response
            String responseBody = response.body();
            String utcDateTimeString = extractDateTime(responseBody);

            // Convert the UTC time to ZonedDateTime
            ZonedDateTime utcDateTime = ZonedDateTime.parse(utcDateTimeString, DateTimeFormatter.ISO_DATE_TIME);

            // Get the local time from the UTC time
            ZonedDateTime localDateTime = utcDateTime.withZoneSameInstant(ZoneId.systemDefault());

            // Display the UTC and Local times
            System.out.println("UTC Time: " + utcDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            System.out.println("Local Time: " + localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String extractDateTime(String jsonResponse) {
        // Find the position of the "currentDateTime" key
        String key = "\"currentDateTime\":\"";
        int startIndex = jsonResponse.indexOf(key) + key.length();
        int endIndex = jsonResponse.indexOf("\"", startIndex);

        // Extract the datetime string
        return jsonResponse.substring(startIndex, endIndex);
    }
}
