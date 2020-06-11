package StockInformationApplication.YahooFinanceApi;

import StockInformationApplication.YahooFinanceApi.Models.ApiResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class YahooFinanceQueryService {
    private final String baseUrl = "https://query1.finance.yahoo.com/v8/finance/chart";

    public ApiResponse Query(String symbol, String range, String interval) throws IOException, InterruptedException {
        var url = StringUtils.join(this.baseUrl, "/", symbol, "?range=", range, "&interval=", interval);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        ApiResponse apiResponse = null;
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        var mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        apiResponse = mapper.readValue(response.body(), ApiResponse.class);

        return apiResponse;
    }
}
