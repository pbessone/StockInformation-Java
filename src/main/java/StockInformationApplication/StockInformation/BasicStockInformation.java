package StockInformationApplication.StockInformation;

public class BasicStockInformation {
    private String stockName;
    private String currency;
    private int priceHint;
    private double minimumStockPriceForPeriod;
    private double maximumStockPriceForPeriod;
    private double averageStockPriceForPeriod;

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPriceHint() {
        return priceHint;
    }

    public void setPriceHint(int priceHint) {
        this.priceHint = priceHint;
    }

    public double getMinimumStockPriceForPeriod() {
        return minimumStockPriceForPeriod;
    }

    public void setMinimumStockPriceForPeriod(double minimumStockPriceForPeriod) {
        this.minimumStockPriceForPeriod = minimumStockPriceForPeriod;
    }

    public double getMaximumStockPriceForPeriod() {
        return maximumStockPriceForPeriod;
    }

    public void setMaximumStockPriceForPeriod(double maximumStockPriceForPeriod) {
        this.maximumStockPriceForPeriod = maximumStockPriceForPeriod;
    }

    public double getAverageStockPriceForPeriod() {
        return averageStockPriceForPeriod;
    }

    public void setAverageStockPriceForPeriod(double averageStockPriceForPeriod) {
        this.averageStockPriceForPeriod = averageStockPriceForPeriod;
    }
}
