package StockInformationApplication.YahooFinanceApi.Models;

public class ChartResultIndicatorQuote {
    private double[] open;
    private double[] low;
    private double[] high;
    private double[] volume;
    private double[] close;

    public double[] getOpen() {
        return open;
    }

    public void setOpen(double[] open) {
        this.open = open;
    }

    public double[] getLow() {
        return low;
    }

    public void setLow(double[] low) {
        this.low = low;
    }

    public double[] getHigh() {
        return high;
    }

    public void setHigh(double[] high) {
        this.high = high;
    }

    public double[] getVolume() {
        return volume;
    }

    public void setVolume(double[] volume) {
        this.volume = volume;
    }

    public double[] getClose() {
        return close;
    }

    public void setClose(double[] close) {
        this.close = close;
    }
}
