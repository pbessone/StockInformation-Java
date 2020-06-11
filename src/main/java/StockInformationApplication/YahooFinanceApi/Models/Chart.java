package StockInformationApplication.YahooFinanceApi.Models;

public class Chart {
    private ChartResult[] result;
    private ChartError error;

    public ChartResult[] getResult() {
        return result;
    }

    public void setResult(ChartResult[] result) {
        this.result = result;
    }

    public ChartError getError() {
        return error;
    }

    public void setError(ChartError error) {
        this.error = error;
    }
}
