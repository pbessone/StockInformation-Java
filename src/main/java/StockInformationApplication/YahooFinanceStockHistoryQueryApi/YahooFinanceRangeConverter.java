package StockInformationApplication.YahooFinanceStockHistoryQueryApi;

import StockInformationApplication.StockHistoryQueryApi.StockHistoryQueryRange;
import StockInformationApplication.YahooFinanceApi.YahooRange;
import org.springframework.stereotype.Service;

@Service
public class YahooFinanceRangeConverter {
    public String convertFrom(StockHistoryQueryRange range){
        switch (range)
        {
            case OneDay:
                return YahooRange.OneDay;
            case OneWeek:
                return YahooRange.FiveDays;
            case OneMonth:
                return YahooRange.OneMonth;
            case ThreeMonths:
                return YahooRange.ThreeMonths;
            default:
                throw new UnsupportedOperationException("The range requested is not supported by this api.");
        }
    }
}
