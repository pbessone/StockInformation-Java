package StockInformationApplication.YahooFinanceStockHistoryQueryApi;

import StockInformationApplication.StockHistoryQueryApi.StockHistoryQueryResponse;
import StockInformationApplication.YahooFinanceApi.Models.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public class YahooFinanceQueryResponseConverter {
    public StockHistoryQueryResponse convertFrom(ApiResponse queryResponse) {
        if (queryResponse == null)
        {
            return null;
        }

        var result = queryResponse.getChart().getResult()[0];
        var quoteIndicators = result.getIndicators().getQuote()[0];
        var meta = result.getMeta();
        var stockHistoryQueryResponse = new StockHistoryQueryResponse();
        stockHistoryQueryResponse.setShareName(meta.getSymbol());
        stockHistoryQueryResponse.setCurrency(meta.getCurrency());
        stockHistoryQueryResponse.setPriceHint(meta.getPriceHint());

        // If timestamp is null it means there are no results for the period so we can simply ignore
        var timestamp = result.getTimestamp();
        if (timestamp != null)
        {
            var history = stockHistoryQueryResponse.getHistory();
            history.setTimeStamp(timestamp);
            history.setOpen(quoteIndicators.getOpen());
            history.setClose(quoteIndicators.getClose());
            history.setLow(quoteIndicators.getLow());
            history.setHigh(quoteIndicators.getHigh());
        }

        return stockHistoryQueryResponse;
    }
}
