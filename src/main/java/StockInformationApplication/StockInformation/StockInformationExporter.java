package StockInformationApplication.StockInformation;

public interface StockInformationExporter {
    String getJsonString(BasicStockInformation info);
}
