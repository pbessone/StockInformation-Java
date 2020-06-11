package StockInformationApplication.StockInformation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class BasicStockInformationExporter implements StockInformationExporter{
    public String getJsonString(BasicStockInformation info) {
        String jsonString = null;
        try {
            var obj = new ObjectMapper();
            jsonString = obj.writeValueAsString(info);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}
