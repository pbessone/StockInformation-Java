package StockInformationApplication.StockInformation;

import StockInformationApplication.StockHistoryQueryApi.InvalidRequestException;

import java.io.IOException;

public interface StockInformationService {
    BasicStockInformation getBasicStockInformationAsync(String symbol) throws InvalidRequestException, IOException, InterruptedException;
}
