package StockInformationApplication.YahooFinanceApi.Models;

public class ChartResult {
    private ChartResultMeta meta;
    private long[] timestamp;
    private ChartResultIndicator indicators;

    public ChartResultMeta getMeta() {
        return meta;
    }

    public void setMeta(ChartResultMeta meta) {
        this.meta = meta;
    }

    public long[] getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long[] timestamp) {
        this.timestamp = timestamp;
    }

    public ChartResultIndicator getIndicators() {
        return indicators;
    }

    public void setIndicators(ChartResultIndicator indicators) {
        this.indicators = indicators;
    }
}
