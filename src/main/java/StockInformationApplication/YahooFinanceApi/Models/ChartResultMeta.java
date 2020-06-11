package StockInformationApplication.YahooFinanceApi.Models;

public class ChartResultMeta {
    private String currency;
    private String symbol;
    private String exchangeName;
    private String instrumentType;
    private int gmtoffset;
    private String timezone;
    private String exchangeTimezoneName;
    private double regularMarketPrice;
    private double chartPreviousClose;
    private int priceHint;
    private String[] validRanges;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public int getGmtoffset() {
        return gmtoffset;
    }

    public void setGmtoffset(int gmtoffset) {
        this.gmtoffset = gmtoffset;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getExchangeTimezoneName() {
        return exchangeTimezoneName;
    }

    public void setExchangeTimezoneName(String exchangeTimezoneName) {
        this.exchangeTimezoneName = exchangeTimezoneName;
    }

    public double getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(double regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public double getChartPreviousClose() {
        return chartPreviousClose;
    }

    public void setChartPreviousClose(double chartPreviousClose) {
        this.chartPreviousClose = chartPreviousClose;
    }

    public int getPriceHint() {
        return priceHint;
    }

    public void setPriceHint(int priceHint) {
        this.priceHint = priceHint;
    }

    public String[] getValidRanges() {
        return validRanges;
    }

    public void setValidRanges(String[] validRanges) {
        this.validRanges = validRanges;
    }
}
