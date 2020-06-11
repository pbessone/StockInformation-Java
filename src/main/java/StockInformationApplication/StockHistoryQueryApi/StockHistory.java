package StockInformationApplication.StockHistoryQueryApi;

public class StockHistory {
    private long[] timeStamp;
    private double[] open;
    private double[] low;
    private double[] high;
    private double[] close;

    public StockHistory()
    {
        timeStamp = new long[] {};
        open = new double[] {};
        low = new double[] {};
        high = new double[] {};
        close = new double[] {};
    }

    public long[] getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long[] timeStamp) {
        this.timeStamp = timeStamp;
    }

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

    public double[] getClose() {
        return close;
    }

    public void setClose(double[] close) {
        this.close = close;
    }
}
