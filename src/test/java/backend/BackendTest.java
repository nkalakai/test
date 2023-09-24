package backend;

import backend.data.UserToBuild;
import org.junit.jupiter.api.Test;
import backend.data.ResponseCreateUser;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackendTest {
    HttpClient httpClient = HttpClient.newHttpClient();
    Gson gson = new Gson();
    private static final String BEARER = "Bearer 345353434bbgffgbhghr44564b4";
    private static final String HOME_URL = "https://dummy.restapiexample.com";
    private static final String email = String.format(
            "test_%s@test.com", new SimpleDateFormat("yyyyMMdd_HHmmssSS").format(new Date()));

    @Test
    public void createUser() throws IOException, InterruptedException {
        String endpointCreateUser = "/api/v1/create";

        UserToBuild userFromBuilder = new UserToBuild.UserToBuildBuilder()
                .setId(23895)
                .setName("Nazar")
                .setGender("male")
                .setEmail(email)
                .setStatus("active")
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Accept", "*/*")
                .header("Content-Type", "application/json")
                .header("Authorization", BEARER)
                .uri(URI.create(HOME_URL + endpointCreateUser))
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(userFromBuilder)))
                .build();
        HttpResponse<String> createUserResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(200, createUserResponse.statusCode());

        String endpointEmployees = "/api/v1/employees";
        HttpRequest request1 = HttpRequest.newBuilder()
                .header("Accept", "*/*")
                .header("Content-Type", "application/json")
                .header("Authorization", BEARER)
                .uri(URI.create(HOME_URL + endpointEmployees))
                .GET()
                .build();
        HttpResponse<String> employeesUserResponse = httpClient.send(request1, HttpResponse.BodyHandlers.ofString());
        var extractedUser = gson.fromJson(employeesUserResponse.body(), ResponseCreateUser.class);
        Assertions.assertEquals(userFromBuilder.getEmail(), extractedUser.getEmail());
    }
}
