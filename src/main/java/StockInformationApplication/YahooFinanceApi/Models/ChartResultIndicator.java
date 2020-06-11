package StockInformationApplication.YahooFinanceApi.Models;

public class ChartResultIndicator {
    private ChartResultIndicatorQuote[] quote;
    private ChartResultIndicatorAdjClose[] adjClose;

    public ChartResultIndicatorQuote[] getQuote() {
        return quote;
    }

    public void setQuote(ChartResultIndicatorQuote[] quote) {
        this.quote = quote;
    }

    public ChartResultIndicatorAdjClose[] getAdjClose() {
        return adjClose;
    }

    public void setAdjClose(ChartResultIndicatorAdjClose[] adjClose) {
        this.adjClose = adjClose;
    }
}
