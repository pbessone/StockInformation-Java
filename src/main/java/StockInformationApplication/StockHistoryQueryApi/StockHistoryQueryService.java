package StockInformationApplication.StockHistoryQueryApi;

import java.io.IOException;

public interface StockHistoryQueryService {
    StockHistoryQueryResponse Query(String symbol, StockHistoryQueryRange range) throws IOException, InterruptedException, InvalidRequestException;
}
