package StockInformationApplication.YahooFinanceStockHistoryQueryApi;

import StockInformationApplication.StockHistoryQueryApi.InvalidRequestException;
import StockInformationApplication.StockHistoryQueryApi.StockHistoryQueryRange;
import StockInformationApplication.StockHistoryQueryApi.StockHistoryQueryResponse;
import StockInformationApplication.StockHistoryQueryApi.StockHistoryQueryService;
import StockInformationApplication.YahooFinanceApi.YahooFinanceQueryService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class YahooFinanceStockHistoryQueryService implements StockHistoryQueryService {

    private YahooFinanceQueryService queryService;
    private YahooFinanceRangeConverter rangeConverter;
    private YahooFinanceQueryResponseConverter responseConverter;

    public YahooFinanceStockHistoryQueryService(
            YahooFinanceQueryService queryService,
            YahooFinanceRangeConverter rangeConverter,
            YahooFinanceQueryResponseConverter responseConverter)
    {
        this.queryService = queryService;
        this.rangeConverter = rangeConverter;
        this.responseConverter = responseConverter;
    }

    @Override
    public StockHistoryQueryResponse Query(String symbol, StockHistoryQueryRange range) throws IOException, InterruptedException, InvalidRequestException {
        var yahooFinanceRange = rangeConverter.convertFrom(range);
        var yahooFinanceResponse = queryService.Query(symbol, yahooFinanceRange, "1d");

        var error = yahooFinanceResponse.getChart().getError();
        if( error != null && error.getCode() != null) {
            throw new InvalidRequestException(error.getCode(), error.getDescription());
        }

        return responseConverter.convertFrom(yahooFinanceResponse);
    }
}
