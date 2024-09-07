import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class WordClockRestServer {

    public static void main(String[] args) throws IOException {
        // Create an HttpServer instance bound to a specific address and port
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // Set up the context and handler
        server.createContext("/current-time", new TimeHandler());

        // Start the server
        server.setExecutor(null); // Creates a default executor
        server.start();
        System.out.println("Server is listening on http://localhost:8000/current-time");
    }

    // Handler class for processing requests
    static class TimeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Get the current date and time in ISO 8601 format
            String currentDateTime = DateTimeFormatter.ISO_INSTANT
                    .withZone(ZoneOffset.UTC)
                    .format(Instant.now());

            // Create the JSON response
            String jsonResponse = "{ \"currentDateTime\":\"" + currentDateTime + "\" }";

            // Set the response headers and body
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);

            // Write the response body
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(jsonResponse.getBytes());
            }
        }
    }
}

