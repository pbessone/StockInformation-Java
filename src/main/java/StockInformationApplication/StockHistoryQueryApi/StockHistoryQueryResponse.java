package StockInformationApplication.StockHistoryQueryApi;

public class StockHistoryQueryResponse {
    private String shareName;
    private String currency;
    private int priceHint;
    private StockHistory history;

    public StockHistoryQueryResponse() {
        this.history = new StockHistory();
    }

    public String getShareName() {
        return shareName;
    }

    public void setShareName(String shareName) {
        this.shareName = shareName;
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

    public StockHistory getHistory() {
        return history;
    }

    public void setHistory(StockHistory history) {
        this.history = history;
    }
}
